package cn.gtmap.table.table_model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class HeroTableModel extends AbstractTableModel {
	
	String[] columnNames = new String[] {"id","name","hp","damage"};
	
	//使用从DAO返回的List作为TableModel的数据
	public List<Hero> heros = new HeroDAO().list();
	
	//hero.size返回一共多少行
	@Override
	public int getRowCount() {
		return heros.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public String getColumnName(int columnIndex){
		return columnNames[columnIndex];
	}
	
	public boolean isCellEditable(int rowIndex,int columnIndex){
		return false;
	}
	
    // 先通过heros.get(rowIndex)获取行对应的Hero对象
    // 然后根据columnIndex返回对应的属性
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Hero h = heros.get(rowIndex);
		if(0 == columnIndex)
			return h.id;
		if(1 == columnIndex)
			return h.name;
		if(2 == columnIndex)
			return h.hp;
		if(3 == columnIndex)
			return h.damage;
		return null;
	}

}
