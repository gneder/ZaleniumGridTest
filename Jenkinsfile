pipeline {
     agent any

     stages {
         stage('Acceptance Tests') {
             steps {
                 sh 'ls -la'
                 sh "cd /var/jenkins_home/workspace/qa-hall-sgid-acceptance-pipeline/ddm20.sgid/ && mvn clean test"
             }
         }

         stage ('Cucumber Reports') {
            steps {
                cucumber buildStatus: "SUCCESS",
                fileIncludePattern: "**/Cucumber.json",
                jsonReportDirectory: 'ddm20.sgid/target/cucumber-reports/'
            }
        }
     }
}
