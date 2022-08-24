FROM  svenr-docker.jfrog.io/buildpack-deps:bullseye-curl
# FROM  buildpack-deps:buster-curl
LABEL maintainer="Sven Ruppert sven.ruppert@gmail.com" description="adopt@1.8.0-172"

ARG USER_HOME_DIR="/root"

ENV JABBA_VERSION "0.11.2"
ENV JABBA_REPO https://github.com/shyiko/jabba/raw/master
#ENV JABBA_REPO https://svenruppert.jfrog.io/artifactory/generic-local-jabba

#RUN curl -uUSER:PASSWD \
#         -sL $JABBA_REPO/install.sh | \
#        JABBA_COMMAND="install adopt@1.8.0-172 -o /jdk" bash

#ADD sources.list /etc/apt/sources.list
RUN apt-get update -y
RUN apt-get install git -y


RUN curl -sL https://github.com/shyiko/jabba/raw/master/install.sh | \
    JABBA_COMMAND="install adopt@1.8.0-272 -o /jdk" bash

ENV JAVA_HOME /jdk
ENV PATH $JAVA_HOME/bin:$PATH

RUN java -version

CMD ["java"]