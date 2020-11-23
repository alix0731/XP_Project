pipeline{
agent any

tools{
maven "M3"
}

stages{
stage("Build") {
    steps {
    sh "fuser -n tcp -k 8081"
    sh "mvn -version"
    sh "mvn package"
    sh "java -jar target/project-0.0.1-SNAPSHOT.jar"
    }


}

}

post{
always {
cleanWs()
}
}
}