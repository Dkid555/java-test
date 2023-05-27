package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicList {


    public List<Music> musicList = new ArrayList<>();

    @Autowired
    public MusicList(@Qualifier("funkMusic") Music music1, @Qualifier("classicalMusic") Music music2, @Qualifier("rapMusic") Music music3) {
        musicList.add(music1);
        musicList.add(music2);
        musicList.add(music3);
    }

    public Music getMusicList(int i) {
        return musicList.get(i);
    }

}
