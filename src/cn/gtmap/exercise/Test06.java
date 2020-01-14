package cn.gtmap.exercise;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * 进度条
 *
 */
public class Test06 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(200, 200);
		
		f.setLayout(new FlowLayout());
		
		JProgressBar pb = new JProgressBar();
		
		pb.setMaximum(100);
		pb.setValue(0);
		
		//显示当前进度
		pb.setStringPainted(true);
		
		new Thread(){
			public void run(){
				int sleep = 100;
				for (int i = 0; i < 100; i++) {
					pb.setValue(i + 1);
					//进度大于90时，变得更慢
					if(pb.getValue() > 90){
						try {
							Thread.sleep(sleep + i*10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						try {
							Thread.sleep(sleep + i* 2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
		f.add(pb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
