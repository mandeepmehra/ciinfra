#!/usr/bin/env bash
jenkins_port=8080
sonar_port=9001
jenkins_container_name=xebia_jenkins
sonar_container_name=xebia_sonar

docker stop ${sonar_container_name} ${jenkins_container_name}
