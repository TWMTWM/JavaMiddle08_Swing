package cn.gtmap.swing_thread;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 * 长耗时任务线程：
 * 有时候需要执行长耗时任务，比如数据库查询，文件复制，访问网络等等。

而这些操作一般都会在事件响应后发起，就会自动进入事件调度线程。 而事件调度线程又是单线程模式，其结果就会是在执行这些长耗时任务的时候，界面就无响应了。 

如图所示，当点击第一个按钮的时候，会在其中进行一个5秒钟的任务，这个期间，第一个按钮会保持按下状态，其他按钮也无法点击，出现了无响应了状态。

为了解决这个问题，Swing提供了一个SwingWorker类来解决。 SwingWorker是一个抽象类，为了使用，必须实现方法 doInBackground，在doInBackground中，就可以编写我们的任务，然后执行SwingWorker的execute方法，放在专门的工作线程中去运行。
 
SwingWorker worker = new SwingWorker() {
	protected Object doInBackground() throws Exception {
		//长耗时任务
		return null;
	}
};
worker.execute();
 

SwingWorker又是如何工作的呢？ 
当SwingWorker执行execute的时候，调用默认有10根线程的线程池，执行doInBackground中的代码，通过如下代码，可以获知执行当前SwingWorder的线程名称
 
System.out.println("执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
 *
 */
public class Test03 {
    public static void main(String[] args) {
    	 
        JFrame f = new JFrame("LoL");
        f.setSize(300, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("在事件调度线程中执行长耗时任务");
        JButton b2 = new JButton("使用SwingWorker执行长耗时任务");
        JLabel l = new JLabel("任务执行结果");
        f.add(b1);
        f.add(b2);
        f.add(l);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        b1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("开始执行完毕");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                l.setText("任务执行完毕！");
            }
        });
        b2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
 
                    @Override
                    protected Void doInBackground() throws Exception {
                        System.out.println("执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
                        l.setText("开始执行");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        l.setText("任务执行完毕");
                        return null;
                    }
                };
                worker.execute();
 
            }
        });
 
        f.setVisible(true);
    }	
}
