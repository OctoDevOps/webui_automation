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
        def testselected = [];

        try {
            //read all test names
            print "JSON config file content:${tests.uitests}"
            tests.uitests.each{ key,value -> 
                print "value : $key"
                print "displyname:$key.displayname"
                choiceNames.push("$key.displayname")
                }            
            choiceNames =  choiceNames.join("\n")
            echo "Choice Names: [${choiceNames}]"

            timeout(time: 60, unit: 'SECONDS') { // change to a convenient timeout for you
                userInput = input(
                ok:'Yes', message: 'What do you want to do today?', parameters: [
                choice(name: 'Choose the test scope', choices:"$choiceNames" , description: 'Plelase select the test type that you want to perform now.')
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

        echo "[${user}] value selection is :${userInput}"

        tests.uitests.each{ key,value ->         
                if(key.displayname == userInput){
                    testselected = key.tags
                    //print "tags chosen to execute test : $testselected"
                }
            }            
            def tag =  testselected.join(",")
            echo "tags chosen to execute test : ${tag}"

        if (didTimeout) {
            // do something on timeout
            echo "no input was received before timeout. Thus, performing Smoke Test"
            stage("Smoke Test"){
                sh './mvnw clean verify -Dmaven.test.failure.ignore=true -Dcucumber.filter.tags=@smoke'
            }
        } else {
            // do something
            echo "Admin has approved to continue ${userInput}"
                stage("${userInput}"){
                        sh "./mvnw clean verify -Dmaven.test.failure.ignore=true -Dcucumber.filter.tags=${tag} -Denvironment=dev"
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

