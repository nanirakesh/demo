pipeline {
    agent none

    environment {
        JAR_NAME = 'target/app.jar' // Change to 'target/demo-0.0.1-SNAPSHOT.jar' if not using <finalName>
    }

    stages {
        stage('Build & Run Spring Boot App') {
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-21-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                    reuseNode true
                }
            }

            steps {
                script {
                    echo "🔧 Starting Maven build..."
                    sh 'mvn clean package'

                    echo "📦 Checking built JAR"
                    sh 'ls -lh target/'

                    echo "🚀 Running Spring Boot application"
                    sh """
                        nohup java -jar ${env.JAR_NAME} > app.log 2>&1 &
                        sleep 10
                    """

                    echo "🔍 Running health check"
                    sh """
                        curl -f http://localhost:8080/actuator/health || {
                          echo '❌ Health check failed';
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
            echo "🧹 Cleaning up..."
            sh "pkill -f '${JAR_NAME}' || true"
            sh "cat app.log || true"
        }
    }
}
