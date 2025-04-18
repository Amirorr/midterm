package proje;

import java.util.ArrayList;

public class User {
    public String username;
    private String password;
    public UserBehavior behavior;
    public ArrayList<Playlist> playlists = new ArrayList<>();
    public static ArrayList<User> allUsers = new ArrayList<>();
    public ArrayList<User> followerList = new ArrayList<>();
    public ArrayList<User> followingList = new ArrayList<>();

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void follow (User user){

        this.followingList.add(user);
        user.followerList.add(this);
    }



    public ArrayList<String> getFollowerList() {
       ArrayList<String> follower = new ArrayList<>();
        for (User user : followerList){
           follower.add(user.username);
        }
        return follower;
    }

    public ArrayList<String> showPlaylists(){
        ArrayList<String> result = new ArrayList<>();
        for (Playlist playlist : playlists){
            result.add(playlist.getTitle());
        }
        return result;

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
            RegularBehavior regularBehavior = new RegularBehavior();
            behavior = regularBehavior;
            allUsers.add(this);

        }
        else if(numOfUsername != 0){
            throw new InvalidOperationException("An account with this name has already been created. Please try again.");
        }
        else {
            throw new InvalidOperationException("Password length must be greater than 8.");
        }
    }




}
