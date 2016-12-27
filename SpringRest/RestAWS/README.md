# Deploy a Spring Rest application in AWS using Elastic BeanStalk

### Create a Spring Rest application
1. Develop a Spring Rest application using eclipse IDE or Spring Tool Suite.
2. Connect the application to a local mysql server database.
3. Integrate and create application build using Apache Maven 3.0.
4. Verify the application is deplyed in Tomcat container and is functioning properly.
5. We will be updating the application database connection details later using AWS RDS credentials.

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
CONN_URL    aa1q7w53k4u7ptn.ceoy61iaondj.us-west-2.rds.amazonaws.com:3306
RDS_DB_NAME aa1q7w53k4u7ptn
RDS_USERNAME --------
RDS_PASSWORD --------
RDS_HOSTNAME aa1q7w53k4u7ptn.ceoy61iaondj.us-west-2.rds.amazonaws.com

### Security group for your Amazon RDS
1. 



