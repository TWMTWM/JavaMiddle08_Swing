package cn.gtmap.panel;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * ����eclipse�ķ����ʾ���java�ļ�
 * �ο�eclipse�ķ�񣬽���TabbedPanel��ʾһ���������е�java�ļ�
 * ����� jdbc ��������java�ļ�
 * 	ConnectionPool.java
 * 	DAO.java
 * 	HeroDAO.java
 * 	TestConnectionPool.java
 * 	TestDAO.java
 * 	TestJDBC.java
 * 	����׼��һ��JavaFilePane ר��������ʾ�ļ����ݵ�Panel
 * 	Ȼ����TestGUI�б���e:/project/j2se/jdbc �µ��ļ�����������Щ�ļ�����JavaFilePane ��
 * 	���Ű���ЩJavaFilePane ���뵽TabbedPanel�м���
 *
 */
public class TestGUI {
    public static void main(String[] args) {
    	   
        JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
   
        f.setLayout(null);
         
        File folder = new File("e:/project/JavaMiddle08_Swing/src/cn/gtmap/panel");
        File[] fs=folder.listFiles();
        JTabbedPane tp = new JTabbedPane();
        ImageIcon icon = new ImageIcon("e:/project/JavaMiddle08_Swing/image/j.png");
        for (int i = 0; i < fs.length; i++) {
            JavaFilePane jfp =new JavaFilePane(fs[i]);
            tp.add(jfp);
            tp.setIconAt(i,icon );
            tp.setTitleAt(i, shortName(fs[i].getName()));
        }
 
        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
 
    private static String shortName(String name) {
        int length = 6;
        if(name.length()>length){
            return name.substring(0,length) + "...";
        }
        return name;
         
    }	
}
