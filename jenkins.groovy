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
        DISABLE_AUTH= 'true'
        REPORT_DIR = "${env.WORKSPACE}@output/robot_reports"
        OTA_DIR = "${env.WORKSPACE}/../se5_ota"
        TFTP_VERIFY_FILE="./output/tftp/tftp.MD5"
        RELEASE_DIR = "/data2/autobuild/SE5/${env.JENKINS_BUILD_BRANCH}/${env.BUILD_NUMBER}"
    }
    stages {
        stage('check out') {
            steps {
                println "begin of Checkout: ${currentBuild.result}"
                dir("${env.WORKSPACE}@workingdir"){
                    checkout([$class: 'RepoScm', currentBranch: true, manifestBranch: "${JENKINS_BUILD_BRANCH}", manifestRepositoryUrl: 'ssh://jimmy.huang@gerrit.ai.bitmaincorp.vip:29418/AI_SE/se_manifests', quiet: true, repoUrl: 'ssh://jimmy.huang@gerrit.ai.bitmaincorp.vip:29418/AI_SE/repo', trace: true])
                }
                println "end of Checkout: ${currentBuild.result}"
            }
        }

        stage('Build') {
            steps {
                println "begin of Build: ${currentBuild.result}"
                step([$class: 'DockerComposeBuilder', dockerComposeFile: "../se-build-server-${env.JENKINS_BUILD_BRANCH}.yml", option: [$class: 'ExecuteCommandInsideContainer', command: 'gitbook build', privilegedMode: false, service: 'gitbook', workDir: '/srv/gitbook'], useCustomDockerComposeFile: true])
                println "middle of Build: ${currentBuild.result}"
                script {
                    //currentBuild.result = 'SUCCESS'
                    if(currentBuild.result != 'SUCCESS') {
                        error "gitbook build error，请查看log！"
                    }
                }
                println "end of Build: ${currentBuild.result}"
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

//得到当前build的变更内容并格式化
//此处需要用NonCPS修饰
@NonCPS
def getFormatedChangeSets() {
    def changes = ""
    def changeLogSets = currentBuild.changeSets
    //for (int i = 0; i < changeLogSets.size(); i++) {
    //    def entries = changeLogSets[i].items
    //    for (int j = 0; j < entries.length; j++) {
    //        def entry = entries[j]
    //        def msg = ${entry.msg}.replace('$', "")
    //        ////echo "${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${msg}"
    //        if (${entry.commitId} == null ) {
    //            continue
    //        }
    //        changes += "${entry.author}:${msg}\n"
    //    }
    //}
    //changes = 'post action 仍然会出错，且只有 scm trigger的才出错，手工trigger是OK的。 去掉gerrtCommitID产生的变更+（） @ &^$测试乱码\n'
    //echo "${changes}"
    //当手工触发时，changSets为空
    if( changes == "") {
        changes = "功能开发中"
    }

    //def new_str = changes.replace('$', "")
    return "'''"+changes+"'''"
}
