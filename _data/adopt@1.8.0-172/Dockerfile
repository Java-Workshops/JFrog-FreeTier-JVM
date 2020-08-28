FROM svenruppert-docker-remote-dockerio.jfrog.io/buildpack-deps:buster-curl
LABEL maintainer="Sven Ruppert sven.ruppert@gmail.com" description="adopt@1.8.0-172"

ARG USER_HOME_DIR="/root"

ENV JABBA_VERSION "0.11.2"
ENV JABBA_REPO https://github.com/shyiko/jabba/raw/master
#ENV JABBA_REPO https://svenruppert.jfrog.io/artifactory/generic-local-jabba

RUN curl -usven.ruppert@gmail.com:AP29KcY75Ve91U7nQmjwrrp74TZ \
         -sL $JABBA_REPO/install.sh | \
        JABBA_COMMAND="install adopt@1.8.0-172 -o /jdk" bash

ENV JAVA_HOME /jdk
ENV PATH $JAVA_HOME/bin:$PATH

RUN java -version

CMD ["java"]