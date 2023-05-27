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
    @Value("${musicPlayer.nameRap}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    public void setMusic(MusicList musicList) {
        this.musicList = musicList;
    }

    public void MusicPlay() {

        operation choose = (int i) -> {
            if (i == 0)
                Path = "${musicPlayer.nameRap}";
            else if (i == 1)
                Path = "${musicPlayer.nameClassic}";
            else Path = "${musicPlayer.nameFunk}";
        };

        System.out.println("Music: " + musicList.getMusicList(i).getSong() + "\nname :" + name + "\nvolume: " + volume);
    }

}

interface operation {
    void choose(int i);
}
