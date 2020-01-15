package cn.gtmap.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import cn.gtmap.table.table_model.Hero;
import cn.gtmap.table.table_model.HeroDAO;
import cn.gtmap.table.table_model.HeroTableModel;

/**
 * ѡ��ָ����
 * 	1. table��ʼ����Ӧ��Ĭ��ѡ�е�һ�� 
 * 	2. �������ݺ�ҲӦ��ѡ����������һ��
 */
public class Test08 {
	public static void main(String[] args) {
		final JFrame f = new JFrame("LoL");
		f.setSize(500, 400);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());
		
		final HeroTableModel htm = new HeroTableModel();
		
		final JTable t = new JTable(htm);
		//����ѡ��ģʽΪ ֻ��ѡ��һ��
		t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//ѡ�е�һ�У����� 0��
		t.getSelectionModel().setSelectionInterval(0, 0);
		
		JPanel p = new JPanel();
		
		final JLabel lName = new JLabel("����");
		final JTextField tfName = new JTextField("");
		final JLabel lHp = new JLabel("Ѫ��");
		final JTextField tfHp = new JTextField("");
		final JLabel lDamage = new JLabel("�˺�");
		final JTextField tfDamage = new JTextField("");		
		
		JButton bAdd = new JButton("����");
		tfName.setPreferredSize(new Dimension(80, 30));
		tfHp.setPreferredSize(new Dimension(80, 30));
		tfDamage.setPreferredSize(new Dimension(80, 30));
		
		p.add(lName);
		p.add(tfName);
		p.add(lHp);
		p.add(tfHp);
		p.add(lDamage);
		p.add(tfDamage);
		p.add(bAdd);
		
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HeroDAO dao = new HeroDAO();
				Hero h = new Hero();
				
				String name = tfName.getText().trim();
				//ͨ��name�����ж� �����Ƿ�Ϊ��
				if(name.length() == 0){
					//�����Ի�����ʾ�û�
					JOptionPane.showMessageDialog(f, "���Ʋ���Ϊ��");
					
					//����������ȡ����
					tfName.grabFocus();
					return;
				}
				
				String hp = tfHp.getText().trim();
				try {
					// ��hpת��Ϊ�����ͣ���������쳣NumberFormatException��ʾ���Ǹ����͸�ʽ
					Float.parseFloat(hp);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(f, "Ѫ��ֻ����С��");
					tfHp.grabFocus();
					return;
				}
				
				String damage = tfDamage.getText().trim();
				try {
					// ��damageת��Ϊ���ͣ���������쳣NumberFormatException��ʾ�������͸�ʽ
					Integer.parseInt(damage);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(f, "�˺�ֻ��������");
					tfDamage.grabFocus();
					return;
				}	
				
				h.name = name;
				h.hp = Float.parseFloat(hp);
				h.damage = Integer.parseInt(damage);
				
				dao.add(h);
				
				htm.heros = dao.list();
				
				t.updateUI();
				
				//ѡ�� ��һ�� ����Ϊ DAO�ǰ��� ID�������ѯ�����Ե�һ�о����¼��������
				t.getSelectionModel().setSelectionInterval(0, 0);
			}
		});
		
		JScrollPane sp = new JScrollPane(t);
		
		f.add(p,BorderLayout.NORTH);
		f.add(sp,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
	}
}
