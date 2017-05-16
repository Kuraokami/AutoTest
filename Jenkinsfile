pipeline {
  agent any
  stages {
    stage('Clean Stuff') {
      steps {
        echo 'Clean'
        sh '''mvn clean
'''
      }
    }
    stage('Compile') {
      steps {
        echo 'Compile Stuff'
        sh 'mvn compile'
      }
    }
    stage('Test') {
      steps {
        echo 'Test'
        sh 'mvn test'
      }
    }
  }
}