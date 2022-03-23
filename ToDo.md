
Create a FreeTier

## Java
Create local, remote, virtual maven repo
create policies, rules , watches
Allow anonymous to access the repo read and deploy
Connect the project via Link

jabba use adopt@1.11.0-5
remove the local maven repository
mvn clean
mvn verify

### Install and config the JFrog CLI
install the CLI
jfrog config add
jfrog config show

jfrog rt mvn-config
jfrog audit-mvn

jfrog mvn clean verify -f pom.xml --build-name=20220323-workshop --build-number=20220323-002
jfrog rt bp 20220323-workshop 20220323-002

jfrog s target/helidon-quickstart-se.jar

## Docker
Create local, remote, virtual Docker repo
add docker repos to  policies, rules , watches

docker login svenr-docker.jfrog.io
docker system prune -a  
docker build -t helidon-quickstart-se .
docker run -p 8080:8080 --rm helidon-quickstart-se:latest

docker save helidon-quickstart-se -o target/export.tar
jfrog s target/export.tar

docker tag helidon-quickstart-se svenr-docker.jfrog.io/svenruppert/helidon-quickstart-se:20220323-001
docker push svenr-docker.jfrog.io/svenruppert/helidon-quickstart-se:20220323-001


-> create Access Token for AWS access
-- for user anonymous as user
-- activate the anonymous user - Security section


## usage of the docker image
docker run -p 8080:8080 --rm helidon-quickstart-se:latest
curl -X GET http://localhost:8080/greet/logs
curl -X GET http://localhost:8080/greet/Joe
curl -X GET http://localhost:8080/greet/logs

#########



Links to share

HowTo - JFrog CLI - https://www.youtube.com/watch?v=NFcjrJlxX-s

HowTo - Maven Repos - https://www.youtube.com/watch?v=Jja5XMLcSe0

Mutation Testing - https://www.youtube.com/watch?v=6Vej7YEOF8g



