package schule.planetdefender.handler;
import javax.swing.*;
import java.io.File;

public class GuiHandler extends JFrame {

    public GuiHandler()
     {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 640;
        int height = 1080;
        this.setSize(width, height);
        this.setLayout(null);
        this.setVisible(true);
        this.setName("PlanetDefender");
    }
    public static void drawCanon(int xMid, int yMid){
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFile = workingDirectory + File.separator + "src" + File.separator + "main"+ File.separator + "resources"+ File.separator + "images" + File.separator + "canon";

        JLabel canonLabel = new JLabel();
        ImageIcon canonImage = new ImageIcon(absoluteFile);

        canonLabel.setBounds(xMid,yMid,0,0);
        canonLabel.setIcon(canonImage);
    }
}
