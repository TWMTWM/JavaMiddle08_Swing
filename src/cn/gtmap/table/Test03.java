package cn.gtmap.table;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * �п�
 *
 */
public class Test03 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());
		
		//����ϵ�title
		String[] columnNames = new String[]{"id","name","hp","damage"};
		//����е�������һ����ά����
		String[][] heros = new String[][]{
			{"1", "����", "616", "100"},
			{"2", "��Ī", "512", "102"},
			{"3", "����", "832", "200"}
		};
		
		JTable t = new JTable(heros,columnNames);
		
		JScrollPane sp = new JScrollPane(t);
		//���ÿ��
		t.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		f.add(sp,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
