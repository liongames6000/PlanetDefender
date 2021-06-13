package Schule.Planetderfender;

import Schule.Planetderfender.Handler.GuiHandler;
//import Schule.Planetderfender.Handler.KeyHandler;
import Schule.Planetderfender.Handler.SoundHandler;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

class PlanetDefender {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        //KeyHandler keyHandler = new KeyHandler();

        SoundHandler music = new SoundHandler("Background_music.wav");
        SoundHandler shot = new SoundHandler("cannon_shot.wav");
        SoundHandler explosion = new SoundHandler("Explosion.wav");
        explosion.load();
        music.load();
        shot.load();
        music.play();
        shot.loop(-1);
        explosion.play();
        Thread.sleep(explosion.getLengthInMillis());
        explosion.unload();
        Thread.sleep((music.getLengthInMillis()/10)*9);
    }
}