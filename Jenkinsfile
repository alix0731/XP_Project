pipeline{
agent any

tools{
maven "M3"
}

stages{
stage("Build") {
    steps {
    sh "sudo kill -9 `sudo lsof -t -i:8081`"
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