# xebia-microservice-mean ..

The idea of thisrepo is to be able to set up infrastructure  by invoking a single command "run sh setup_infra.sh"
- the docker-compose file  will be invoked which will run the below services 
  -jenkins2 -- ( WIP)
  -sonarcube -- ( TBD)
  -artifactoryu (TBD)
- docker-compoer will read the variable values from .env file and replace them


# creating ssh for your github account 
https://help.github.com/en/articles/adding-a-new-ssh-key-to-your-github-account

# ssh into the jenkins container if needed
  docker exec -it xebia-jenkins bash

# get the ip address of jenkins container 
  sudo docker inspect -f '{{ .NetworkSettings.IPAddress }}' containerID

#To get installed plugins in Jenkins 

-go to the jenkins server localhost:8080/script and run below script
Jenkins.instance.pluginManager.plugins.each{
  plugin ->
    println ("${plugin.getShortName()}")
}
- copy the unique list of plugins and add it to plugin.txt  within teh JEnkins folder in this repository  ( leave extra line at the end of ist )

# retrive admnin password for Jenkins
sudo cat /var/lib/jenkins/secrets/initialAdminPassword


# Step 1 - Build Infra
./buildImages.sh to build all images for setting up the infra

# step 2 - Add credentials in docker secret 
Sample command echo "admin" | docker secret create jenkins-user -
jenkins-user
jenkins-pass
gitlab-user
gitlab-pass


# Step 3 - Setup Infra
 - docker stack deploy -c docker-compose.yml ge

# Step 4 - Delete infra 
-  docker stack rm ge
