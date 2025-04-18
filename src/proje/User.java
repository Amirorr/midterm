package proje;

import java.util.ArrayList;

public class User {
    String username;
    String password;
    UserBehavior behavior;
    ArrayList<Playlist> playlists = new ArrayList<>();
    public static ArrayList<User> allUsers = new ArrayList<>();
    ArrayList<User> followerList = new ArrayList<>();
    ArrayList<User> followingList = new ArrayList<>();

    public void follow (User user){
        followerList.add(user);
    }

    public void createPlaylist (String title, User owner){
        this.behavior.createPlaylist(title, owner);
    }

    public void playMusic (Music music){
        this.behavior.playMusic(music);
    }

    public void buyPremium (User owner, int month){
        this.behavior.buyPremium(owner, month);
    }

    public User (String username, String password){
        int numOfUsername = 0;
        for (User user : allUsers){
            if (user.username.equals(username)){
                numOfUsername++;
            }
        }

        if(numOfUsername == 0 && password.length() >= 8){
            this.username = username;
            this.password = password;
            this.behavior = RegularBehavior;
        }
        else if(numOfUsername != 0){
            throw new InvalidOperationException("An account with this name has already been created. Please try again.");
        }
        else {
            throw new InvalidOperationException("Password length must be greater than 8.");
        }
    }




}
