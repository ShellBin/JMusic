package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;


public class MusicInfo {
	private BasicPlayer player = new BasicPlayer();
    private File file;
    private List<Long> timeMills = new ArrayList<Long>();
    private List<String> messages = new ArrayList<String>();
   
	public File getFile() {
		return file;
	}
	
    public void on() throws BasicPlayerException{
    	player.open(file);
    	player.play();
    }
    
    public void goon() throws BasicPlayerException{
    	player.resume();
    }
    
    public void pause() throws BasicPlayerException{
    	player.pause();
    }
    
    public void stop() throws BasicPlayerException{
    	player.stop();
    }
    
	public void setFile(File file) {
		this.file = file;
	}

	public List<Long> getTimeMills() {
		return timeMills;
	}

	public void setTimeMills(List<Long> timeMills) {
		this.timeMills = timeMills;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public BasicController getPlayer() {
		return player;
	}
	
}
