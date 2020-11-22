pipeline{
agent any

stages{
stage("Build") {
    steps {
    sh "mvn -version"
    sh "mvn package"
    }
}

}

post{
always {
cleanWs()
}
}
}