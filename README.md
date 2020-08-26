# JFrog-FreeTier-JVM
Workshop for the JFrog FreeTier - JVM - Java and Kotlin




## How to use the Docker Images
In the following examples, I assume that maven organizes the project.
With gradle, it should be the same, but maybe different paths.

If you need a JDK only
```bash
docker run \
       --rm \
       --name run \
       -v "$(pwd)":/usr/src/mymaven \
       -w /usr/src/mymaven \
       svenruppert-docker-local-svenruppert.jfrog.io/svenruppert/adopt:1.8.0-172 \
       java -jar target/myapp.jar
```

If you need maven and a JDK
```bash
docker run \
       --rm \
       --name compile \
       -v "$(pwd)":/usr/src/mymaven \
       -w /usr/src/mymaven \
       svenruppert-docker-local-svenruppert.jfrog.io/svenruppert/maven-3.6.3-adopt:1.8.0-172 \
       mvn clean install -Dmaven.test.skip=true
```
