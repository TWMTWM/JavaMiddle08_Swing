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

import cn.gtmap.table.table_model.Hero;
import cn.gtmap.table.table_model.HeroDAO;
import cn.gtmap.table.table_model.HeroTableModel;

/**
 * 输入项验证
 *	如果用户输入的名称为空，或者血量不是小数，在提交数据的时候都会报错。 
 *	“感觉上” 界面就卡住了。 这是不友好的人机交互行为。 
 *	所以需要加上输入项的验证，如果输入的数据不合格，应该弹出对话框提示用户具体原因。
 */
public class Test07 {
	public static void main(String[] args) {
		final JFrame f = new JFrame("LoL");
		f.setSize(500, 400);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());
		
		final HeroTableModel htm = new HeroTableModel();
		
		final JTable t = new JTable(htm);
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
				
			}
		});
		
		JScrollPane sp = new JScrollPane(t);
		
		f.add(p,BorderLayout.NORTH);
		f.add(sp,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
