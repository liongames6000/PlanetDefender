package Schule.Planetderfender.Handler;

import java.util.Scanner;

public class KeyHandler {
    public KeyHandler(){
        Scanner keyInput = new Scanner(System.in);

        String response = keyInput.next().toUpperCase();

        switch(response){
            case("A"): ; break;
            case("D"): ; break;
            default: ;
        }
    }
}
