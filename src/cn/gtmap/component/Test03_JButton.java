package cn.gtmap.component;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ��ť
 *	JButton ��ͨ��ť
 */
public class Test03_JButton {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JButton b = new JButton("һ����Է����ع�");
		b.setBounds(50, 50, 280, 30);
		
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
