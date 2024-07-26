pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *') // This sets the polling interval to every 5 minutes
    }

    stages {
        stage('Checkout') {
            steps {
                // Specify the SCM configuration with credentials
                checkout([$class: 'GitSCM',
                           branches: [[name: '*/develop']],
                           userRemoteConfigs: [[url: 'https://github.com/your-repo.git', credentialsId: 'your-credentials-id']]])
            }
        }
        stage('Build') {
            steps {
                // Your build steps go here
                echo 'Building...'
            }
        }
        stage('Test') {
            steps {
                // Your test steps go here
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                // Your deploy steps go here
                echo 'Deploying...'
            }
        }
    }
}
