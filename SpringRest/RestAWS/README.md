# Deploy a Spring Rest application on AWS platform using Elastic BeanStalk and Amazon RDS

### Software required
* Eclipse IDE+AWS Toolkit / Spring Tool Suite
* Apache Maven 3.0
* Apache Tomcat 8.X
* AWS(Amazon Web Service) account
* Amazon RDS(Relational Database Service)
* Java 1.8

### Dependencies
* Spring(MVC) 4.1.8.RELEASE
* Hibernate 3.6.9.Final
* Lombok 1.16.18
* Jackson 2.7.3

### Initially create a Spring Rest application
1. Develop a Spring Rest application using Eclipse IDE or Spring Tool Suite.
2. Connect the application to a local mysql server database.
3. Build the application using Apache Maven 3.0 and deploy on Apache Tomcat server.
4. Verify the application is functioning properly and is able to retrieve and manipulate data from your local database.
5. We will update the application database connection properties later before deploying to cloud once Amazon RDS is setup.

### AWS Account - Sign up
1. Follow the [link](https://aws.amazon.com/console) to navigate to AWS Signup Console.
2. Click on create a free account. 
3. You can take leverage of amazon cloud services for free for 12 months with a free account.
4. Follow the [link](https://aws.amazon.com/free/) to go through the free tier usage details and not to get billed while playing around.
5. The signup process will prompt you to enter your credit/debit card details, but you wont be charged as far as you stay inside the free services tier.

### Elastic Beanstalk - Creating environment and deploying sample application
*Elastic Beanstalk is a service offered by AWS for helping users quickly deploy and manage applications in cloud.*

1. Under the Services tab on the top left corner of your homepage after log in you can see various services provided by Amazon like Amazon Elastic Compute Cloud(EC2), Amazon Simple Storage Service(S3), Elatic Beanstalk etc.. Follow the [link](https://aws.amazon.com/products/) for more product information.
2. Click on Elastic Beanstalk.
3. Once you are navigated to the dashboard of Elastic Beanstalk, click on create a new application.
4. Fill in the application name and a short description about your application and proceed.
5. Select Web server environment tier to stick within free tier services by AWS and proceed.
6. Now choose the platform to which you need to deploy your project. Since we are deploying the web application on Apache Tomcat server choose Tomcat as the platform.
7. At this stage we can either choose to upload our locally developed application war file or a sample application code to test our AWS environment. So for now we will proceed with the sample application code provided by AWS itself and will test our new AWS environment.
8. Once the mandatory details are entered click on Create Environment to create your application environment in cloud.
9. This may take sometime and once the sample application war is deployed, you can see the generated URL where the application is hosted.

### Create Amazon RDS(Relational Database Service) for your application.
1. Now proceed to the Configuration page of your environment through the left menu bar.
2. Scroll below to the bottom of the page and you can see a box with a link to create a Data tier for your application.
3. Click on the link and you will be navigated to the RDS dashboard. Follow the [link](https://aws.amazon.com/rds/) for more information on Amazon RDS.
4. Now select the db engine for your Data tier. There is a wide collection of engines provided by Amazon RDS like Amazon Aurora, PostgreSQL, MySQL, MariaDB, Oracle, and Microsoft SQL Server. We will select MySQL for our Spring Rest application.
5. Enter a username and password for your database and proceed to generate a relational database in cloud.
6. Once the RDS is generated save the database details into application.properties file in your Eclipse project.

Sample Amazon RDS connection details will look like following:

* **CONN_URL**    *aa1q7w53k4u7ptn.ceoy61iaondj.us-west-2.rds.amazonaws.com:3306*
* **RDS_DB_NAME** *aa1q7w53k4u7ptn*
* **RDS_USERNAME** --------
* **RDS_PASSWORD** --------
* **RDS_HOSTNAME** *aa1q7w53k4u7ptn.ceoy61iaondj.us-west-2.rds.amazonaws.com*

### Security group for your Amazon RDS
*A security group acts as a virtual firewall that controls the traffic for one or more instances. Follow the [link](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html) for more information on security groups. By default, network access is turned off to a DB instance. Follow the [link](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.RDSSecurityGroups.html) for more information on security group authorization details.*

1. Navigate to EC2 dashboard through Services tab on top left corner.
2. Click on Security Groups under Network & Security.
3. Under the listed security groups choose the default security group and modify the Inbound and Outbound information.
4. Choose the source as anywhere for both traffic and save.(Note: Follow this for a test environment. For production environment authorize only for a specific IP address). Follow the [link](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/authorizing-access-to-an-instance.html) for more information on particular environment settings.

### AWS Identity and Access Management (IAM) user
*Add an Administrator user to your Amazon AWS account to access the AWS toolkit through Eclipse IDE.*

1. Naviagte to IAM dashboard through Services tab on top left corner.
2. Under the Users section click on add a new user.
3. Provide access type as Programmatic access which will generate an access key and secret key.
4. Attach an existing policy with full administrator access to the user and create the user keys.
5. Note down the access key and secret key.

### AWS Toolkit for Eclipse IDE
*The AWS Toolkit for Eclipse is an open source plug-in for the Eclipse Java IDE that makes it easier for developers to develop, debug, and deploy Java applications using Amazon Web Services. Follow the [link](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/) for more information on AWS Toolkit.*

1. Download AWS toolkit from Eclipse marketplace.
2. Install the plugin and it will prompt for the access key and secret key to link to your AWS account.
3. Enter the credentials and complete the installation.

### Accessing Amazon RDS schema through Eclipse
1. Once the AWS toolkit is installed, open the AWS Management perspective in Eclipse.
2. Under the Amazon RDS link on the left hand side of the window you will be able to see your database. Double click and enter the database username and pasword when prompted.
3. Create a schema and add tables and data into your relational database.

### Test your Spring REST application locally with Amazon RDS
*With the updated Amazon RDS connection details in the properties file inside your Spring application, build and deploy the project locally on tomcat server. Once the JPA connection is successful with Amazon RDS check whether the application is able to add and retrieve data from database in cloud.*

### Uploading your war into cloud
1. Navigate to Elastic Beanstalk dashboard through Services tab on top left corner.
2. Select the application environment you have created.
3. Click on upload and deploy.
4. Choose the war file of your Spring REST application from local machine and provide a version label. Click on deploy.
5. This may take few minutes. Once the deployment is complete you can see the health status of your application as OK.

### Verify your app deployment
*Click on the generated url and you will be able to see your Spring application hosted in cloud.*

#### Checkout http://sample-env-1.2e9zsnfuny.us-west-2.elasticbeanstalk.com/index.html to view my Spring REST project deployed on AWS platform with a cloud database. The application retrieves all the data in the Account table from the attached relational database and is displayed in JSON format on the view.



