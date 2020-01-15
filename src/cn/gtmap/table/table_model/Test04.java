package cn.gtmap.table.table_model;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * TableModel
 * 	����˵��TableModel�����˼�룬��Model����˼���ָ���£����ݺ���ʾ���뿪���ˡ� �������JTable���ԣ������ݲ��֣�Ҳ����ʾ����(�����п����Ϣ)�� ���ݲ��֣�ר����һ���࣬����TableModel�������ڴ��Ҫ��ʾ�����ݡ�
 * 	ʹ��TableModel�ķ�ʽ���Table��Ҫ��ʾ������
 * 	HeroTableModel �̳�AbstractTableModel ������ʵ���˽ӿ�TableModel
 * 	��HeroTableModel ���ṩһ��table��ʾ��Ҫ��������Ϣ
 * 		1. getRowCount ����һ���ж�����
 * 		2. getColumnCount ����һ���ж�����
 * 		3. getColumnName ÿһ�е�����
 * 		4. isCellEditable ��Ԫ���Ƿ�����޸�
 * 		5. getValueAt ÿһ����Ԫ�����ֵ
 * 	��ͼ�ν�����Ҫ��Ⱦ��һ����Ԫ������ݵ�ʱ�򣬾ͻ���÷���TabelModel��getValueAt(0,0) ���ѷ���ֵ�õ�����ʾ
 */
public class Test04 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());
		
		//����һ��TableModel
		HeroTableModel htm = new HeroTableModel();
		
		//����TableModel������Table
		JTable t = new JTable(htm);
		
		JScrollPane sp = new JScrollPane(t);
		
		f.add(sp,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
	}
}
