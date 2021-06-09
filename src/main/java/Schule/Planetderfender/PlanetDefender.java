package Schule.Planetderfender;

import Schule.Planetderfender.Handler.GuiHandler;
import Schule.Planetderfender.Handler.SoundHandler;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

class PlanetDefender {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        /*System.out.println(GuiHandler.getInstance().getSize());
        GuiHandler.getInstance().wait(1000);
        GuiHandler.getInstance().drawCircle(100,100,50);
        GuiHandler.getInstance().redraw();
        GuiHandler.getInstance().wait(1000);
        GuiHandler.getInstance().deleteCircle(100,100,50);
        GuiHandler.getInstance().redraw();
        GuiHandler.getInstance().wait(1000);
        GuiHandler.getInstance().drawCircle(100,100,70);
        GuiHandler.getInstance().redraw();
        GuiHandler.getInstance().wait(1000);
        GuiHandler.getInstance().drawCircle(100,100,70);
        GuiHandler.getInstance().redraw();*/
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