package Schule.Planetderfender.Handler;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ImageHandler {
   
    String workingDirectory = System.getProperty("user.dir");
    String absoluteFilePath;
		Image image;
		//BufferedImage bimg,tempBimg;
    //enter filename/path to create SoundHandler Object
    public SoundHandler() throws IOException{

        //searches for path of file
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        int height = image.getHeight();
        int width = image.getWidth();


    }
    //loads Image
    public void load(String file)throws IOException{
        String workingDirectory = System.getProperty("user.dir");
        absoluteFilePath = workingDirectory + File.separator + "src" + File.separator + "main"+ File.separator + "resources"+ File.separator + "images" + File.separator + file;
        File imageFile = new File(absoluteFilePath);
				BufferedImage tempBimg = ImageIO.read(imageFile);
				int width  = tempBimg.getWidth();
				int height = tempBimg.getHeight();
				bimg = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				Image image = bimg
        System.out.println("image loaded to 'clipboard'");
    }

    //public void unload()throws IOException{
        clip.close();
        System.out.println("cleared clipboard of Image_Handler");
    }
    //starts the clip
    public Image get_image()throws IOException{
        return image
    }
}
