package GuessingGame;

import java.io.*;

public class User implements Serializable {
    private String username;
    private String password;
    private double coinBalance;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.coinBalance = 10000;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public double getCoinBalance(){
        return coinBalance;
    }

    public void setCoinBalance(double coinBalance){
        this.coinBalance = coinBalance;
    }

    public static User loadUser(String users) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(users));
            User loadedUser = (User) ois.readObject(); // Cast to User
            ois.close();
            return loadedUser;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveUser(String users){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(users));
            oos.writeObject(this); // Serialize the entire User object
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
