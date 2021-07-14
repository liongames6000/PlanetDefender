package schule.planetdefender.Objects;

import schule.planetdefender.handler.GuiHandler;

public class Canon {
    private int xCoordinate = 320; //xCoordinate is set to middle
    private final int yCoordinate = 1080; //yCoordinate is set to bottom;
    public Canon(){

    }

    public void move(int speedX){
        xCoordinate = xCoordinate + speedX;
        GuiHandler.drawCanon(xCoordinate,yCoordinate);
        System.out.println(xCoordinate);
    }
}
