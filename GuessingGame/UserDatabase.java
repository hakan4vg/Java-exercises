package GuessingGame;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class UserDatabase {
    private List<User> users;

    public UserDatabase(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
        user.saveUser(user.getUsername()+".dat");
    }
    public User getUserByUsername(String username){
        for (User user : users){
            if(user.getUsername().equals(username))
                return user;
        }
        File file = new File(username + ".dat");
        if (file.exists()) {
            User loadedUser = User.loadUser(username + ".dat");
            if (loadedUser != null) {
                users.add(loadedUser); // Add the loaded user to the in-memory list
                return loadedUser;
            }
        }

        return null; // User not found
    }
}
// I need to add a method to save/load users from a file.