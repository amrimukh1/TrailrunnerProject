pipeline {
  agent any 
  
  
  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/amrimukh1/TrailrunnerProject.git'
      }
    }  
    
    stage('Build') {
      steps {
        sh "mvn compile"
      }
    }  
    stage('Test') {
      steps {
        sh "mvn test"
      }
     post {
      always {
        jacoco(
          execPattern: 'target/*.exec',
          classPattern: 'target/classes',
          sourcePattern: 'src/main/java',
          exclusionPattern: 'src/test*'
          )
        junit '**/TEST*.xml'
      }
     }
  }
 }
}