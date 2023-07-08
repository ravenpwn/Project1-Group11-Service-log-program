node{
    stage('SonarQube Analysis') {
        def scannerHome = tool 'SonarQube Scanner';withSonarQubeEnv() {sh  "${scannerHome}/bin/sonar-scanner -Dsonar.java.binaries=.  -Dsonar.projectKey=Test -Dsonar.login=squ_c9892daffbb2714637b9e093ecdbcc84648a16a6"}
        }
    }
