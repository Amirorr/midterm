package proje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Playlist {
    private String title;
    private User user;
    public ArrayList<Music> playlist = new ArrayList<>();

    public Playlist(String title, User user) {
        this.title = title;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void editTitle(String oldName, String newName, String password) throws InvalidOperationException {

        if (getUser().getPassword() != password) {
            throw new InvalidOperationException("The password is incorrect. Please try again. ");
        }

        for (Playlist playlist1 : getUser().playlists) {
            if (playlist1.getTitle().equals(oldName)) {
                playlist1.setTitle(newName);
            }
        }
    }

    public void addMusic(Music music, String password) throws InvalidOperationException {
        if (playlist.contains(music)) {
            throw new InvalidOperationException("this music already exist.");
        }
        if (getUser().getPassword()!= password) {
            throw new InvalidOperationException("The password is incorrect. Please try again. ");
        }
        playlist.add(music);

    }

    public void removeMusic(Music music, String password) throws InvalidOperationException {
        if (getUser().getPassword() != password) {
            throw new InvalidOperationException("The password is incorrect. Please try again. ");
        }

        if (!playlist.contains(music)) {
            throw new InvalidOperationException("this music not exist");
        }
        playlist.remove(music);
    }

    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : playlist) {
            if (music.title.equals(title)) {
                result.add(music);
            }
        }
        return result.size() > 0 ? result : null;
    }


    public Music searchInPlaylist(String title, User singer) {
        for (Music music : playlist) {
            if (music.title.equals(title) && music.singer.equals(singer)) {
                return music;
            }
        }
        return null;
    }

    public void playPlaylist() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("next")) {
            for (Music music : playlist) {
                music.play(music);
                if (!scanner.nextLine().equals("next")) {
                    break;
                }
            }
        }
    }

    public void shuffle (){
        //random play
        Collections.shuffle(playlist);
        playPlaylist();
    }
}

