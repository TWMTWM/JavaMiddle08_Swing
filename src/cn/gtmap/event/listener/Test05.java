package cn.gtmap.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ��ϰ���л���ʾ
 * 	�Ѱ�ť�����еİ�ť�ϵ����ִӡ�����ͼƬ�� ��Ϊ "��ʾͼƬ"��
 * 	��һ�ε����ʱ�򣬻�ʹ��ͼƬ���أ��ڶ��ε����ʱ�򣬻�ʹ��ͼƬ��ʾ�����ѭ����ȥ��
 * 	һ�������"����ͼƬ"����ť�ϵ����־�Ҫ��ɡ���ʾͼƬ�� ������ ���ѭ��
 * 	��ʾ�� ����JButton�����setText�ı䰴ť�ϵ�����
 */
public class Test05 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580,200);
		f.setLayout(null);
		
		final JLabel l = new JLabel();
		
		ImageIcon i = new ImageIcon("e:/project/JavaMiddle08_Swing/image/shana_heiheihei.png");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		
		JButton b = new JButton("����ͼƬ");
		b.setBounds(150, 200, 100, 30);
		
		// ����ť ���� ����
		b.addActionListener(new ActionListener() {
            // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
            // actionPerformed �����ͻᱻִ��
			boolean hide = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				l.setVisible(hide);
				hide = !hide;
				b.setText(hide?"��ʾͼƬ":"����ͼƬ");
			}
		});
		
		f.add(l);
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
