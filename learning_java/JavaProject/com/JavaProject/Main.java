package JavaProject.com.JavaProject;

public class Main {
    public static void main(String[] args){
        User customUser = new User();
        //System.out.println("User1:\n" + user1.username + "\n" + user1.fullName + "\n" + user1.id + "\n" + user1.balance + "\n" + user1.password);
        //System.out.println("User2:\n" + user2.username + "\n" + user2.fullName + "\n" + user2.id + "\n" + user2.balance + "\n" + user2.password);
        customUser.setfullName("Asif Eyvazov");
        customUser.setUsername("asif_eyvaz");
        customUser.setPassword("asif123");
        customUser.setBalance(1300);
        customUser.setId(14578);
        System.out.println(customUser.getUsername());
        System.out.println(customUser.getfullName());
        
        User customUser2 = new User();
        customUser2.setfullName("Akif Eyvazov");
        customUser2.setUsername("akif_eyvaz");
        customUser2.setPassword("akif123");
        customUser2.setBalance(100);
        customUser2.setId(14570);
        
        System.out.println(customUser2.getUsername());
        System.out.println(customUser2.getfullName());
    }    
}
