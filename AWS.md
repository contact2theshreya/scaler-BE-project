## AWS credential
Root email - contact2theshreya@gmail.com  
password: Sep@2024
AccountId - 248189933304

IN AWS 
https://youtu.be/by0EJ4qL8ek

1) search RDS
2) choose mysql->community->free tier
3) give DB name(DemoRDSDatabase,admin,password)
4) db.t3.micro,general purpose ssd gp2
5) turn off autoscale
6) turn pubvlic acess on
7) DB-port is 3306
8) create database
9) ![image](https://github.com/user-attachments/assets/3563578e-deba-48e4-87ae-1e53f8899caf)
10) if in workbench you are not able to connect to database due to connection timed out then add security group rule and save rule then try again on workbench
    click on security group->add security group inbound rule->edit inbound rule->
12) ![image](https://github.com/user-attachments/assets/4718c70f-7a57-45f5-aa6f-a65da2318945)
13) ![image](https://github.com/user-attachments/assets/0ed5ff25-2a44-4994-b4d9-f4f89f0d53f1)
14)
15) ![image](https://github.com/user-attachments/assets/7a2c2f46-dc95-4eee-ab88-64d32a0474ac)
with admin /password and endpoint of aws in host
![image](https://github.com/user-attachments/assets/abdf3751-b88c-4147-a897-0bcb0cefdef8)
Run query
create database sampledb
use sampledb
create table employee(emp_id INT,emp_name varchar(255))
In dbware where u can conncet to any kind of database
![image](https://github.com/user-attachments/assets/b36f1673-8b9d-4b20-86b9-a63c999882ff)


    ## EC2
    1} launch instance
    ![image](https://github.com/user-attachments/assets/2e42b76f-1716-4a00-9ab6-ced1213bab5f)

    ![image](https://github.com/user-attachments/assets/85fc2cb9-cb01-4b91-a101-461d05ea0338)
    ![image](https://github.com/user-attachments/assets/a25faaee-f712-4b8a-8fe9-cd5ca99a0c93)


    2) ![image](https://github.com/user-attachments/assets/8d140698-1a72-4c28-a02f-7a1a89389bca)
    3)  Now in local connect to database aws using endpoint and admin/password
    4)  create database in local of aws->use database->create table->
Delete all instances
