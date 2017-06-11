pipeline {
    agent any

    stages {
        dir('auth-server') {
            stage('Build & Unit Test') {
                steps {
                    sh "./gradlew -Dgradle.user.home=$HOME/.gradle clean build"
                    step([$class: "JUnitResultArchiver", testResults: "build/test-results/test/**/TEST-*.xml"])
                }
            }

            stage('Integration Test') {
                steps {
                    sh "./gradlew -Dgradle.user.home=$HOME/.gradle integrationtest"
                    step([$class: "JUnitResultArchiver", testResults: "build/test-results/integrationTest/**/TEST-*.xml"])
                }
            }
        }
    }
}