package cn.gtmap.event.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ������
 *	MouseListener ��������
 *	mouseReleased ����ͷ�
 *	mousePressed ��갴��
 *	mouseExited ����˳�
 *	mouseEntered ������
 *	mouseClicked �����
�ڱ����У�ʹ��mouseEntered����������ͼƬ��ʱ��ͼƬ���ƶ�λ��
 */
public class Test03_Mouse_Listener {
	public static void main(String[] args) {
		final JFrame f = new JFrame("LoL");
		f.setSize(800,600);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		
		final JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("e:/project/JavaMiddle08_Swing/image/shana_heiheihei.png");
		l.setIcon(i);
		l.setBounds(375,275,i.getIconWidth(),i.getIconHeight());
		
		f.add(l);
		
		//������
		l.addMouseListener(new MouseListener() {
			
			//�ͷ����
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("�ͷ����");
			}
			//�������
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("�������");
			}
			//����˳�
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("����˳�");
			}
			//������
			@Override
			public void mouseEntered(MouseEvent e) {
				Random r = new Random();
				int x = r.nextInt(f.getWidth() - l.getWidth());
				int y = r.nextInt(f.getHeight() - l.getHeight());
				l.setLocation(x, y);
				System.out.println("������");
			}
			//�����ͷ���϶���Ϊ������
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("���˫��");
			}
		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
