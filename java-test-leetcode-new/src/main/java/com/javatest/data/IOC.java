package com.javatest.data;

import java.util.Arrays;

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
        String[] ar = {"c", "d", "b", "a", "e"};
        int[] as = new int[]{10, 5, 1, 35, 1, 2, 3, 4, 5};
        int y = 10;
        Arrays.parallelSort(as);
        for (int a : as) System.out.println(a);
//        System.out.println();


    }
}
