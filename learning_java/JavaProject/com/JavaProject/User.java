package com.JavaProject;
public class User {
    private String username;
    private String fullName;
    private int id;
    private int balance;
    private String password;
    private static int count = 1;
    public User(){
        System.out.println(count++);
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setfullName(String fullName){
        this.fullName = fullName;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUsername(){
        return this.username;
    }
    public String getfullName(){
        return this.fullName;
    }
    public int getId(){
        return this.id;
    }
    public String getPassword(){
        return this.password;
    }
    public int getBalance(){
        return this.balance;
    }
    

    
}