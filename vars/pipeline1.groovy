def call() {
    pipeline {
        agent {
            node {
                label 'master-node'
                customWorkspace "c:\\Program Files\\Jenkins Workspace\\"
            }
        }   
        stages {
        stage('Checkout') {
			steps {
				cleanWs()
			    
				checkout scmGit(branches: [[name: 'project/BSEFixAdapter']], extensions: [], userRemoteConfigs: [[credentialsId: '9dc4f8ab-22d0-4a64-83d7-986bd68e4b86', url: 'https://github.com/dbx/ErsteLibs.git']])
				
			}
		}
            stage('Build') {
                steps {
                    echo 'Building...'
                }
            }
            stage('Test') {
                steps {
                    echo 'Testing...'
                }
            }
            stage('Deploy') {
                steps {
                    echo 'Deploying...'
                }
            }
        }
    }
}
