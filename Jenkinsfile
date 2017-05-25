@Library('github.com/victornc83/jenkins-library@master') _

mavenTemplate('prod'){
    def sonarUrl = env.SONAR_URL
    def version = '1.0-SNAPSHOT'

    stage('Deploy in Staging'){
      echo "Tagging image"
      promoteImage('stage', 'prod', 'demodb', version)
      waitDeployIsComplete('prod', 'demodb')
    }

    stage('Regression Tests'){
      echo "Running sanity checks"
    }

    stage('Exposing app') {
      echo "Exposing app in Stage"
      exposeSvc{
          name = 'demodb'
          project = 'prod'
          service = 'demodb'
      }
    }

    stage('Performance Tests'){
      echo "Perf tests"
    }

}
