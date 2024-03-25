/* groovylint-disable-next-line CompileStatic */
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'I am in checkout'
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
                echo 'I am in build'
                bat 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                echo 'I am in Test'
                bat 'mvn test'
            }
        
            
                post {
                    /* groovylint-disable-next-line NestedBlockDepth */

                    /* groovylint-disable-next-line NestedBlockDepth */
                    /* groovylint-disable-next-line NestedBlockDepth */
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
                echo 'I am in cRun Robot tests'
                script {
                    bat 'python -m robot C:/Users/amrim/.jenkins/workspace/Amrita/Selenium/test.robot'
                }
            }
            post {
                always {
                    echo 'I am in post step'
                    robot(
            outputPath: 'C:/Users/amrim/.jenkins/workspace/Amrita',
            passThreshold: 80.0, onlyCritical: false
                )
                }
            }
        }
    }
}
