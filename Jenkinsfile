pipeline {
    agent any

    tools {
        maven 'Maven-3'
    }

    environment {
        IMAGE = "just4coder/customer-app:latest"
        DOCKER_PATH = "C:/Program Files/Docker/Docker/resources/bin"
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Docker Build & Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    bat '''
                        set PATH=%PATH%;%DOCKER_PATH%
                        
                        echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
                        
                        docker buildx build --platform linux/amd64 -t %IMAGE% --push .
                        
                    '''
                }
            }
        }
    }
}
