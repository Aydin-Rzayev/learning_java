package PolymorphismExamples;

public class User{
    
    protected String username;
    protected int id;
    protected int balance = 0;
    
    //Polimorfizmə bir örnək: Overloading
    public void setUser(int id, String username){
        this.id = id;
        this.username = username;
    }

    public void setUser(int id, String username, int balance){
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public void printUser(){
        System.out.println(this.username);
        System.out.println(balance);
    }

    
    
}


