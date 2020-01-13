package cn.gtmap.container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * ��ϰ��ģ̬���С�仯
 *	�������һ��JFrame,������һ����ť�������� "��һ��ģ̬����"��
 *	����ð�ť���漴��һ��ģ̬���ڡ�
 *	�����ģ̬��������һ����ť���ı��� "������С", ��������ģ̬���ڵĴ�С�ͱ�����ס�����ܸı䡣 
 *	�ٴε�����ͻظ��ܹ��ı��С
 */
public class Test05 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JButton b = new JButton("��һ��ģ̬����");
		b.setBounds(50, 50, 280, 30);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog d = new JDialog(f);
				d.setTitle("����һ��ģ̬����");
				d.setModal(true);
				d.setSize(200, 150);
				d.setLocationRelativeTo(f);
				
				JButton b = new JButton("������С");
				d.add(b);
				b.addActionListener(new ActionListener() {				
					boolean resizable = false;
					@Override
					public void actionPerformed(ActionEvent e) {
						d.setResizable(resizable);
						resizable = !resizable;
						b.setText(resizable?"������С":"������С");
						
					}
				});
				d.setVisible(true);
			}
		});
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
