#Use following command to run sonarqube:

docker run -d --name sonarqube -p 9000:9000 sonarqube:6.7-alpine

#Login credentials
Default user/pwd = admin/admin

#Notes
 - Sonarqube manual configurations to be done as per project requirements
 - Uses embedded database on port 9092 with url jdbc:h2:tcp://127.0.0.1:9092/sonar
 - Data is stored at /opt/sonarqube/data
 - SonarQube home: /opt/sonarqube
 - Available at http://localhost:9000 (default)
 

