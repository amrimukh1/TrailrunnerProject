
pipeline {
  agent any 
  
  
  stages {
    stage('Checkout') {
      steps {
        checkout([$class: 'GitSCM',
        branches: [[name: '*/main']],
        extensions: [[$class: 'CloneOption', timeout: 120]],
        gitTool: 'Default', 
        userRemoteConfigs: [[url: 'https://github.com/amrimukh1/TrailrunnerProject.git']]
    ])
        checkout scm
      }
    }  
    
     stage('Build') {
      steps {
        bat "mvn compile"
      }
    }  
    stage('Test') {
      steps {
        bat "mvn test"
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
  stage('Run Robot Tests'){
       steps{
            script{
           bat 'python -m robot C:/Git/RobotFramework_Lab/test.robot'
           }

       }
        post {
    always {
        robot (
            outputPath: 'C:/Git/RobotFramework_Lab/log.html',
            passThreshold: 80.0,
            unstable: true
                )
            }
            }
        }
        }
}
