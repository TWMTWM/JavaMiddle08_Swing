package cn.gtmap.component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 * �����
 *	JPasswordField ����� 
 *	���ı���ͬ����ȡ�����������ݣ��Ƽ�ʹ��getPassword���÷����᷵��һ���ַ����飬�����ַ���
 */
public class Test10_JPasswordField {
	public static void main(String[] args) {
		
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(200, 200);
		
		f.setLayout(new FlowLayout());
		JLabel l = new JLabel("���룺");
		//�����
		JPasswordField pf = new JPasswordField("");
		pf.setText("&48kdh4@#");
		pf.setPreferredSize(new Dimension(80,30));
		
		// ���ı���ͬ����ȡ�����������ݣ��Ƽ�ʹ��getPassword���÷����᷵��һ���ַ����飬�����ַ���
		char[] password = pf.getPassword();
		String p = String.valueOf(password);
		System.out.println(p);
		
		f.add(l);
		f.add(pf);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
