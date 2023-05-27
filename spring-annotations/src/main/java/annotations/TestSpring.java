package annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.MusicPlay();
//        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
//        System.out.println(musicPlayer1 == musicPlayer);
//
//
//        Music music = context.getBean("classicalMusic", ClassicalMusic.class);
//        Music music1 = context.getBean("funkMusic", FunkMusic.class);
//        System.out.println(music1.getSong() + "\n" + music1 + " " + music + " " + (music1 == music));
//        context.close();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.MusicPlay();
        context.close();
    }
}
