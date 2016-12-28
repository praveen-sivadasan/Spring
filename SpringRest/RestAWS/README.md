# Deploy a Spring Rest application in AWS using Elastic BeanStalk

### Create a Spring Rest application
1. Develop a Spring Rest application using eclipse IDE or Spring Tool Suite.
2. Connect the application to a local mysql server database.
3. Integrate and create application build using Apache Maven 3.0.
4. Verify the application is deployed in Tomcat container and is functioning properly.
5. We will update the application database connection details later before deploying to cloud using Amazon RDS credentials.

### AWS Account - Sign up
1. [AWS Signup Console](https://aws.amazon.com/console)
2. Click on create a free account. 
3. You can take leverage of amazon services for free for 12 months with a free account.
4. Checkout the [link](https://aws.amazon.com/free/) to go through the free usage details.
5. The signup process will prompt you to enter your card details, but you wont be charged as far as you stay inside the free services tier.

### Elastic Beanstalk - Creating environment and deploying sample application
Elastic Beanstalk is a service offered by AWS in helping users quickly deploy and manage applications in cloud.

1. Under the services tab on top left corner of your homepage you can see various services provided by Amazon.
2. Click on Elastic Beanstalk.
3. Once you are navigated to the dashboard of Elastic Beanstalk, click on create new application.
4. Fill in the application name and a short description about your application and proceed.
5. Select Web server environment tier to stick to free tier service by AWS and proceed.
6. Now choose the platform to which you need to deploy your project. Since we are deploying the web application to Tomcat server choose Tomcat as platform.
7. We can either choose to upload our locally developed application war file or a sample application code to test our AWS environment. So for now we will proceed with sample application code provided by AWS itself and will test our environment.
8. Once the necessary details are entered click on create environment to create your application environment in AWS.
9. This may take sometime and once the sample application is hosted you can see the generated URL where the application is hosted.

### Create Amazon RDS(Relational Database Service) for your application.
1. Navigate to the Configuration page of your environment through the left menu bar.
2. Scroll below to the bottom of the page and you can see a box with a link to create a Data tier for your application.
3. Click on the link and you will be navigated to RDS dashboard. Checkout the [link](https://aws.amazon.com/rds/) for Amazon RDS details.
4. Select the db engine for your Data tier. There is a wide collection of engines provided by Amazon RDS like Amazon Aurora, PostgreSQL, MySQL, MariaDB, Oracle, and Microsoft SQL Server. We will select MySQL for our Spring Rest application.
5. Enter a username and password for your database and proceed to generate a relational database.
6. Once the RDS is generated save the database details into application.properties file.
A sample RDS connection details will look like:

##### CONN_URL    *aa1q7w53k4u7ptn.ceoy61iaondj.us-west-2.rds.amazonaws.com:3306*
##### RDS_DB_NAME *aa1q7w53k4u7ptn*
##### RDS_USERNAME --------
##### RDS_PASSWORD --------
##### RDS_HOSTNAME *aa1q7w53k4u7ptn.ceoy61iaondj.us-west-2.rds.amazonaws.com*

### Security group for your Amazon RDS
A security group acts as a virtual firewall that controls the traffic for one or more instances. Check the [link](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html) for more details. By default, network access is turned off to a DB instance. Check out the [link](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.RDSSecurityGroups.html) for more details.

1. Navigate to EC2 dashboard through Services tab on top left corner.
2. View Security Groups under Network & Security.
3. Click on default security group and modify the Inbound and Outbound.
4. Choose source as anywhere for both and press save.(Note: This is only for a test environment. For production authorize for a specific IP address only) Click on the [link](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/authorizing-access-to-an-instance.html) for further details.

### AWS Identity and Access Management (IAM) user
Add an Administrator user to your Amazon AWS account to access AWS plugin through Eclipse IDE.

1. Naviagte to IAM dashboard through Services tab on top left corner.
2. Under the Users section click on add new user.
3. Provide access type as Programmatic access which will generate a access key and secret key.
4. Attach an existing policy with full administrator access and create the user keys.
5. Note down the access key and secret key.

### AWS plugin for Eclipse IDE
The AWS Toolkit for Eclipse is an open source plug-in for the Eclipse Java IDE that makes it easier for developers to develop, debug, and deploy Java applications using Amazon Web Services. Click on the [link](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/) for more details.

1. Download AWS toolkit from Eclipse marketplace.
2. Install the plugin and it will prompt for access key and secret key to link to your AWS account.

### Accessing Amazon RDS schema through Eclipse
1. Once the AWS toolkit is installed, open the AWS Management perspective in eclipse.
2. Under the Amazon RDS link you will be able to see your database. Double click and enter master username and pasword.
3. Create a schema and add tables and data into your relational database.

### Test your Spring REST application locally with Amazon RDS
With the updated database properties in application.properties run your application locally on Apache tomcat server. Once the connection is successful check whether you are able to add and retrieve data from Amazon RDS.

### Uploading your war into cloud
1. Navigate to Elastic Beanstalk dashboard.
2. Select the application you have created.
3. Click on upload and deploy.
4. Choose the war file of your Spring REST application and provide a version label. Click on deploy.
5. This may take few minutes. Once deployment id complete you can see the health status of your application as OK.

### Verify deployment
Click on the generated url and you will be able to see your web application deployed on AWS.

#### Checkout http://custom-env.2e9zsnfuny.us-west-2.elasticbeanstalk.com/account/lookup to view my Spring REST app deployed in AWS using Amazon RDS. The application retrieves all data in Account table from the attached relational database in cloud and is displayed in JSON format.



