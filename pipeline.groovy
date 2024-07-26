pipeline {
    agent any

    triggers {
        pollSCM('H/2 * * * *') // This sets the polling interval to every 5 minutes
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
                echo 'Building 1231423...'
            }
        }
        stage('Test') {
            steps {
                // Your test steps go here
                echo 'Test.........Weimar'
            }
        }
        stage('Deploy') {
            steps {
                // Your deploy steps go here
                echo 'Wie viele SAP Programmierer braucht man, um eine Glühbirne zu wechseln?
Keinen. Das ist ein Hardwareproblem....'
            }
        }
    }
}
