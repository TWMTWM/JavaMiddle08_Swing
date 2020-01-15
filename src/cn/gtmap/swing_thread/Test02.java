package cn.gtmap.swing_thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * 事件调度线程
 * 	以 按钮监听 中的代码为例，ActionListener.actionPerformed 中的代码，就是事件调度线程执行的。
 * 	可以借助SwingUtilities.isEventDispatchThread() 确认，是事件调度线程在执行相应的代码
 * 	那么事件调度线程又是如何去执行这段代码的呢？ 这就不用你操心啦, 要解释这个问题，就需要剖析整个Swing的框架，就不是本章节所能展示的内容啦
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
		
		JButton b = new JButton("隐藏图片");
		b.setBounds(150, 200, 100, 30);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				l.setVisible(false);
				System.out.println("当前使用的是事件调度线程：" + SwingUtilities.isEventDispatchThread());
			}
		});
		f.add(l);
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
