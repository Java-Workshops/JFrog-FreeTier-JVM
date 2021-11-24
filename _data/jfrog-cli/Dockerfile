FROM svenr-docker.jfrog.io/svenruppert/maven-3.6.3-adopt:1.8.0-172
MAINTAINER sven.ruppert@gmail.com

ARG USER_HOME_DIR="/root"

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
#RUN apt-get update -y
#RUN apt-get install build-essential procps curl file git -y

# install Homebrew
#RUN apt-get update && \
#    apt-get install -y -q --allow-unauthenticated \
#    git \
#    sudo
#RUN useradd -m -s /bin/zsh linuxbrew && \
#    usermod -aG sudo linuxbrew &&  \
#    mkdir -p /home/linuxbrew/.linuxbrew && \
#    chown -R linuxbrew: /home/linuxbrew/.linuxbrew
#USER linuxbrew
#RUN /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
#USER root
#RUN chown -R $CONTAINER_USER: /home/linuxbrew/.linuxbrew

RUN brew install jfrog-cli
RUN jfrog c add
#RUN jfrog rt mvn-config

CMD ["jfrog"]