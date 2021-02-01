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

    stage("Test"){
        def userInput = true
        def didTimeout = false
        def tests = readJSON file: "${env.WORKSPACE}/testConfig.json"
        def choiceNames = []


        try {
            //read all test names
            print "$tests['WebUI_tests']"
            tests["WebUI_tests"].each{
                key,value -> 
                print "$value"
                choiceNames.push(value["displayname"])
                } 
            choiceNames =  choiceNames.join["\n"]
            echo "Choice Names: [${choiceNames}]"

            timeout(time: 60, unit: 'SECONDS') { // change to a convenient timeout for you
                userInput = input(
                ok:'Yes', message: 'What do you want to do today?', parameters: [
                //choice(name: 'Choose the test scope', choices: 'smoke\nrelease', description: 'What is the test scope?')
                choice(name: 'Choose the test scope', choices:$choiceNames , description: 'What is the test scope?')
                ])
            }
        } catch(err) { // timeout reached or input false
            def user = err.getCauses()[0].getUser()
            if('SYSTEM' == user.toString()) { // SYSTEM means timeout.
                didTimeout = true
            } else {
                userInput = false
                echo "Aborted by: [${user}]"
            }
        }

        if (didTimeout) {
            // do something on timeout
            echo "no input was received before timeout. Thus, performing Smoke Test"
            stage("Smoke Test"){
                sh './mvnw clean verify -Dmaven.test.failure.ignore=true -Dcucumber.filter.tags="@smoke"'
            }
        } else if (userInput == 'smoke') {
            // do something
            echo "Admin has approved to continue smoke testing"
                stage("Smoke Test"){
                        sh './mvnw clean verify -Dmaven.test.failure.ignore=true -Dcucumber.filter.tags="@smoke"'
                    }
        } else if (userInput == 'release'){
            // do something else
            echo "Admin has approved to continue Regression testing"
                stage("Regression Testing"){
                    sh './mvnw clean verify -Dmaven.test.failure.ignore=true -Dcucumber.filter.tags="@regression"'
                }
        } 
    }

    stage("Publishing Result"){
        publishHTML (target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'target/site/serenity',
            reportFiles: 'index.html',
            reportName: "WebUI Test Report"
            ])
     }

}

