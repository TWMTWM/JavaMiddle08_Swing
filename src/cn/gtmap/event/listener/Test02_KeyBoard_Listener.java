package cn.gtmap.event.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 键盘监听
 * 	键盘监听器： KeyListener
 * 	keyPressed 代表 键被按下
 * 	keyReleased 代表 键被弹起
 * 	keyTyped 代表 一个按下弹起的组合动作
 * 	KeyEvent.getKeyCode() 可以获取当前点下了哪个键
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
		
		//增加键盘监听
		f.addKeyListener(new KeyListener() {
			//一个按下弹起的组合动作
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			//键被弹起
			@Override
			public void keyReleased(KeyEvent e) {
				// 39代表按下了 “右键”
				if(e.getKeyCode() == 39){
					// 图片向右移动 （y坐标不变，x坐标增加）
					l.setLocation(l.getX() + 10,l.getY());
				}
			}
			//键被按下
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);	
		
	}

}
