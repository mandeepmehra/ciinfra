import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import hudson.plugins.git.*;

def scm = new GitSCM("https://gitlab.com/xebia-devops/xebia-microservice-mean-backend")
scm.branches = [new BranchSpec("*")];

def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "api-express/Jenkinsfile")

def instance = Jenkins.getInstance()
def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(instance, "api")
job.definition = flowDefinition

instance.reload()
