import com.java_sql.model.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("user1", "user1", "user1@gmail.com", "1234");
        User user2 = new User("user2", "user2", "user2@gmail.com", "1234");
        User user3 = new User("user3", "user3", "user3@gmail.com", "1234");
        UserManager.addUser(user3);
        //UserManager.udpateUser(test);
        //UserManager.deleteUserByMail(user1);
    }
}