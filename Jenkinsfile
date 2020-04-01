pipeline { 
    agent any  
    tools {
        maven 'maven'
        jdk 'java_home'
    }
    stages { 
        stage('Build') { 
            steps { 
               echo 'This is a minimal pipeline.' 
               sh 'mvn --version'
               sh 'mvn clean'
               sh 'mvn test'
            }
        }
    }
}
