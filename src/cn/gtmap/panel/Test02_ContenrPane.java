package cn.gtmap.panel;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ContentPane
 * 	JFrame����һ����壬����ContentPane
 * 	ƽʱͨ��f.add()��JFrame�����������ʵ����JFrame�ϵ� ContentPane�Ӷ���
 *
 */
public class Test02_ContenrPane {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		
		f.setLayout(null);
		
		JButton b1 = new JButton("һ����Է����ع�");
		b1.setBounds(50, 50, 280, 30);
		
		JButton b2 = new JButton("һ����ɱ");
		b2.setBounds(50,100,280,30);
		
		f.add(b1);
        // JFrame����һ����壬����ContentPane
        // ƽʱͨ��f.add()��JFrame�����������ʵ����JFrame�ϵ� ContentPane�Ӷ���
        // f.add(b1)��ͬ��f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		
        // b2.getParent()��ȡ��ťb�����ڵ�����
        // ��ӡ�������Կ�����ʵ������ContentPane����JFrame
		System.out.println(b2.getParent());//javax.swing.JPanel[null.contentPane,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
