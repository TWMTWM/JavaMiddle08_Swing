package cn.gtmap.swing_thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * �¼������߳�
 * 	�� ��ť���� �еĴ���Ϊ����ActionListener.actionPerformed �еĴ��룬�����¼������߳�ִ�еġ�
 * 	���Խ���SwingUtilities.isEventDispatchThread() ȷ�ϣ����¼������߳���ִ����Ӧ�Ĵ���
 * 	��ô�¼������߳��������ȥִ����δ�����أ� ��Ͳ����������, Ҫ����������⣬����Ҫ��������Swing�Ŀ�ܣ��Ͳ��Ǳ��½�����չʾ��������
 */
public class Test02 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);
		
		final JLabel l = new JLabel();
		
		ImageIcon i = new ImageIcon("e:/project/JavaMiddle08_Swing/image/shana.png");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		
		JButton b = new JButton("����ͼƬ");
		b.setBounds(150, 200, 100, 30);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				l.setVisible(false);
				System.out.println("��ǰʹ�õ����¼������̣߳�" + SwingUtilities.isEventDispatchThread());
			}
		});
		f.add(l);
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
