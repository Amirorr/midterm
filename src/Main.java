

import proje.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== STARTING TESTS =====");

        // creat account
        User u1 = null, u2 = null;
        try {
            u1 = new User("mahdi", "12345678");
            u2 = new User("sara", "abcdefgh");
            System.out.println("Users created successfully.");
        } catch (InvalidOperationException e) {
            System.out.println("User creation failed: " + e.getMessage());
        }

         if (u1 != null && u2 != null) {
            u1.follow(u2);
            System.out.println(u1.username + " followed " + u2.username);
            System.out.println("Followers of " + u2.username + ": " + u2.getFollowerList());
        }

        // test regular user
        try {
            u1.createPlaylist("My Playlist", u1);
        } catch (InvalidOperationException e) {
            System.out.println("Create playlist (regular): " + e.getMessage());
        }

        // perimum
        try {
            u1.buyPremium(u1, 2);
            System.out.println(u1.username + " upgraded to premium.");
        } catch (InvalidOperationException e) {
            System.out.println("Buy premium failed: " + e.getMessage());
        }

        // creat play list
        try {
            u1.createPlaylist("My Playlist", u1);
            System.out.println("Playlist created after premium.");
        } catch (InvalidOperationException e) {
            System.out.println("Create playlist failed again: " + e.getMessage());
        }

        // add music and play
        Music m1 = new Music("Track 1", u1);
        Music m2 = new Music("Track 2", u2);
        Music.allMusics.add(m1);
        Music.allMusics.add(m2);

        try {
            u1.playMusic(m1);
            u1.playMusic(m2);
            System.out.println("Music played.");
        } catch (InvalidOperationException e) {
            System.out.println("Play music failed: " + e.getMessage());
        }

        // add music to play list
        Playlist p = u1.playlists.get(0);
        try {
            p.addMusic(m1, "12345678");
            p.addMusic(m2, "12345678");
            System.out.println("Songs added to playlist.");
        } catch (InvalidOperationException e) {
            System.out.println("Add music failed: " + e.getMessage());
        }

        // test play
        System.out.println("Playing playlist (write 'next' to continue to next song):");
        p.playPlaylist();

        // test shuffle
        System.out.println("Shuffling and playing again:");
        p.shuffle();

        // search play list
        System.out.println("Searching in playlist:");
        var found = p.searchInPlaylist("Track 1");
        if (!found.isEmpty()) {
            System.out.println("Found song(s):");
            for (Music m : found) {
                System.out.println(m.title);
            }
        } else {
            System.out.println("No song found with that title.");
        }

        System.out.println("===== END OF TESTS =====");
    }
}