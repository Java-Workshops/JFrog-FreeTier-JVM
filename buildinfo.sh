#!/bin/bash

CURRENTDATE=`date +"%Y-%m-%d_%T"`
echo $CURRENTDATE

$HOME/.jabba/bin/jabba use adopt@1.8.0-232
jfrog rt mvn clean install -f pom.xml --build-name=jvm-freetier-workshop --build-number=$CURRENTDATE
jfrog rt bp jvm-freetier-workshop $CURRENTDATE
