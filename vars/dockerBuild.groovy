def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "sudo docker build --build-arg REACT_APP_RAPID_API_KEY=5af9c8edd2msh5ca873f44d76f38p10ffdfjsnc0da93cb188a -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}