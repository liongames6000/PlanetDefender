package schule.planetdefender.handler;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundHandler {
    Clip clip;
    AudioInputStream audioStream;
    String workingDirectory = System.getProperty("user.dir");
    String absoluteFilePath;
    //enter filename/path to create SoundHandler Object
    public SoundHandler(String file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        //searches for path of file
        String workingDirectory = System.getProperty("user.dir");
        absoluteFilePath = workingDirectory + File.separator + "src" + File.separator + "main"+ File.separator + "resources"+ File.separator + "audio" + File.separator + file;


        File audio = new File(absoluteFilePath); //filename conversion to <<File>> class object
        audioStream = AudioSystem.getAudioInputStream(audio); //Audio transcription from file
        //clip creation
        clip = AudioSystem.getClip();


    }
    //loads audio clip
    public void load() throws LineUnavailableException, IOException {
        clip.open(audioStream);
        System.out.println("clip loaded");
    }
    //unloads audio clip
    public void unload(){
        clip.close();
        System.out.println("clip unloaded");
    }
    //starts the clip
    public void play(){
        clip.start();
        System.out.println("clip started");
    }
    //stops the clip
    public void stop(){
        clip.stop();
        System.out.println("clip stopped");
    }

    //loops audio use -1 for infinity
    public void loop(int count){
        if(count == -1){
            //longest short
            count = 32767;
        }
        clip.loop(count);//32 767 repetitions
        System.out.println("clip looping");
    }

    //gives length of clip in millis back
    public int getLengthInMillis(){
        return Math.toIntExact(clip.getMicrosecondLength()/1000);
    }

}
