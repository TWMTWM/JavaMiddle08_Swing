package cn.gtmap.table;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 列宽
 *
 */
public class Test03 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());
		
		//表格上的title
		String[] columnNames = new String[]{"id","name","hp","damage"};
		//表格中的内容是一个二维数组
		String[][] heros = new String[][]{
			{"1", "盖伦", "616", "100"},
			{"2", "提莫", "512", "102"},
			{"3", "奎因", "832", "200"}
		};
		
		JTable t = new JTable(heros,columnNames);
		
		JScrollPane sp = new JScrollPane(t);
		//设置宽度
		t.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		f.add(sp,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
