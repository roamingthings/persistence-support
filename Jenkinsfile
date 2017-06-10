node("linux && jdk8") {
    stage "Checkout"
    git url: "https://github.com/roamingthings/persistence-support.git"

    dir('auth-server') {
        stage "Build/Analyse/Test"
        sh "./gradlew clean build"
        archiveUnitTestResults()
    }
}

def archiveUnitTestResults() {
    step([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
}
