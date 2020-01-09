package cn.gtmap.hello.swing;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 简单的例子
 * 	JFrame是GUI中的容器 
 * 	JButton是最常见的组件- 按钮 
 * 	注意：f.setVisible(true); 会对所有的组件进行渲染，所以一定要放在最后面
 *
 */
public class Test01_HelloSwing {
	public static void main(String[] args) {
		//主窗体
		JFrame f = new JFrame("LoL");
		
		//主窗体设置大小：宽和高
		f.setSize(400, 300);
		
		//主窗体设置位置
		f.setLocation(200, 200);
		
		//主窗体中的组件设置为绝对定位
		f.setLayout(null);
		
		//按钮组件
		JButton b = new JButton("一键秒对方基地挂");
		
		// 同时设置组件的大小和位置
		b.setBounds(50,50,280,30);
		
		// 把按钮加入到主窗体中
		f.add(b);
		
		//关闭窗体的时候退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 让窗体变得可见
		f.setVisible(true);
	}
}
