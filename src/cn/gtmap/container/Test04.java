package cn.gtmap.container;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 窗体大小不可变化
 * 通过调用方法 setResizable(false); 做到窗体大小不可变化
 *
 */
public class Test04 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JButton b = new JButton("一键秒对方基地挂");
		b.setBounds(50, 50, 280, 30);
		
		f.add(b);
		//窗体大小不可变化
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
