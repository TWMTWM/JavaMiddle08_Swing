package cn.gtmap.component;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 * ��ѡ��
 *	JRadioButton ��ѡ��
 *	ʹ��isSelected����ȡ�Ƿ�ѡ���� 
 *	����������������ѡ����Ա�ͬʱѡ�У�Ϊ��ʵ��ֻ��ѡ��һ��������Ҫ�õ�ButtonGroup
 */
public class Test05_JRadioButton {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);
		JRadioButton b1 = new JRadioButton("����Ӣ��");
		//����ΪĬ��ѡ��
		b1.setSelected(true);
		b1.setBounds(50,50,130,30);
		JRadioButton b2 = new JRadioButton("ħ��Ӣ��");
		b2.setBounds(50, 100, 130, 30);
		
		System.out.println(b2.isSelected());
		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
	}
}
