package cn.gtmap.component;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ��ǩ
 *	Label������ʾ����
 */
public class Test01_JLabel {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JLabel l = new JLabel("LoL����");
		//������ɫ
		l.setForeground(Color.red);
		l.setBounds(50, 50, 280, 30);
		
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
