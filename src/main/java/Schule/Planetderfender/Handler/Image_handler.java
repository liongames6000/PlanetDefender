package Schule.Planetderfender.Handler;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ImageHandler {
   
    String workingDirectory = System.getProperty("user.dir");
    String absoluteFilePath;
    //enter filename/path to create SoundHandler Object
    public SoundHandler(String file) throws IOException{

        //searches for path of file
        String workingDirectory = System.getProperty("user.dir");
        absoluteFilePath = workingDirectory + File.separator + "src" + File.separator + "main"+ File.separator + "resources"+ File.separator + "images" + File.separator + file;
        File image = new File(absoluteFilePath); //filename conversion to <<File>> class object
         int height = image.getHeight();
        int width = image.getWidth();


    }
    //loads audio clip
    public void load(String file)throws IOException{
        String workingDirectory = System.getProperty("user.dir");
        absoluteFilePath = workingDirectory + File.separator + "src" + File.separator + "main"+ File.separator + "resources"+ File.separator + "images" + File.separator + file;
        clip.open(audioStream);
        System.out.println("image loaded to 'clipboard'");
    }
    //unloads audio clip
    public void unload()throws IOException{
        clip.close();
        System.out.println("cleared clipboard of Image_Handler");
    }
    //starts the clip
    public void get_image()throws IOException{
        
    }
}
