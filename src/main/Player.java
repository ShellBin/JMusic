package main;
import java.io.File;

import javazoom.jlgui.basicplayer.*;

public class Player {
    public static void main(String[] args) throws Exception {
        BasicPlayer player = new BasicPlayer();
        player.open(new File("D:/test.mp3"));
        player.play();
    }
	
}
