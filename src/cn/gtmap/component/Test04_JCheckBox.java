package cn.gtmap.component;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 * ��ѡ��
 * JCheckBox ��ѡ��
 * ʹ��isSelected����ȡ�Ƿ�ѡ����
 */
public class Test04_JCheckBox {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);
		
		JCheckBox bCheckBox = new JCheckBox("����Ӣ��");
		//����ΪĬ��ѡ��
		bCheckBox.setSelected(true);
		bCheckBox.setBounds(50, 50, 130, 30);
		
		JCheckBox bCheckBox2 = new JCheckBox("ħ��Ӣ��");
		bCheckBox2.setBounds(50, 100, 130, 30);
		
		//�ж��Ƿ�ѡ��
		System.out.println(bCheckBox2.isSelected());
		
		f.add(bCheckBox);
		f.add(bCheckBox2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
