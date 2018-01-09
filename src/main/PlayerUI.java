package main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlayerUI extends JFrame implements ActionListener{
	ImageIcon img=new ImageIcon("");
	JLabel cover = new JLabel(img);
	
	JButton[] bbf =  new JButton[3];
	
    public static void main(String[] args) {
    	PlayerUI t=new PlayerUI();
	}
	
	public PlayerUI() {
		Container c = this.getContentPane();
		c.setLayout(null);
		this.setSize(300, 300);
		this.setLocation(400,400);
		this.setTitle("Jolita Music!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		cover.setBounds(300,300,0,0);
		c.add(cover);
		
		for(int i=0;i<bbf.length;i++) {
			bbf[i]=new JButton();
			bbf[i].setBounds(27+i*100, 220, 40, 40);
			bbf[i].setActionCommand(""+i);
			bbf[i].addActionListener(this);
			c.add(bbf[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		System.out.println(e.getActionCommand());
		img = new ImageIcon("D:/Users/Shell/Pictures/板绘/Wendy 5.20 final.jpg");
		cover.setIcon(img);
	}

}
