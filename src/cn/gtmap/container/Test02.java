package cn.gtmap.container;

import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * JDialog
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//��ͨ�Ĵ��壬��������С����ť�����Ի���ȴ����
		JDialog d = new JDialog();
		d.setTitle("LoL");
		d.setSize(400,300);
		d.setLocation(200, 200);
		d.setLayout(null);
		 
		JButton b = new JButton("һ����Է����ع�");
		b.setBounds(50,50,280,30);
		
		d.add(b);
		
		//d.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		d.setVisible(true);
		
	}
}
