package cn.gtmap.component;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * ������
 *	JComboBox ������
 *	ʹ��getSelectedItem����ȡ��ѡ����
 *	ʹ��setSelectedItem() ��ָ��Ҫѡ����
 */
public class Test07_JComboBox {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(580, 240);
		f.setLayout(null);
		
		//��������ֵ���Ŀ
		String[] heros = new String[]{"��������","����"};
		JComboBox<String> cb = new JComboBox<String>(heros);
		
		cb.setBounds(50, 50, 80, 30);
		
		f.add(cb);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
	}
}
