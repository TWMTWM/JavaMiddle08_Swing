package cn.gtmap.table.table_model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class HeroTableModel extends AbstractTableModel {
	
	String[] columnNames = new String[] {"id","name","hp","damage"};
	
	//ʹ�ô�DAO���ص�List��ΪTableModel������
	public List<Hero> heros = new HeroDAO().list();
	
	//hero.size����һ��������
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
	
    // ��ͨ��heros.get(rowIndex)��ȡ�ж�Ӧ��Hero����
    // Ȼ�����columnIndex���ض�Ӧ������
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
