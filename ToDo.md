## Java
jabba use adopt@1.8.0-232
jfrog audit-mvn
jfrog config show
### Install and config the JFrog CLI

jfrog mvn clean verify -f pom.xml --build-name=jvm-freetier-workshop --build-number=20220221-001
jfrog rt bp jvm-freetier-workshop 20220221-001

jfrog s target/helidon-quickstart-se.jar

## Docker
docker login svenr-docker.jfrog.io
docker system prune -a  
docker build -t helidon-quickstart-se .
docker run -p 8080:8080 --rm helidon-quickstart-se:latest

docker save helidon-quickstart-se -o target/export.tar
jfrog s target/export.tar

docker tag helidon-quickstart-se svenr-docker.jfrog.io/svenruppert/helidon-quickstart-se:20211208-001
docker push svenr-docker.jfrog.io/svenruppert/helidon-quickstart-se:20211208-001


curl -X GET http://localhost:8080/greet/logs
curl -X GET http://localhost:8080/greet/Joe
curl -X GET http://localhost:8080/greet/logs






Finding use cases why I am doing this.
More informations about Artifactory
Shorter, no details. The single menue entries are explained during the tasks.



Intro, presentation
Why do you need repositories
What are the differences between locale, remote,virtual
Intro DevSecOps versus DevOps

Using a UseCase like a POC situation as red line.

After every module a quizz to ask what happened right now
Maven und Xray max, all other modules are separate 

Support Stuff must be trained


Add the docu pointing 
to Pipelines: https://www.jfrog.com/confluence/display/JFROG/QuickStart+Guide%3A+JFrog+Free+Cloud+Subscription

