package proje;

public class RegularBehavior implements UserBehavior{

    int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner) {
        throw new InvalidOperationException("You cannot create a playlist because your account does not have this capability.");
    }

    @Override
    public void playMusic(Music music) {
        if(playingLimit != 0){
            music.play();
            playingLimit--;
        }
        else {
            throw new InvalidOperationException("You can no longer listen to music because your account is limited.");
        }

    }

    @Override
    public void buyPremium(User owner, int month) {
        PremiumBehavior premiumBehavior = new PremiumBehavior();
        owner.behavior() = premiumBehavior;
    }
}
