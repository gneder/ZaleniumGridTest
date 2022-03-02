pipeline {
     agent any

     stages {
         stage('Acceptance Tests') {
             steps {
                 sh 'ls -la'
                 sh "cd /var/jenkins_home/workspace/search-test/ZaleniumGridTest/ && mvn clean test"
             }
         }
     }
}
