package cn.gtmap.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.gtmap.table.table_model.Hero;
import cn.gtmap.table.table_model.HeroDAO;
import cn.gtmap.table.table_model.HeroTableModel;

/**
 * ����table
 * t.updateUI();
 */
public class Test06 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(500, 400);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());
		
		final HeroTableModel htm = new HeroTableModel();
		
		final JTable t = new JTable(htm);
		//���� һ�� panel���ڷ������ƣ�Ѫ������������ ��ť
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
		
		//Ϊ��ť��Ӽ���
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HeroDAO dao = new HeroDAO();
				//������������ݴ���һ��Hero����
				Hero h = new Hero();
				h.name = tfName.getText();
				h.hp = Integer.parseInt(tfHp.getText());
				h.damage = Integer.parseInt(tfDamage.getText());
				
				//ͨ��dao�Ѹö�����뵽���ݿ�
				dao.add(h);
				
				//ͨ��dao����tablemodel�е�����
				htm.heros = dao.list();
                // ����JTable��updateUI��ˢ�½��档
                // ˢ�½����ʱ�򣬻ᵽtablemodel��ȥȡ���µ�����
                // ���ܿ����¼ӽ�ȥ��������
				
				t.updateUI();
			}
		});
		
		JScrollPane sp = new JScrollPane(t);
		
		f.add(p,BorderLayout.NORTH);
		f.add(sp,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
