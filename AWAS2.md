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
Now create group and create role according to this video and new role and group while creating env as per below video
https://youtu.be/pbUFV27Py8E

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

8)  ![image](https://github.com/user-attachments/assets/65c700e8-ff0b-443e-96cb-87d9b102cf39)
9)  Public acess activated in next screen
10)  ![image](https://github.com/user-attachments/assets/b9957505-e8d8-411a-951e-c9c2d1e4bc0b)

11)  ![image](https://github.com/user-attachments/assets/5dc674b6-1617-4421-bef0-6f9a59311a20)
    Next and submit
U can also add  DB of RDS in EBS

## 



