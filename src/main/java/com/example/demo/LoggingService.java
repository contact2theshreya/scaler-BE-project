package com.example.demo;

public class LoggingService {
    Database db = new Database();
    public void doSomething(){
        db.createQuery("select * from product");
    }
}
