package cn.gtmap.container;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * �����С���ɱ仯
 * ͨ�����÷��� setResizable(false); ���������С���ɱ仯
 *
 */
public class Test04 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JButton b = new JButton("һ����Է����ع�");
		b.setBounds(50, 50, 280, 30);
		
		f.add(b);
		//�����С���ɱ仯
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
