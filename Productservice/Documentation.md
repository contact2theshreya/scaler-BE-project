## Error Documentation
<font color="red">1) Maven resources compiler: Maven project configuration required for module 'MyFirstSpringProject' isn't available. Compilation of Maven projects is supported only if external build is started from an IDE</font>

Solution - Right-click on pom.xml and then click on "Add as Maven Project". 

<font color="red">2) Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured </font>

Solution - https://www.baeldung.com/spring-boot-failed-to-configure-data-source

Worked - adding in application .prop

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration


TO RUN
Read - https://www.geeksforgeeks.org/spring-boot-rest-template/
http://localhost:8080/products/1
https://fakestoreapi.com/docs
Post request - postman signin with google
![img.png](img.png)

# Exceptions
 Without controlelr advice
 http://localhost:8080/products/1000000
![img_1.png](img_1.png)
With controller advice
![img_2.png](img_2.png)

Github link for fakestore all api-
https://github.com/abhishek621/fakestore-api/tree/master

https://developer.mozilla.org/en-US/docs/Web/HTTP/Status


