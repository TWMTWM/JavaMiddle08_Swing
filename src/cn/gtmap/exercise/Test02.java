package cn.gtmap.exercise;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 练习：数字校验
 * 	在JTextField中输入数据，在旁边加一个按钮JButton,
 * 	当点击按钮的时候，判断JTextFiled中的数据是否是数字，并使用JOptionPane进行提示	
 */
public class Test02 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		
		f.setLocation(200, 200);
		
		f.setLayout(new FlowLayout());
		
		JTextField tf = new JTextField();
		
		tf.setPreferredSize(new Dimension(80,30));
		
		JButton b = new JButton("检测");
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();
				try {
					Integer.parseInt(text);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(f, "输入框内容不是整数");
					tf.grabFocus();
				}
			}
		});
		
		f.add(tf);
		f.add(b);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
			
		
	}
}
