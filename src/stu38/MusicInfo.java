package stu38;	//JavaBean

import java.io.File;
import mp3x.ctl.PlayerControl;
import java.util.ArrayList;
import java.util.List;


public class MusicInfo {
	private PlayerControl player = new PlayerControl(); 
    private File file;
    private List<Long> timeMills = new ArrayList<Long>();
    private List<String> messages = new ArrayList<String>();
   
	 public File getFile() {
		return file;
	}
	 
	//实现了简单播放控制
    public void on(){
    	player.openSong(file.getAbsolutePath());
    	player.play();
    }
    public void goon(){
    	player.resume();
    }
    public void pause(){
    	player.pause();
    }
    public void stop(){
    	player.stop();
    }
	public void setFile(File file) {
		this.file = file;
	}
	
	//播放的get set
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

	public PlayerControl getPlayer() {
		return player;
	}
}
