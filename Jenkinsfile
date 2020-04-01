pipeline { 
    agent any  
    tools {
        maven 'maven'
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
