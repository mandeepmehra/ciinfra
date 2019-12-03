import hudson.slaves.EnvironmentVariablesNodeProperty
import jenkins.model.Jenkins

ip = "192.168.1.254"
instance = Jenkins.getInstance()
globalNodeProperties = instance.getGlobalNodeProperties()
envVarsNodePropertyList = globalNodeProperties.getAll(EnvironmentVariablesNodeProperty.class)

newEnvVarsNodeProperty = null
envVars = null

if ( envVarsNodePropertyList == null || envVarsNodePropertyList.size() == 0 ) {
  newEnvVarsNodeProperty = new EnvironmentVariablesNodeProperty();
  globalNodeProperties.add(newEnvVarsNodeProperty)
  envVars = newEnvVarsNodeProperty.getEnvVars()
} else {
  envVars = envVarsNodePropertyList.get(0).getEnvVars()
}

envVars.put("SCANNER_HOST", ip)
envVars.put("SCANNER_PORT", "6060")
envVars.put("SCANNER_CLIENT_IP", ip)
envVars.put("ARTIFACTORY_URL","http://artifactory:8081/artifactory")
envVars.put("KUBE_HOST","192.168.99.103")


instance.save()
