package cn.gtmap.table.exercise;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
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
 * 练习-修改
 * 接着练习-编辑继续完整修改的功能。 
 * 	点击修改，首选判断数据是否正确，是否为空，是否为数字等。 
 * 	通过校验后，把数据保存到数据库，然后刷新table中的数据，并且选中第一条。
 *
 */
public class Test04_Update {
    // 把 htm和 table设计为静态，后面在更新表格数据的时候，就很容易访问这个两个对象
    static HeroTableModel htm = new HeroTableModel();
    static JTable t = new JTable(htm);
 
    public static void main(String[] args) {
 
        final JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        t.getSelectionModel().setSelectionInterval(0, 0);
 
        JPanel pOperation = new JPanel();
 
        JButton bAdd = new JButton("增加");
        JButton bDelete = new JButton("删除");
        JButton bEdit = new JButton("编辑");
        pOperation.add(bAdd);
        pOperation.add(bDelete);
        pOperation.add(bEdit);
 
        bEdit.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                // 判断是否选中
                int index = t.getSelectedRow();
                if (-1 == index) {
                    JOptionPane.showMessageDialog(f, "编辑前需要先选中一行");
                    return;
                }
 
                // 获取选中的对象
                Hero hero = htm.heros.get(index);
 
                // 显示编辑Dialog
 
                EditDialog ed = new EditDialog(f);
                ed.tfName.setText(hero.name);
                ed.tfHp.setText(String.valueOf((int) hero.hp));
 
                ed.setVisible(true);
 
            }
        });
 
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);
            }
        });
        bDelete.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
 
                // 判断是否选中
                int index = t.getSelectedRow();
                if (-1 == index) {
                    JOptionPane.showMessageDialog(f, "删除前需要先选中一行");
                    return;
                }
 
                // 进行确认是否要删除
                if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f, "确认要删除？"))
                    return;
 
                // 获取id
                Hero hero = htm.heros.get(index);
                int id = hero.id;
 
                // 删除
                new HeroDAO().delete(id);
 
                // 更新table
                updateTable();
 
            }
        });
 
        JScrollPane sp = new JScrollPane(t);
 
        f.add(sp, BorderLayout.CENTER);
        f.add(pOperation, BorderLayout.SOUTH);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
 
    static class AddDialog extends JDialog {
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
 
        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();
 
        JButton bSubmit = new JButton("提交");
 
        AddDialog(JFrame f) {
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);
 
            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();
 
            pInput.setLayout(new GridLayout(2, 2, gap, gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);
 
            pSubmit.add(bSubmit);
 
            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);
 
            this.add(pInput);
            this.add(pSubmit);
 
            this.setSize(300, 200);
            this.setLocationRelativeTo(f);
            bSubmit.addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
 
                    if (checkEmpty(tfName, "名称")) {
                        if (checkNumber(tfHp, "hp")) {
 
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
 
                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;
 
                            new HeroDAO().add(h);
 
                            JOptionPane.showMessageDialog(f, "提交成功 ");
 
                            AddDialog.this.setVisible(false);
                            updateTable();
                        }
                    }
 
                }
            });
 
        }
    }
 
    public static void updateTable() {
        htm.heros = new HeroDAO().list();
        t.updateUI();
        if (!htm.heros.isEmpty())
            t.getSelectionModel().setSelectionInterval(0, 0);
    }
 
    private static boolean checkEmpty(JTextField tf, String msg) {
        String value = tf.getText();
        if (0 == value.length()) {
            JOptionPane.showMessageDialog(null, msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }
 
    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if (0 == value.length()) {
            JOptionPane.showMessageDialog(null, msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, msg + " 只能是整数");
            tf.grabFocus();
            return false;
        }
 
        return true;
    }
 
    static class EditDialog extends JDialog {
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
 
        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();
 
        JButton bSubmit = new JButton("提交");
 
        EditDialog(JFrame f) {
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);
 
            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();
 
            pInput.setLayout(new GridLayout(2, 2, gap, gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);
 
            pSubmit.add(bSubmit);
 
            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);
 
            this.add(pInput);
            this.add(pSubmit);
 
            this.setSize(300, 200);
            this.setLocationRelativeTo(f);
             
            bSubmit.addActionListener(new ActionListener() {
                 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkEmpty(tfName, "名称")) {
                        if (checkNumber(tfHp, "hp")) {
                             
                            //获取id
                            int index = t.getSelectedRow();
                            int id = htm.heros.get(index).id;
                             
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
 
                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;
                            h.id= id;
                             
                            new HeroDAO().update(h);
 
                            JOptionPane.showMessageDialog(f, "提交成功 ");
 
                            EditDialog.this.setVisible(false);
                            updateTable();
                        }
                    }
                     
                }
            });
        }
    }	
}
