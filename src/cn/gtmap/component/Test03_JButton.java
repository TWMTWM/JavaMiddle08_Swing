package cn.gtmap.component;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 按钮
 *	JButton 普通按钮
 */
public class Test03_JButton {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JButton b = new JButton("一键秒对方基地挂");
		b.setBounds(50, 50, 280, 30);
		
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
