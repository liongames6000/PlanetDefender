/*package Schule.Planetderfender.Handler;

import Schule.Planetderfender.Objects.Canon;

import java.awt.event.*;
public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'a' : Canon.move(2); break;
            case 'd' : Canon.move(-2); break;
        }
        try {
            Thread.sleep(10);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
*/