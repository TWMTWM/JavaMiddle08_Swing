package cn.gtmap.date;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.eltima.components.ui.DatePicker;

/**
 * ��ϰ-ͳ���ļ�����
 *	����ʱ��ؼ���ѡ��һ��ʱ�䣬Ȼ��������ʱ�䣬
 *	ͳ��e:\project �޸�ʱ��������ʱ����ļ���һ���ж���
 */
public class Test03 {
    public static void main(String[] args) {
    	   
        JFrame f = new JFrame("LoL");
        f.setSize(500, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
   
        final DatePicker datepick;
        datepick = getDatePicker();
   
        f.add(datepick);
   
        JButton b = new JButton("ͳ����e:/project Ŀ¼�£��޸�ʱ����ڿؼ����ڵ��ļ�����");
        b.setBounds(20, 183, 450, 30);
        f.add(b);
   
        b.addActionListener(new ActionListener() {
   
            @Override
            public void actionPerformed(ActionEvent e) {
                File folder = new File("e:\\project");
                Date d = (Date) datepick.getValue();
                JOptionPane.showMessageDialog(f, "�ļ������ǣ�" + countFilesModifiedDateGreaterThan(folder, d));
            }
        });
   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        f.setVisible(true);
    }
 
    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // ��ʽ
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // ��ǰʱ��
        Date date = new Date();
        // ����
        Font font = new Font("Times New Roman", Font.BOLD, 14);
   
        Dimension dimension = new Dimension(177, 24);
   
        int[] hilightDays = { 1, 3, 5, 7 };
   
        int[] disabledDays = { 4, 6, 5, 9 };
   
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
   
        // datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        // ����һ���·�����Ҫ������ʾ������
        datepick.setHightlightdays(hilightDays, Color.red);
        // ����һ���·��в���Ҫ�����ӣ��ʻ�ɫ��ʾ
        datepick.setDisableddays(disabledDays);
        // ���ù���
        datepick.setLocale(Locale.CHINA);
        // ����ʱ�����ɼ�
        datepick.setTimePanleVisible(true);
        return datepick;
    }
      
    public static List<File> scanFolder(File folder){
        List<File> files = new ArrayList<>();
        File[] fs = folder.listFiles();
        for (File f : fs) {
            if(f.isDirectory()){
                 List<File> subFolderFiles = scanFolder(f);
                 files.addAll(subFolderFiles);
            }
            if(f.isFile()){
                files.add(f);
            }
        }
        return files;
    }
      
    public static long countFilesModifiedDateGreaterThan(File folder,Date d){
        List<File> fs = scanFolder(folder);
        return fs.stream()
                .filter(f->f.lastModified()>d.getTime())
                .count();
    }
      	
}
