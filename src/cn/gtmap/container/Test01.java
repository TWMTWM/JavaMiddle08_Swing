package cn.gtmap.container;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Jframe
 *	JFrame����õĴ�����������Ĭ������£������Ͻ��������С����ť
 */
public class Test01 {
	public static void main(String[] args) {
		//��ͨ�Ĵ��壬��������С����ť
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
