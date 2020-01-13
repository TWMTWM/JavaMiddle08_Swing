package cn.gtmap.component;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * 下拉框
 *	JComboBox 下拉框
 *	使用getSelectedItem来获取被选中项
 *	使用setSelectedItem() 来指定要选中项
 */
public class Test07_JComboBox {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(580, 240);
		f.setLayout(null);
		
		//下拉框出现的条目
		String[] heros = new String[]{"卡特琳娜","库奇"};
		JComboBox<String> cb = new JComboBox<String>(heros);
		
		cb.setBounds(50, 50, 80, 30);
		
		f.add(cb);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
	}
}
