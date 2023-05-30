package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    Random a = new Random();
    int i = a.nextInt(3);

    String Path;
    private MusicList musicList;

    public void setName(String name) {
        this.name = name;
    }

    @Value("${musicPlayer.nameFunk}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    public void setMusic(MusicList musicList) {
        this.musicList = musicList;
    }

    public void MusicPlay() {

        if (i == 1) this.setName(" Mozart");
        else if (i == 2) this.setName(" Curtis Jackson");


        System.out.println("Music: " + musicList.getMusicList(i).getSong() + "\nname :" + name + "\nvolume: " + volume);
    }

}

interface operation {
    void choose(int i);
}
