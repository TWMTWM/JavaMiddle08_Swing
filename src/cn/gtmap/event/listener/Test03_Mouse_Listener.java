package cn.gtmap.event.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 鼠标监听
 *	MouseListener 鼠标监听器
 *	mouseReleased 鼠标释放
 *	mousePressed 鼠标按下
 *	mouseExited 鼠标退出
 *	mouseEntered 鼠标进入
 *	mouseClicked 鼠标点击
在本例中，使用mouseEntered，当鼠标进入图片的时候，图片就移动位置
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
		
		//鼠标监听
		l.addMouseListener(new MouseListener() {
			
			//释放鼠标
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("释放鼠标");
			}
			//按下鼠标
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("按下鼠标");
			}
			//鼠标退出
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("鼠标退出");
			}
			//鼠标进入
			@Override
			public void mouseEntered(MouseEvent e) {
				Random r = new Random();
				int x = r.nextInt(f.getWidth() - l.getWidth());
				int y = r.nextInt(f.getHeight() - l.getHeight());
				l.setLocation(x, y);
				System.out.println("鼠标进入");
			}
			//按下释放组合动作为点击鼠标
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("鼠标双击");
			}
		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
