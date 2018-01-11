package stu38;

import javax.swing.*;
import org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel;

import stu38.PlayerUI;

public class MainFrame {
	
	public static void main(String[]args){
		try {
			UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		PlayerUI ui = new PlayerUI();
	}
	
}
