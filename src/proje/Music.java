package proje;

import java.util.ArrayList;

public class Music {

    public String title;
    public User singer;
    public int numberOfStream = 0 ;
    public static ArrayList<Music> allMusics = new ArrayList<>();

    public Music (String title, User singer){
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }
    public void play (Music music){
        System.out.println("The music  " + music.title + " Sung by" + music.singer.username + "is playing");
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

    public ArrayList<String> showMusic(){
        ArrayList<String> result = new ArrayList<>();
        for (Music music : allMusics){
            result.add(music.title);
        }
        return result;

    }

}
