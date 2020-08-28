# JFrog-FreeTier-JVM
Workshop for the JFrog FreeTier - JVM - Java and Kotlin

Do you have a private project, an open-source tool or want to do a POC? 
Do you already have the idea in mind and you wish to get started? 
On the other hand, are you looking for a suitable environment 
so that you get the best possible support for your development? 

JFrog offers you just the right tools for this. 
You can get access to the JFrog Platform and use it freely. 
Artifactory, Xray, pipelines and more and this means that a 
complete DevSecOps environment is at your disposal.

In this workshop, I will show you the individual components 
step by step and help you set them up for your project. 
This workshop is divided into several parts, 
and each deals with a specific section of the development.

In the basic module, we will set up a project based on maven consisting 
of one module so that you can get started with Java and Kotlin. 

We will set up repositories as well as carry out the first security scans. 
The workshop is rounded off with the use of pipelines 
to provide your project with a simple CI pipeline.

## Requirements on your side

### The IDE
You need an IDE that supports Java and maven. 
I personally using IntelliJ and the screencasts are based on this IDE. 
The free version is perfect for this workshop. But you can use whatever IDE fits your needs.

#### IDE Support for Xray
To have IDE Support based on the Xray Plugin from JFrog, you need one of listed IDEs. 
The actual list is under the 
following URL [https://www.jfrog.com/confluence/display/JFROG/IDE+Integration](https://www.jfrog.com/confluence/display/JFROG/IDE+Integration)

### Docker 
You need Docker on your machine for some parts of this tutorial. 
It is possible to skip this element during the workshop.

### Java and maven
This tutorial is based on Java version 8 or higher and maven. All JDK´s should fit, there are no special 
requirements that I am aware of.
Maven is used in a version higher 3.3. Please make sure you have access to it.
You can use the bundled maven version. The archive is inside the folder **_data/maven** and contains
the maven version 3.6.3 as tar.gz file.


## Timetable and Agenda
The tutorial is planned to be done in approx 2h in total.

The BirdEyeView:
* Intro into the JFrog Platform
* A demo how to use a generic repo
* Docker and the first steps
* Maven and the HelloWorld
* Vulnerabilities and how to visualize them
* Pipelines Intro
* Bonus work - choose an OpenSource Project 
  and bring it into a fresh new FreeTier

10 min: Intro check out the git repository and get the Overview about the JFrog Platform in general
10 min: Short Navigation inside the JFrog Platform as an admin
10 min: Generic Repos and what you could do with it
10 min: 
10 min:
10 min:
10 min:
10 min:
10 min:
10 min:
10 min:
10 min:

## DevOps versus DevSecOps
What is the difference, why we are doing it.
BirdEye View 


## The tutorial itself
Lets start with the tutorial now! The plan is, to finish all steps in approx 2h.
I will give you from time to time some 
additional links to videos to provide additional informations.

### Access to the JFrog Platform
For this tutorial you can use the JFrog Platform based on the FreeTier offer.
This you will find under the URL [http://jfrog.com/start-free](http://jfrog.com/start-free). You do not need credit card 
informations for this and the FreeTier itself is not limited in time. 
If you want to see how to activate the FreeTier from JFrog, have a look at the following video on Youtube.

[![Activate the JFrog FreeTier](http://img.youtube.com/vi/2mQe_WA8Wmw/sddefault.jpg)](http://www.youtube.com/watch?v=2mQe_WA8Wmw "JFrog HowTos - 003 - Free Tier Activation")
[![Activate the JFrog FreeTier](http://img.youtube.com/vi/OjKbxekJhrc/0.jpg)](http://www.youtube.com/watch?v=OjKbxekJhrc "JFrog HowTos - 003 - Free Tier Activation")

## What is JFrog and Why we are using it
* What are the topics we are covering


## Platform Overview
(EN) -
(DE) - 


Finding use cases why I am doing this.
More informations about Artifactory
Shorter, no details. The single menue entries are explained during the tasks.



## create a generic repo for Jabba
Create a generic repo called **generic-local-jabba**. 
Upload the files from your folder **_data/_jabba-0.11.2**
Try to download one file with **curl** and verify that it is a valid archive.
Delete the file **install.sh** from the repo.
Edit the file **install.sh** so that it is using your repository.
Hint: search for **svenruppert.jfrog.io** 
Upload this file again into your repo.

Single File versus Multi File:
Highlight the SetMeUp Button !!!

(EN) -
(DE) -

## create a generic repo for Maven
Repeat and adjust the steps from the previous section to get a 
generic repo called **generic-local-maven**. Upload the file from the 
folder **_data/maven**

## Repo access
Make sure that the two created repositories are accessible for the user *anonymous*.
 
## create a remote Docker Repo

Note: just close the Overlay that says that the DNS record will be created

Create a remote Docker Repo called **docker-remote-dockerio** 
with the target **https://registry-1.docker.io/** 
and try to pull the image **buildpack-deps:buster-curl**
Login into the new Docker Repo.

(EN) -
(DE) -

## create a local Docker Repo
Create a local Docker Repo with the name **docker-local**.
Login into the Docker Repo;

## create a virtual Docker Repo
Create a virtual DockerRepo called **docker-virtual** and include 
the both created Docker repos into it.
Define as default **Deployment Repository** the local one.

## Create and Push Docker Images
After we created the Docker repositories 
it is time to create and push a Docker Image created by ourself.

### Pull an Image
Pull the HelloWorld Image over your created virtual Docker Repository.
After this is done, go to the folder **_data/adopt@1.8.0-172**
Edit the Dockerfile in a way that you are using your generic repo with the Jabba Tool.
Edit the file **build.sh** to use your Docker Repository as well.
Try to build and push the Docker Images.


## create a local maven repo
Create a local Maven Repos called **maven-local-release** and **maven-local-snapshot**

The docu is here [https://www.jfrog.com/confluence/display/RTF6X/Maven+Repository](https://www.jfrog.com/confluence/display/RTF6X/Maven+Repository)

(EN) -
(DE) -

## create a remote Maven repo
Create a remote Maven Repos called **maven-remote-mavencentral** and **maven-remote-jcenter**

## create a virtual maven repo 
Create virtual Maven Repos to aggregate the created repositories
by **snapshot** and **release**.
Define the default deploy repo as well.

## Use the Maven repos
Go to the file **pom.xml** and change it in the way that you are 
using your new created virtual maven repositories. Delete your local **.m2** folder and 
test your config with a **mvn clean verify**. 
Maven should load all dependencies from your new repository now.

### How to use the Docker Images
In the following examples, I assume that maven organizes the project.
With gradle, it should be the same, but maybe different paths. 
Change the Docker Image name to your ones.

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


## secure your platform
TBD -  


## FreeTier Maintenance
To maintain your Platform instance it is good to know that you have the functionality
of a TrashCan. This is good to un-delete a file. On the other side it is 
good to clear the caches from time to time and make sure you are not hitting your limits soon.

For this, check inside the Administration Menu your current Storage usage.
Delete the TrashCan and find out how to clear the cached content from a remote Repository.


## IDE Plugin - Scan for Vulnerabilities
In this section wwe want to scan our dependencies to learn more about vulnerabilities.
The tool that we are using is Xray and integrated into the JFrog Platform. 
It is able to scan all elements that are in Artifactory. Binaries, Buildinfos and so on. 
Your task now: Install the JFrog IDE Plugin and connect to your FreeTier installation.

* (EN) - [https://youtu.be/PsghzAf-ODU](https://youtu.be/PsghzAf-ODU)
* (DE) - [https://www.youtube.com/watch?v=zRzjFhR1OjQ](https://www.youtube.com/watch?v=zRzjFhR1OjQ)

If you want to see it in action scanning a Vaadin webapp check out the following video.
* (EN) - [https://youtu.be/h11zwbamskA](https://youtu.be/h11zwbamskA)
* (DE) - [https://www.youtube.com/watch?v=sTXoWYzSZpI](https://www.youtube.com/watch?v=sTXoWYzSZpI)

## Xray - Watches
Inside the JFrog Platform you can analyse your binaries as well.
For this you need to create Rules, Policies and Watches.
Your next task is:
- create a Rule called **rule-catch-everything** that will scan for all Vulnerabilities.
- based on this Rule, create a Policy called **policy-overview** that consumes the Rule called **rule-catch-everything**
- Now it is time to combine the Policy with your repositories. Call the Watch **panic-watch**
The last step is to trigger the watch to see the results. For this start the re-calculation of the watch manually.

the official docu is here: 
Policies and Rules [https://www.jfrog.com/confluence/display/JFROG/Creating+Xray+Policies+and+Rules](https://www.jfrog.com/confluence/display/JFROG/Creating+Xray+Policies+and+Rules)
Watches [https://www.jfrog.com/confluence/display/JFROG/Configuring+Xray+Watches](https://www.jfrog.com/confluence/display/JFROG/Configuring+Xray+Watches)
of check out my short video:

(EN) -
(DE) -


## AdHoc Vulnerabilities Report
Inside the JFrog Platform you can create AdHoc Vulnerabilities Reports. 
Create a Report called **ad-hoc-panic-report**, select the scope **Repositories** 
and choose all maven and docker repositories we created today. After this press the button **Generate Report**
Select the report and export it as pdf.
The official docu is here: [https://www.jfrog.com/confluence/display/JFROG/Vulnerabilities+Report](https://www.jfrog.com/confluence/display/JFROG/Vulnerabilities+Report)
If you are to lazy to read, try my JFrog HowTo.

(EN) - 
(DE) -

## Start with Pipelines
To start with Pipelines you need to prepare a few things.

### Integrations
Go to the Menuepoint **Applications - Pipelines - Integrations**
Add an integration for GitHub and Artifactory.
The Documentation is here: 
Artifactory [https://www.jfrog.com/confluence/display/JFROG/Artifactory+Integration](https://www.jfrog.com/confluence/display/JFROG/Artifactory+Integration)
GitHub [https://www.jfrog.com/confluence/display/JFROG/GitHub+Integration](https://www.jfrog.com/confluence/display/JFROG/GitHub+Integration)

(EN) - 
(DE) -

### Create a file called mvn-art-config
The file called **mvn-art-config** must be in the root folder of the project and 
will be needed during the pipelines run. 
Take the following snipp and edit it to your needs.

```yaml
version: 1
type: maven
resolver:
  snapshotRepo: maven-virtual-libs-snapshot
  releaseRepo: maven-virtual-libs-release
  serverID: svenruppert_jfrog_io
deployer:
  snapshotRepo: maven-virtual-libs-snapshot
  releaseRepo: maven-virtual-libs-release
  serverID: svenruppert_jfrog_io
```

### Pipeline definition
To define a pipeline you need a file called **pipelines.yml**. 
This file is located in the root folder of this project.

### First section inside pipelines.yml
The docu is here [https://www.jfrog.com/confluence/display/JFROG/Defining+a+Pipeline](https://www.jfrog.com/confluence/display/JFROG/Defining+a+Pipeline)

(EN) - 
(DE) -

```yaml
resources:
  - name: GIT_JFrog_FreeTier_JVM
    type: GitRepo
    configuration:
      gitProvider: github_as_svenruppert            # Change to your integration
      path: Java-Workshops/JFrog-FreeTier-JVM       # Change to your repo
  # Build info for the application
  - name: build_info
    type: BuildInfo
    configuration:
      sourceArtifactory: svenruppert_jfrog_io       # Change to your instance
      buildName: Build_JFrog-FreeTier-JVM
      buildNumber: 1
```

### Maven section inside pipelines.yml
It is time to build the maven project with pipelines. For this 
I provide the first step to run a **mvn clean**.

First, change this step so that it will fit to your environment.
Push the changes to your repo and check 
if the pipeline definition will be loaded and accepted.

```yaml
      - name: maven_build_clean
        type: MvnBuild
        configuration:
          sourceLocation: .
          mvnCommand: clean
          configFileLocation: .
          configFileName: mvn-art-config
          inputResources:
            - name: GIT_JFrog_FreeTier_JVM
          outputResources:
            - name: build_info
          integrations:
            - name: svenruppert_jfrog_io            # Change to your instance
          runtime:
            type: image
            image:
              auto:
                language: java
                versions:
                  - "11"
        execution:
          onStart:
            - javac -version
            - mvn --version

```

If this step is running, add the next step that should invoke a **mvn test**.
Have in mind that this step should run after the first one. 
Have a look at the attribute **inputSteps:**

If this is running well, add a section to verify the maven build **mvn verify**
and add the functionality to push the build info.
 
````yaml
      - name: publish_maven_build_verify
        type: PublishBuildInfo
        configuration:
          forceXrayScan: true
          inputSteps:
            - name: maven_build_verify
          outputResources:
            - name: build_info
````

Additionally you can invoke the maven task to create a Mutation TestCoverage with pit.
The maven target is **mvn test pitest:mutationCoverage**. 

### Docker build and push
After you have done all this, you can start 
to build your first Docker Image and push it into your registries. 

````yaml
      - name: docker_build_jdk
        type: DockerBuild
        configuration:
          affinityGroup: group_docker_build_jdk
          dockerFileLocation: _data/adopt@1.8.0-172
          dockerFileName: Dockerfile
          dockerImageName: svenruppert-docker-local-svenruppert.jfrog.io/svenruppert/adopt  # replace with your image path and name
            #            dockerImageTag: ${run_number}
          dockerImageTag: 1.8.0-172
          inputResources:
            - name: GIT_JFrog_FreeTier_JVM
          outputResources:
            - name: build_info
          integrations:
            - name: svenruppert_jfrog_io
````
Do this for the jdk and after this is created for the maven Docker Image.

## Conclusion
You have now all steps in your hand to build repositories, 
build your projects and scann for known vulnerabilities. 
You are able to run your project inside a DevSecOps environment.

Your next task is to choose a small 
OpenSource project and try to get it running inside a fresh new FreeTier instance.
If your are done with this, share it with the OpenSource project owner. ;-)


