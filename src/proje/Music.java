package proje;

import java.util.ArrayList;

public class Music {

    String title;
    User singer;
    int numberOfStream;
    public static ArrayList<Music> allMusics = new ArrayList<>();

    public void play (Music music){
        System.out.println("The music" + music.title + "Sung by" + music.singer + "is playing");
        numberOfStream++;
    }

    public static ArrayList<Music> search(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.title.equals(title)) {
                result.add(music);
            }
        }

        return result.size() > 0 ? result : null;
    }

    public static Music search(String title, User singer) {
        for (Music music : allMusics) {
            if (music.title.equals(title) && music.singer.equals(singer)) {
                return music;
            }
        }
        return null;
    }

}
