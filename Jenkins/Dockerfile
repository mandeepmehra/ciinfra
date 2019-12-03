# syntax=docker/dockerfile:1.0.0-experimental

FROM jenkins/jenkins:lts

LABEL Maintainer="Priyanku Konar"

# Customize Jenkins

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY /groovy/*.groovy /usr/share/jenkins/ref/init.groovy.d/

USER root

# Install Node JS

RUN curl -sL https://deb.nodesource.com/setup_11.x  | bash -
RUN apt-get -y install nodejs

# Install docker binary
RUN curl -fsSL https://get.docker.com/ | bash -

# Install sonar-scanner for js
RUN npm install -g sonarqube-scanner

# Install protractor
RUN npm install -g protractor

RUN npm install -g mocha

# Install helm client
ENV BASE_URL="https://get.helm.sh"
ENV TAR_FILE="helm-v2.14.1-linux-amd64.tar.gz"

RUN curl -L ${BASE_URL}/${TAR_FILE} |tar xvz && \
    mv linux-amd64/helm /usr/bin/helm && \
    chmod +x /usr/bin/helm && \
    rm -rf linux-amd64 

# Install Chrome Headless browser
# Set the Chrome repo.
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list
    
# Install Chrome.
RUN apt-get update && apt-get -y install google-chrome-stable
