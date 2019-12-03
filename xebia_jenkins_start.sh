#!/usr/bin/env bash

#check your ports are free
#sudo lsof -i tcp:8080 &&  sudo lsof -i tcp:9001

echo "Env variables sert successfully: ${jenkins_port} ${sonar_port} ${jenkins_container_name} ${sonar_container_name}"

    mkdir downloads
    curl -o downloads/jdk-8u144-linux-x64.tar.gz http://ftp.osuosl.org/pub/funtoo/distfiles/oracle-java/jdk-8u144-linux-x64.tar.gz
    curl -o downloads/jdk-7u80-linux-x64.tar.gz http://ftp.osuosl.org/pub/funtoo/distfiles/oracle-java/jdk-7u80-linux-x64.tar.gz
    curl -o downloads/apache-maven-3.5.2-bin.tar.gz http://mirror.vorboss.net/apache/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.tar.gz

#IP=$(ifconfig en0 | awk '/ *inet /{print $2}')

#echo "Host ip: ${IP}"

if [ ! -d m2deps ]; then
    mkdir m2deps
fi

docker-compose -f docker-compose.yml up --build