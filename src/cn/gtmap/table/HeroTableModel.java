package cn.gtmap.table;

import javax.swing.table.AbstractTableModel;

public class HeroTableModel extends AbstractTableModel {
	
	//表格上的title
	String[] columnNames = new String[]{"id","name","hp","damage"};
	//表格中的内容是一个二维数组
	String[][] heros = new String[][]{
		{"1", "盖伦", "616", "100"},
		{"2", "提莫", "512", "102"},
		{"3", "奎因", "832", "200"}
	};
	
	//返回一共多少行
	@Override
	public int getRowCount() {
		return heros.length;
	}
	//返回一共多少列
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	//获取每一列的名称
	public String getColumnName(int columnIndex){
		return columnNames[columnIndex];
	}
	//单元格是否可以修改
	public boolean isCellEditable(int rowIndex,int columnIndex){
		return false;
	}
	//每一个单元格里的值
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return heros[rowIndex][columnIndex];
	}

}
