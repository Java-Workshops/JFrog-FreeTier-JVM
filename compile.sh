#!/bin/bash
docker run \
       --rm \
       --name run \
       -v "$(pwd)":/usr/src/mymaven \
       -w /usr/src/mymaven \
       svenr.jfrog.io/docker/svenruppert/adopt:1.8.0-272 \
       mvn clean verify -Dmaven.test.skip=false