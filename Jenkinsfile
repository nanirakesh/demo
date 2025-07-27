pipeline {
    agent none

    stages {
        stage('Run in Docker') {
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-21-alpine'
                    reuseNode true
                }
            }
            steps {
                sh '''
                ls  -la
                mvn -version
                '''
            }
        }
    }
}
