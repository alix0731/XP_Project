pipeline{
agent any

stages{
stage("Build") {
    steps {
    sh "mvn -version"
    sh "mvn clean"
    }
}

}

post{
always {
cleanWs()
}
}
}