package cn.gtmap.panel;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ContentPane
 * 	JFrame上有一层面板，叫做ContentPane
 * 	平时通过f.add()向JFrame增加组件，其实是向JFrame上的 ContentPane加东西
 *
 */
public class Test02_ContenrPane {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		
		f.setLayout(null);
		
		JButton b1 = new JButton("一键秒对方基地挂");
		b1.setBounds(50, 50, 280, 30);
		
		JButton b2 = new JButton("一键秒杀");
		b2.setBounds(50,100,280,30);
		
		f.add(b1);
        // JFrame上有一层面板，叫做ContentPane
        // 平时通过f.add()向JFrame增加组件，其实是向JFrame上的 ContentPane加东西
        // f.add(b1)等同于f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		
        // b2.getParent()获取按钮b所处于的容器
        // 打印出来可以看到，实际上是ContentPane而非JFrame
		System.out.println(b2.getParent());//javax.swing.JPanel[null.contentPane,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
