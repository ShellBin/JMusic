package stu38;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import stu38.MusicInfo;

public class PlayerControl {
	private List<MusicInfo> mpLists = new ArrayList<MusicInfo>();
	
	LrcProcessor lrc;
	public PlayerControl(){
		lrc = new LrcProcessor();
	}
	public void add(File[]files){
		LrcProcessor lrc = new LrcProcessor();
		File childfiles = new File("D:\\lrc");
		for(File file:files){
			MusicInfo mp3Info = new MusicInfo();
			mp3Info.setFile(file);
			for(File fi:childfiles.listFiles()){
				if(removeIndex(fi.getName()).equals(removeIndex(file.getName()))){
					try {
						InputStream input = new FileInputStream(fi);
						lrc.process(input, mp3Info.getTimeMills(), mp3Info.getMessages());
						
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			mpLists.add(mp3Info);
		}
		
	}
	private String removeIndex(String name){
		int ind = name.indexOf('.');
		String child = name.substring(0, ind);
		return child;
	}
	public List<MusicInfo> getMpLists() {
		return mpLists;
	}
	public void setMpLists(List<MusicInfo> mpLists) {
		this.mpLists = mpLists;
	}
	
}