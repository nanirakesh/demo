pipeline {
    agent none

    stages {
        stage('Run in Docker') {
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-21-alpine'
                }
            }
            steps {
                sh 'mvn -v'
            }
        }
    }
}
