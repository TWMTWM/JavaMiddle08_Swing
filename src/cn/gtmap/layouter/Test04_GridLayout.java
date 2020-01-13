package cn.gtmap.layouter;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * GridLayout
 *	GridLayout，即网格布局器
 */
public class Test04_GridLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
        //设置布局器为GridLayerout，即网格布局器
        //该GridLayerout的构造方法表示该网格是2行3列		
		f.setLayout(new GridLayout(2,3));
		
		JButton b1 = new JButton("壹");
		JButton b2 = new JButton("贰");
		JButton b3 = new JButton("叁");
		JButton b4 = new JButton("肆");
		JButton b5 = new JButton("伍");
		JButton b6 = new JButton("陆");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
