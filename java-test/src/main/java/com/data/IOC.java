package com.data;

interface Music {
    int checkID();
}

class Rock implements Music {

    @Override
    public int checkID() {
        return 1;
    }
}

class Classic implements Music {

    @Override
    public int checkID() {
        return 2;
    }
}

class MusicPlayer {
    private Music music;

    // зависимость внедряется из вне
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
//
//
    }
}

public class IOC {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer(new Rock());
        musicPlayer.playMusic();

    }
}