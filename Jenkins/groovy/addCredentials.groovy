import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;

def username = "mandeepmehra"
def password = "!Jck2019"

// def username = new File("/run/secrets/gitlab-user").text.trim()
// def password = new File("/run/secrets/gitlab-pass").text.trim()

// def dockerUsername = new File("/run/secrets/docker-user").text.trim()
// def dockerPassword = new File("/run/secrets/docker-pass").text.trim()

def dockerUsername = "mandeepmehra"
def dockerPassword = "AeRo20000"

// def artifactoryUsername = new File("/run/secrets/artifactory-user").text.trim()
// def artifactoryPassword = new File("/run/secrets/artifactory-pass").text.trim()

def artifactoryUsername = "admin"
def artifactoryPassword = "admin"


Credentials credentials = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,"GitLabCreds", "Gitlab credentials", username, password)
SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), credentials)

Credentials dockerCredentials = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,"dockerhub", "DockerHub credentials", dockerUsername, dockerPassword)
SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), dockerCredentials)

Credentials artifactoryCredentials = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,"artifactorycreds", "ARTIFACTORY credentials", artifactoryUsername, artifactoryPassword)
SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), artifactoryCredentials)
