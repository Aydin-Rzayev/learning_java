package PolymorphismExamples;

public class Main {
    public static void main(String[] args){
        VipUser vipUser  = new VipUser();
        User user = new User();

        vipUser.setUser(123, "Akif124", 100);
        user.setUser(456, "Aysel098");

        vipUser.printUser();
        user.printUser();

    }
    
}
