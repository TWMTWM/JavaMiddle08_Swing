package cn.gtmap.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ��ť����
 * 	����һ��������ʵ��ActionListener�ӿڣ�����ť�����ʱ��actionPerformed�����ͻᱻ����
 *
 */
public class Test01_Button_Listener {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(580, 200);
		f.setLayout(null);
		
		final JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("e:/project/JavaMiddle08_Swing/image/shana.png");
		l.setIcon(i);
		l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
		
		JButton b = new JButton("����ͼƬ");
		b.setBounds(150,200,100,30);
		
		//����ť���Ӽ���
		b.addActionListener(new ActionListener() {
			
            // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
            // actionPerformed �����ͻᱻִ��
			@Override
			public void actionPerformed(ActionEvent e) {
				l.setVisible(false);
			}
		});
		f.add(l);
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
