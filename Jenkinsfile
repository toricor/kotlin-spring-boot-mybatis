pipeline {
    agent any
    triggers {
      upstream(upstreamProjects: 'CallPipeline')
    }
    stages {
        stage("hello") {
            steps {
                git branch: '*/$branch', credentialsId: 'd585cfdd-fb77-4a02-9f40-60643ab726a1', url: 'https://github.com/toricor/java-spring-boot-mybatis'
                echo "hello world"
            }
        }
    }
}
