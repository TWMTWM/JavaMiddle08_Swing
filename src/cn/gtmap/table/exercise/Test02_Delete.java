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
 * ɾ��
 * 	�ṩһ��ɾ����ť�����ɾ����ť֮��ɾ��ѡ�е��У�����ˢ��table�е����ݣ�Ȼ����Ĭ��ѡ�е�һ�С�
 * 	������ɾ����ʱ��û���κ��б�ѡ�У�����ʾ��ɾ��ǰӦ��ѡ��һ�С�
 */
public class Test02_Delete {
    //�� htm�� table���Ϊ��̬�������ڸ��±�����ݵ�ʱ�򣬾ͺ����׷��������������
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
 
        JButton bAdd = new JButton("����");
        JButton bDelete = new JButton("ɾ��");
        pOperation.add(bAdd);
        pOperation.add(bDelete);
 
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);
            }
        });
        bDelete.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
 
                //�ж��Ƿ�ѡ��
                int index = t.getSelectedRow();
                if(-1==index){
                    JOptionPane.showMessageDialog(f, "ɾ��ǰ��Ҫ��ѡ��һ��");
                    return;
                }
                 
                //����ȷ���Ƿ�Ҫɾ��
                if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f, "ȷ��Ҫɾ����"))
                    return;
                 
                //��ȡid
                Hero hero = htm.heros.get(index);
                int id =hero.id;
                 
                //ɾ��
                new HeroDAO().delete(id);
                 
                //����table
                updateTable();
                 
            }
        });
 
        JScrollPane sp = new JScrollPane(t);
 
        f.add(sp, BorderLayout.CENTER);
        f.add(pOperation, BorderLayout.SOUTH);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
     
    static class AddDialog extends JDialog{
        JLabel lName = new JLabel("����");
        JLabel lHp = new JLabel("Ѫ��");
         
        JTextField tfName =new JTextField();
        JTextField tfHp =new JTextField();
         
        JButton bSubmit =new JButton("�ύ");
         
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
                     
                    if(checkEmpty(tfName, "����")){
                        if(checkNumber(tfHp, "hp")){
                         
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
                             
                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;
                             
                            new HeroDAO().add(h);
                             
                            JOptionPane.showMessageDialog(f, "�ύ�ɹ� ");
                             
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
            JOptionPane.showMessageDialog(null,msg + " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,msg + " ֻ��������");
            tf.grabFocus();
            return false;
        }
         
        return true;
    }	
}
