import java.text.SimpleDateFormat
import java.lang.String

node {
    //Step #1. checkout the files
    stage ("Code checkout")  {
            checkout scm
            // credentialsId: 'dinesh'
            // echo 'Checking out the files from repo...' + env.BRANCH_NAME
            // git 'https://github.com/OctoDevOps/codelab.git'
                }

    stage("Smoke Test"){
        sh './mvnw clean verify'
    }

    stage("Publishing Result"){
        publishHTML (target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'target',
            reportFiles: 'site/sernity/index.html',
            reportName: "UI Test Report"
            ])
     }

}

