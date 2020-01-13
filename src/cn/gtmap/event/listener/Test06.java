package cn.gtmap.event.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ��ϰ�����������ƶ�
 * 	�Ѽ��̼����еĴ������ƣ�ʹ���ɵ�ǰ��ֻ�������ƶ�������Ϊ���������ƶ������ԡ�
 * 	��ʾ��keyCode�뷽��Ķ�Ӧ��ϵ
 * 	38 �� 
 * 	40 ��
 * 	37 ��
 * 	39 ��
 *
 */
public class Test06 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(580,200);
		f.setLayout(null);
		
		final JLabel l = new JLabel();
		
		ImageIcon i = new ImageIcon("e:/project/JavaMiddle08_Swing/image/shana.png");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		
		//���Ӽ��̼���
		f.addKeyListener(new KeyListener() {
			// һ�����µ������϶���
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			// ��������
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			//��������
			@Override
			public void keyPressed(KeyEvent e) {
				int step = 10;
				if(e.getKeyCode() == 38){
					// ͼƬ�����ƶ� ��x���겻�䣬y������٣�
					l.setLocation(l.getX(), l.getY() - step);
				}
				if(e.getKeyCode() == 40){
					// ͼƬ�����ƶ� ��x���겻�䣬y�������ӣ�
					l.setLocation(l.getX(), l.getY() + step);
				}
				if(e.getKeyCode() == 37){
					// ͼƬ�����ƶ� ��y���겻�䣬x������٣�
					l.setLocation(l.getX() - step, l.getY());
				}				
				if(e.getKeyCode() == 39){
					// ͼƬ�����ƶ� ��y���겻�䣬x�������ӣ�
					l.setLocation(l.getX() + step, l.getY());
				}				
				
				
			}
		});
		
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
