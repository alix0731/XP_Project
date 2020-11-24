pipeline{
agent any

tools{
maven "M3"
}

stages{
stage("Build") {
    steps {
   sh "fuser -n tcp -k 8081"

    sh "mvn clean"
    sh "mvn package"

    }


}

stage("Deploy"){
    sh "java -jar target/project-0.0.1-SNAPSHOT.jar"
steps{

}
}

}

post{
always {
cleanWs()
}
}
}