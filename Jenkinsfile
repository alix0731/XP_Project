pipeline{
agent any

tools{
maven "M3"
}

stages{
stage("Build") {
    steps {
    // stopper port 8080, hvor applicationen kører
        //sh "fuser -n tcp -k 8081"
        sh "if fuser -n tcp -k 8081 then echo 'port is not running' fi"

                            



// sletter den gamle jar file
         sh "mvn clean"
         // opretter en ny jar file med det nye kode
        sh "mvn package"



    }
}

stage("Deploy"){
    steps{
    //kører jar filen
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