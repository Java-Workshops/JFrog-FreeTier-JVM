#!/bin/bash

# more infos about buildinfo at https://www.youtube.com/watch?v=ILgZexU07dc
# Buildinfo HowTo https://www.youtube.com/watch?v=NFcjrJlxX-s
# article about it : https://svenruppert.com/2021/10/08/the-power-of-jfrog-build-info-build-metadata/

CURRENTDATE=`date +"%Y-%m-%d_%T"`
echo $CURRENTDATE

$HOME/.jabba/bin/jabba use adopt@1.8.0-232
jfrog rt mvn clean install -f pom.xml --build-name=jvm-freetier-workshop --build-number=$CURRENTDATE
jfrog rt bp jvm-freetier-workshop $CURRENTDATE