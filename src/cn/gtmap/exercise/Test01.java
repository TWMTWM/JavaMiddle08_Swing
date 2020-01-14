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
 * ��ϰ��Ϊ���ж�
 * ��JTextField���������ݣ����Ա߼�һ����ťJButton,�������ť��ʱ���ж�JTextFiled����û�����ݣ���ʹ��JOptionPane������ʾ
 */
public class Test01 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(200, 200);
		
		f.setLayout(new FlowLayout());
		
		JTextField tf = new JTextField();
		tf.setPreferredSize(new Dimension(80,30));
		JButton b = new JButton("���");
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();
				if(0 == text.length()){
					JOptionPane.showMessageDialog(f, "�ı�����Ϊ��");
					tf.grabFocus();
				}else{
					JOptionPane.showMessageDialog(f, "����������");
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
