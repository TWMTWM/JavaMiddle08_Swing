package cn.gtmap.swing_thread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 * 初始化线程
 * 如代码所示，同时我们在初始化一个图形界面的时候，都会直接在主方法的主线程里，直接调用如下代码来进行初始化
 * new TestFrame().setVisible(true);
 * 如果是小程序这没有什么问题，如果是复杂的程序就有可能产生问题了。因为这里有两个线程在同时访问组件：1. 主线程 2. 事件调度线程。 如果是复杂的图形界面程序，就有可能出现这两个线程同时操作的情况，导致同步问题的产生。
 * 为了规避这个问题的产生，创建和显示界面的工作，最好也交给事件调度线程，这样就保证了只有一个线程在访问这些组件
 * SwingUtilities.invokeLater(new Runnable() {
 * 	public void run() {
 * 		new TestFrame().setVisible(true);
 * 		}
 * 	});
 * 像这样，new TestFrame().setVisible(true); 这段代码就是在事件调度线程中执行了。
 * 还可以使用SwingUtilities.isEventDispatchThread()来判断当前线程是否是事件调度线程
 *
 */
public class Test01 {
	public static void main(String[] args) {
		
		//new TestFrame().setVisible(true);
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TestFrame().setVisible(true);
			}
		});
		
	}
	
	static class TestFrame extends JFrame{
		public TestFrame(){
			setTitle("LoL");
			setSize(400, 300);
			setLocation(200, 200);
			setLayout(null);
			
			JButton b = new JButton("一键秒对方基地挂");
			b.setBounds(50, 50, 280, 30);
			
			add(b);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			System.out.println("当前线程是否是 事件调度线程: " + SwingUtilities.isEventDispatchThread());
		}
	}
}
