pipeline{
agent any

tools{
maven "M3"
}

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