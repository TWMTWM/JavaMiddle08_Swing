package cn.gtmap.event.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ���̼���
 * 	���̼������� KeyListener
 * 	keyPressed ���� ��������
 * 	keyReleased ���� ��������
 * 	keyTyped ���� һ�����µ������϶���
 * 	KeyEvent.getKeyCode() ���Ի�ȡ��ǰ�������ĸ���
 *
 */
public class Test02_KeyBoard_Listener {

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
			//һ�����µ������϶���
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			//��������
			@Override
			public void keyReleased(KeyEvent e) {
				// 39�������� ���Ҽ���
				if(e.getKeyCode() == 39){
					// ͼƬ�����ƶ� ��y���겻�䣬x�������ӣ�
					l.setLocation(l.getX() + 10,l.getY());
				}
			}
			//��������
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);	
		
	}

}
