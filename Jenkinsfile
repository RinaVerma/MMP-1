pipeline {
  agent any
  tools { 
        maven 'Maven 3.3.9' 
        jdk 'jdk8' 
    }
  stages {
    stage('Execute Selenium Tests from Github Repo Using Jenkins 2.0 Pipeline') {
      steps {
        echo 'Execute Tests'
        sh label: '', script: '''mvn test'''
      }
    } 
  }
}
