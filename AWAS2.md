In ec2 instance u can choose os
u need to also install java,maven,tomcat server so for that use elastic beanstalk
EBS is built on top of EC2 plus it also give storage , there is no need to install any dependency manually all are automatically installed there and EBS is also autoscale automatically.
# Make Demo spriing boot app(in current master branch)
1) Add packaging war
2) Go to EBS and create environment
 Worker environement-cron jobs(run job timely)
3) domain name in ebs is available by amazon
4) ![image](https://github.com/user-attachments/assets/a8aebb02-05b6-422c-bef2-6f81e7b21cc0)
5) ![image](https://github.com/user-attachments/assets/1d37b6c8-e8d9-46a0-8e1e-2e46770d125a)
6) ![image](https://github.com/user-attachments/assets/a6143d92-2348-44c5-a847-d752b91802cb)
   Next  and now open IAM in new tab and create user group(required acess to one group and add user)
   Once u add an user they will get an email for the invitation
   ![image](https://github.com/user-attachments/assets/84a88081-541c-4871-bda0-b38a68262e26)
   ![image](https://github.com/user-attachments/assets/f45b1993-b584-49ed-aeef-18b4bd203a0e)
   Note-Ec2 key pair is optional.
Now create group and create role according to this video and new role and group while creating env as per below video
## Follow this in case of error-
https://repost.aws/questions/QUcX9TipxqSGeM5G7RORmqoQ/new-account-recently-created-unable-to-create-environments-on-elastic-beanstalk-launch-configuration-error

Change root nvolume while creatng environment <b>IN INSTANCE AND traffik settng</b> and disable DisableIMDSv1
![image](https://github.com/user-attachments/assets/b470e798-3351-4717-ab9c-f142b60f1eff)

![image](https://github.com/user-attachments/assets/82d71fb6-052b-4340-aea5-db5fe3e86822)
configuring IMDS using the Elastic Beanstalk console
You can modify your Elastic Beanstalk environment's Amazon EC2 instance configuration in the Elastic Beanstalk console.
Important
The DisableIMDSv1 option setting can cause Elastic Beanstalk to create an environment with a launch template or update an existing environment from launch configurations to launch templates. For more information, see Launch Templates.

To configure IMDS on your Amazon EC2 instances in the Elastic Beanstalk console
1.	Open the Elastic Beanstalk console, and in the Regions list, select your AWS Region.
2.	In the navigation pane, choose Environments, and then choose the name of your environment from the list.
Note
If you have many environments, use the search bar to filter the environment list.
3.	In the navigation pane, choose Configuration.
4.	In the Instance traffic and scaling configuration category, choose Edit.
5.	Set Disable IMDSv1 to enforce IMDSv2. Clear Disable IMDSv1 to enable both IMDSv1 and IMDSv2.
6.	To save the changes choose Apply at the bottom of the page.


## To create a key pair using Amazon EC2(if not already created)
Open the Amazon EC2 console at https://console.aws.amazon.com/ec2/.

In the navigation pane, under Network & Security, choose Key Pairs.

Choose Create key pair.

For Name, enter a descriptive name for the key pair. Amazon EC2 associates the public key with the name that you specify as the key name. A key name can include up to 255 ASCII characters. It can’t include leading or trailing spaces.

Select a key pair type appropriate for your operating system:

(Linux instances) For Key pair type, choose either RSA or ED25519.

(Windows instances) For Key pair type, choose RSA. ED25519 keys are not supported for Windows instances.

For Private key file format, choose the format in which to save the private key. To save the private key in a format that can be used with OpenSSH, choose pem. To save the private key in a format that can be used with PuTTY, choose ppk.

To add a tag to the public key, choose Add tag, and enter the key and value for the tag. Repeat for each tag.

Choose Create key pair.
![image](https://github.com/user-attachments/assets/765cea2e-6ff3-41a5-a0a2-94afcb58c25b)
Note-keep pem file safely for authentication if u forgot password to sign in in EBS then pem file can be used to authenticate,u can also use pem file to login via console
create role r1->AWS service>choose EC2->add permision(adminacess,worker and web tier and multi docker domain)
create user (your gmail id)->add user to user group
8) ![image](https://github.com/user-attachments/assets/83913b7a-5079-43b6-b7fe-e84e46747179)

9)  Public acess activated in next screen
10)  ![image](https://github.com/user-attachments/assets/b9957505-e8d8-411a-951e-c9c2d1e4bc0b)

11)  ![image](https://github.com/user-attachments/assets/5dc674b6-1617-4421-bef0-6f9a59311a20)
    Next and submit
![image](https://github.com/user-attachments/assets/30f49f86-6351-4cf3-9ba2-57fda8d289b6)

![image](https://github.com/user-attachments/assets/47bcb036-b949-44f8-bf7e-bfd395ccac8e)


U can also add  DB of RDS in EBS

## Note

EBS runs a reverse proxy server on port 80 which forward traffic to application on port 5000 so either modify reverse proxy to forward to  port 8080 or  set server port env variable /in app.prop to port 5000

To use environment variables in spring boot application.properties you can use the usual Spring placeholder notation:

spring.datasource.url = ${JDBC_CONNECTION:default_value_connection}
Further explanation: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-placeholders-in-properties

You can set JDBC_CONNECTION value in AWS Elastic beanstalk. If JDBC_CONNECTION environment variable not set it will use the 'default_value_connection'.


