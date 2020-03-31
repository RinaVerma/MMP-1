pipeline {
  agent any
  tools { 
        maven 
        jdk 'java_home' 
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
