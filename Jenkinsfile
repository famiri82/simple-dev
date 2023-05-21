pipeline {
	agent any
	tools {
	    maven 'maven3'
	    jdk 'openjdk-17'
	}
	stages{
        stage('Build'){
            steps{
                 sh script: 'mvn clean package'
            }
        }
        stage('Upload War To Nexus'){
            steps{
                 nexusArtifactUploader artifacts: [
                    [
                         artifactId: 'simple-dev',
                         classifier: '',
                         file: 'target/simple-dev.jar',
                         type: 'jar'
                    ]
                ],
                 credentialsId: 'nexus3',
                 groupId: 'de.farzaneh',
                 nexusUrl: 'localhost:8081',
                 nexusVersion: 'nexus3',
                 protocol: 'http',
                 repository: 'farzaneh-maven-releases',
                 version: '0.0.5'
            }
        }
	}
}

