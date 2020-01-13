package cn.gtmap.component;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 * 复选框
 * JCheckBox 复选框
 * 使用isSelected来获取是否选中了
 */
public class Test04_JCheckBox {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);
		
		JCheckBox bCheckBox = new JCheckBox("物理英雄");
		//设置为默认选中
		bCheckBox.setSelected(true);
		bCheckBox.setBounds(50, 50, 130, 30);
		
		JCheckBox bCheckBox2 = new JCheckBox("魔法英雄");
		bCheckBox2.setBounds(50, 100, 130, 30);
		
		//判断是否被选中
		System.out.println(bCheckBox2.isSelected());
		
		f.add(bCheckBox);
		f.add(bCheckBox2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
