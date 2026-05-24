pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/vaidehee625/expense-tracker-devops.git'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t expense-tracker .'
            }
        }
    }
}