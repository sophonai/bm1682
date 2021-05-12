#!/usr/bin/env groovy
pipeline {
    agent any
    triggers {
        pollSCM ('H/5 * * * *')
    }
    options {
        lock resource: 'GITBOOK_API_LOCK'
    }
    environment {
        RELEASE_DIR = "/data2/gitbook/${env.JENKINS_BUILD_BRANCH}"
    }
    stages {

        stage('Build') {
            steps {
                println "begin of Build: ${currentBuild.result}"
                withDockerContainer(args: '-u 0:0', image: 'fellah/gitbook:latest') {
                    sh "gitbook build --timing;chown 1000:1000 -R ./"
                }
                println "end of Build: ${currentBuild.result}"
            }
        }

         stage('Deploy') {
            steps {
                println "begin of Deploy: ${currentBuild.result}"
                fileOperations([folderDeleteOperation("${env.RELEASE_DIR}")])
                dir("${env.WORKSPACE}/_book"){
                    fileOperations([fileCopyOperation(excludes: '', flattenFiles: false, includes: '**', renameFiles: false, sourceCaptureExpression: '', targetLocation: "${env.RELEASE_DIR}", targetNameExpression: '')])
                }
                println "begin of Deploy: ${currentBuild.result}"
            }
        }

        stage('Mail') {
            steps {
                println "begin of Mail: ${currentBuild.result}"
                println "Step: Mail"
                println "end of Mail: ${currentBuild.result}"
            }
        }
    }
}
