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
 * 增加
 *	1. 首先把 htm和 table设计为静态，后面在更新表格数据的时候，就很容易访问这个两个对象
 *	2. 设计一个静态内部类 AddDialog用于显示增加的界面
 *	3. 在AddDialog中点击提交按钮后，进行为空和数字判断，然后通过dao提交到数据库
 *	4. 隐藏这个AddDialog，并刷新table中的数据
 */
public class Test01_Add {
    //把 htm和 table设计为静态，后面在更新表格数据的时候，就很容易访问这个两个对象
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
        pOperation.add(bAdd);
 
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);
            }
        });
 
        JScrollPane sp = new JScrollPane(t);
 
        f.add(sp, BorderLayout.CENTER);
        f.add(pOperation, BorderLayout.SOUTH);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
     
    static class AddDialog extends JDialog{
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
         
        JTextField tfName =new JTextField();
        JTextField tfHp =new JTextField();
         
        JButton bSubmit =new JButton("提交");
         
        AddDialog(JFrame f){
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);
             
            JPanel pInput= new JPanel();
            JPanel pSubmit= new JPanel();
             
            pInput.setLayout(new GridLayout(2, 2,gap,gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);
             
            pSubmit.add(bSubmit);
             
            pInput.setBounds(50,20,200,100);
            pSubmit.setBounds(0,130,300,150);
             
            this.add(pInput);
            this.add(pSubmit);
 
            this.setSize(300, 200);
            this.setLocationRelativeTo(f);
            bSubmit.addActionListener(new ActionListener(){
 
                @Override
                public void actionPerformed(ActionEvent e) {
                     
                    if(checkEmpty(tfName, "名称")){
                        if(checkNumber(tfHp, "hp")){
                         
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
     
    public static void updateTable(){
        htm.heros = new HeroDAO().list();
        t.updateUI();
        if(!htm.heros.isEmpty())
            t.getSelectionModel().setSelectionInterval(0, 0);
    }
     
    private static boolean checkEmpty(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,msg + " 只能是整数");
            tf.grabFocus();
            return false;
        }
         
        return true;
    }
}
