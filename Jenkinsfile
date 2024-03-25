
pipeline {
    agent any
    stages {
        
        stage('Build') {
            steps {
                
                bat 'mvn compile'

                  }
        }
        stage('Test') {
            steps {
               
                bat 'mvn test'

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
        
        stage('Run Robot Tests') {
            steps {
                
                script {

                        bat 'python -m robot C:/Users/amrim/.jenkins/workspace/Amrita/Selenium/test.robot'
                        
                        }
            }
            post {
                always {
                 
                    robot(
                            outputPath: 'C:/Users/amrim/.jenkins/workspace/Amrita',
                            passThreshold: 80.0, onlyCritical: false
                        )
                }
            }
        }
    }
}
