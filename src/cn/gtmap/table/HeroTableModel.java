package cn.gtmap.table;

import javax.swing.table.AbstractTableModel;

public class HeroTableModel extends AbstractTableModel {
	
	//����ϵ�title
	String[] columnNames = new String[]{"id","name","hp","damage"};
	//����е�������һ����ά����
	String[][] heros = new String[][]{
		{"1", "����", "616", "100"},
		{"2", "��Ī", "512", "102"},
		{"3", "����", "832", "200"}
	};
	
	//����һ��������
	@Override
	public int getRowCount() {
		return heros.length;
	}
	//����һ��������
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	//��ȡÿһ�е�����
	public String getColumnName(int columnIndex){
		return columnNames[columnIndex];
	}
	//��Ԫ���Ƿ�����޸�
	public boolean isCellEditable(int rowIndex,int columnIndex){
		return false;
	}
	//ÿһ����Ԫ�����ֵ
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return heros[rowIndex][columnIndex];
	}

}
