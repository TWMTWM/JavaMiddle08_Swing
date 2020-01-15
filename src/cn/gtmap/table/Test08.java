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
 * 选中指定行
 * 	1. table初始化后，应该默认选中第一行 
 * 	2. 增加数据后，也应该选中新增的这一条
 */
public class Test08 {
	public static void main(String[] args) {
		final JFrame f = new JFrame("LoL");
		f.setSize(500, 400);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());
		
		final HeroTableModel htm = new HeroTableModel();
		
		final JTable t = new JTable(htm);
		//设置选择模式为 只能选中一行
		t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//选中第一行（基本 0）
		t.getSelectionModel().setSelectionInterval(0, 0);
		
		JPanel p = new JPanel();
		
		final JLabel lName = new JLabel("名称");
		final JTextField tfName = new JTextField("");
		final JLabel lHp = new JLabel("血量");
		final JTextField tfHp = new JTextField("");
		final JLabel lDamage = new JLabel("伤害");
		final JTextField tfDamage = new JTextField("");		
		
		JButton bAdd = new JButton("增加");
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
				//通过name长度判断 名称是否为空
				if(name.length() == 0){
					//弹出对话框提示用户
					JOptionPane.showMessageDialog(f, "名称不能为空");
					
					//名称输入框获取焦点
					tfName.grabFocus();
					return;
				}
				
				String hp = tfHp.getText().trim();
				try {
					// 把hp转换为浮点型，如果出现异常NumberFormatException表示不是浮点型格式
					Float.parseFloat(hp);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(f, "血量只能是小数");
					tfHp.grabFocus();
					return;
				}
				
				String damage = tfDamage.getText().trim();
				try {
					// 把damage转换为整型，如果出现异常NumberFormatException表示不是整型格式
					Integer.parseInt(damage);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(f, "伤害只能是整数");
					tfDamage.grabFocus();
					return;
				}	
				
				h.name = name;
				h.hp = Float.parseFloat(hp);
				h.damage = Integer.parseInt(damage);
				
				dao.add(h);
				
				htm.heros = dao.list();
				
				t.updateUI();
				
				//选中 第一行 ，因为 DAO是按照 ID倒排序查询，所以第一行就是新加入的数据
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
