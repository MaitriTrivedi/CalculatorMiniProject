pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/MaitriTrivedi/CalculatorMiniProject.git'
    }

    stages {
        stage('Clone Git') {
            steps {
                git branch: 'main', url: "${GITHUB_REPO_URL}"
            }
        }

        stage('Build the Maven Project') {
            steps {
                // Build the Maven project
                sh 'mvn clean package'
            }
        }
        
        stage('Test the Maven project') { 
            steps {
                sh 'mvn test' 
            }
        }
         stage('Verify JAR Existence') {
            steps {
                sh 'ls -lh target/'   // Check if the JAR file is actually created
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        // stage('Push Docker Image to Docker Hub') {
        //     steps {
        //         script {
        //             docker.withRegistry('https://index.docker.io/v1/', DOCKER_HUB_CREDENTIALS) {
        //                 sh "docker tag ${DOCKER_IMAGE_NAME} ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest"
        //                 sh "docker push ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest"
        //             }
        //         }
        //     }
        // }

        stage('Push the Docker Image to Docker Hub') {
            steps {
                script{
                    docker.withRegistry('', 'docker_hub') {
                    sh 'docker tag "${DOCKER_IMAGE_NAME}" mtrivedi1410/calculator:latest'
                    sh 'docker push mtrivedi1410/calculator'
                    }
                 }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                    )
                }
            }
        }
    }
}
