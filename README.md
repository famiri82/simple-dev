## Dockerize Spring Boot Application with H2 Maven using build:

1. for the name of jar file, add this line to pom.xml after <build>:
   <finalName>simple-dev</finalName>
2. change properties file if needed for h2 console
4. generate jar file: maven install
5. for running this jar file we always use this command: **java -jar <jar-file-name>**
5. Go to the root directory of project, and create **Dockerfile**
6. - **From:openjdk:17**: base image from 
- **COPY target/simple-dev.jar simple-dev.jar** : copy instruction >>> (source: (*jar file*) to destination: (*image file name*))
- **ENTRYPOINT ["java", "-jar", "/simple-dev.jar"]** : this takes an array 
7. in the root project open the terminal: **docker build -t simple-dev:latest .** here **.** means current directory
8. after build was successful docker imag will be created : use **docker images** to see image
9. start this image inside container: **docker run -p 8083:8082 <image-id>** p means port, host-port: container-port, we can not access our application inside the container therefore we need to map the ports, then we can access our application outside the container
10. if we go to postman we can access our application with the port 8083 : http://localhost:8083/users-location
11. ``crl + c`` stops the running container
12. show the container: **docker ps -a**
13. start the container: **docker start <container-id>/<image-id>**
14. check the logs: **docker logs <container-id>**
15. watch the logs continuously **docker logs -f <container-id>**
16. remove container **docker rm <container-id>**
17. to create an image from container: **docker commit <container> <image>**
18. to go inside docker container files: **docker exec -it my-jenkins /bin/bash **
19. connect existing container to a network: **docker network connect <network-name> <container-name> **


# Jenkins
1. pipeline syntax: https://www.jenkins.io/doc/book/pipeline/syntax/
2. jenkins url in local: http://localhost:8181/
2. starts with: **pipeline{**
3. agent: the agent where this pipeline should be execute
- *any* means execute on master or slave, whichever is available and convenient for our master jenkins
4. **tools** : maven (we use **Declarative Directive Generator** in jenkins >>> Tools, Maven, Generate => now the script will be created )
then we can use the syntax of maven in stages
5. stages: 
- git checkout (here we put our jenkins file inside project so we dont need this stage)
- build
6. **sh** for shell scrips **Snippet Generator** choose Shell Script then write *mvn clean package* it will generate sh command *sh script:*
7. To pull out script from git >>>> create a pipeline in jenkins, choose **Pipeline script from SCM** 
it checks our source code from git, so we do not say git stage in our pipeline again
8. nexus url: **composetest-nexus-1:8081** , *composetest-nexus-1* is the name of nexus container in docker
9. using settings.xml : Global Tool Configuration>> Default global settings provider >>>> File path : settings.xml
10. deploy to nexus with two different ways:
- using *mvn -s settings.xml deploy* stage, we should change version and localhost (with nexus container) in the pom.xml 
- also add settings.xml file in root of project (with changes of localhost to nexus container name)
- in another way we can deploy and upload to nexus using nexusArtifactUploader in the jenkins, then use that inside Jenkinsfile
- in both of the ways we should start our containers (nexus and jenkins) with the same network in the docker, therefore they can see each other
11. useful video: https://www.youtube.com/watch?v=p_Wo3aqUJto&list=PLH1ul2iNXl7sp9w9_QRU4jUvVAuFMoxu2&index=4


    