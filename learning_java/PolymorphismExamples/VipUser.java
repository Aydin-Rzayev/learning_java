package PolymorphismExamples;

//Polymorphism-ə başqa bir örnək: Overriding
class VipUser extends User{
    public void setUser(int id, String username, int balance){
        this.id = id;
        this.username = username + " VIP";
        this.balance = balance;

    } 
    public void setUser(int id, String username){
        this.id = id;
        this.username = username + " VIP";
    }
    public void printUser(){
        System.out.println(username);
        System.out.println(balance);
    }
}