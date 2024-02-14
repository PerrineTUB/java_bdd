import com.java_sql.model.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("user1", "user1", "user1@gmail.com", "1234");
        User user2 = new User("user2", "user2", "user2@gmail.com", "1234");
        User user3 = new User("user3", "user3", "user3@gmail.com", "1234");
        User newUser = new User("TUBIA", "Perrine", "user1@gmail.com", "1234");
        //UserManager.addUser(user3);
        //UserManager.udpateUser(newUser);

        //UserManager.deleteUserByMail(user1);
//        if(UserManager.findUser(user1).getNom() != null){
//            System.out.println("Le compte existe déjà.");
//        } else {
//            System.out.println("Le compte : " + UserManager.addUser(user1).getNom() + " à été ajouté en bdd");
//        }

//        System.out.println("------------------------------------------------------------------");
//        System.out.printf(" | %-2s | %-10s | %-10s | %-30s | \n", "ID", "Nom", "Prénom", "Email");
//        System.out.println("------------------------------------------------------------------");
//        for (User value: UserManager.getAllUser()) {
//            System.out.printf(" | %-2s | %-10s | %-10s | %-30s | \n",
//                    value.getId(), value.getNom(), value.getPrenom(), value.getEmail());
//        }
//        System.out.println("------------------------------------------------------------------");
        Exemple form = new Exemple(null );
    }
}