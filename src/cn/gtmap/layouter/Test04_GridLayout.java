package cn.gtmap.layouter;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * GridLayout
 *	GridLayout�������񲼾���
 */
public class Test04_GridLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
        //���ò�����ΪGridLayerout�������񲼾���
        //��GridLayerout�Ĺ��췽����ʾ��������2��3��		
		f.setLayout(new GridLayout(2,3));
		
		JButton b1 = new JButton("Ҽ");
		JButton b2 = new JButton("��");
		JButton b3 = new JButton("��");
		JButton b4 = new JButton("��");
		JButton b5 = new JButton("��");
		JButton b6 = new JButton("½");
		
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
