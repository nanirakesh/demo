pipeline {
    agent none

    environment {
        JAR_NAME = 'target/demo-0.0.1-SNAPSHOT.jar'
    }

    stages {
        stage('Build & Run Spring Boot App') {
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-21-alpine'
                    args '-v ${HOME}/.m2:/root/.m2'
                    reuseNode true
                }
            }

            steps {
                script {
                    echo "🏗️ Building the Spring Boot app..."
                    sh 'mvn clean package'

                    echo "📁 List build artifacts:"
                    sh 'ls -lh target/'

                    echo "🚀 Starting the app in background..."
                    sh """
                        nohup java -jar ${env.JAR_NAME} > app.log 2>&1 &
                        sleep 10
                    """

                    echo "🩺 Health check (Spring Actuator)..."
                    sh """
                        curl -f http://localhost:8080/actuator/health || {
                          echo '❌ App health check failed';
                          cat app.log;
                          exit 1;
                        }
                    """
                }
            }
        }
    }

    post {
        always {
            node('master') { // ✅ Use your actual Jenkins agent label here
                echo "🧹 Cleanup"
                sh "pkill -f '${JAR_NAME}' || true"
                sh "cat app.log || true"
            }
        }
    }
}
