package proje;

public class PremiumBehavior implements UserBehavior{
    int month;
    
    @Override
    public void createPlaylist(String title, User owner) {
        Playlist playlist = new Playlist (title, owner);
        owner.playlists.add(playlist);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
    }
}
