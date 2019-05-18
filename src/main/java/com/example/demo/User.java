package com.example.demo;

import org.springframework.stereotype.Component;

import java.io.Serializable;


public class User implements Serializable {

     private String userId;
     private String username;
     private String password;
    // 省略 getter  setter
     User(String id,String name,String pwd){
         this.userId=id;
         this.username=name;
         this.password=pwd;
     }
     public void setName(String name){
         this.username=name;
     }
     public void  test(){
         System.out.println("4567897"+this.username);
     }
}