#!/bin/bash
#function docker_tag_exists() {
#    EXISTS=$(curl -s  https://hub.docker.com/v2/repositories/$1/tags/?page_size=10000 | jq -r "[.results | .[] | .name == \"$2\"] | any")
#    test $EXISTS = true
#}

#if docker_tag_exists svenruppert/adopt 1.8.0-172; then
#    echo skip building, image already existing - svenruppert/adopt:1.8.0-172
#else
    echo start building the image
    export DOCKER_BUILDKIT=0
    export COMPOSE_DOCKER_CLI_BUILD=0

    docker build -t svenruppert/adopt .

    docker tag svenruppert/adopt:latest svenr-docker.jfrog.io/docker/svenruppert/adopt:1.8.0-272
    docker push svenr-docker.jfrog.io/docker/svenruppert/adopt:1.8.0-272

#fi
#    docker image rm svenruppert/adopt:latest
#    docker image rm svenruppert/adopt:1.8.0-172