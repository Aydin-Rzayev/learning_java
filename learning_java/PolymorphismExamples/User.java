package PolymorphismExamples;

public class User{
    
    protected String username;
    protected int id;
    protected int balance = 0;
    
    //Polimorfizmə bir örnək: Overloading
    /*
        todo Polimorfizmə cəhətdət ok olsa da, konvensiya cəhətdən o qədərdə düz deyil.
        Çünki setUser metoduna normalda arqumant olaraq User ötürülməsi gözlənilir.
        Yəni bir metod olaraq düzdür, amma nəzərə alsaq ki, setter method-u ilə üst-üstə düşür və real olaraq bu metod
        user-i set etmir, onun dəyərlərini set edir (username, id və s.)
     */
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


