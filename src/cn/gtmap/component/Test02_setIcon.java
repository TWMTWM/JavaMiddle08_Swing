package cn.gtmap.component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ʹ��JLabel��ʾͼƬ
 *	java GUI ��ʾͼƬ��ͨ����label������ͼ��ʵ�ֵ�
 *	ע�� �����ͼƬ·����e:/project/j2se/shana.png������Ҫȷ��������ͼƬ����Ȼ������ʾ
 *	ע�� ͼƬ�ĺ�׺������ʵ��ʽ�����뱣��һ�£�������п����޷�������ʾ�� 
 *	ʲô��˼�أ������ļ�������jpg�ģ����ǽ����ǰѺ�׺���޸ĳ���png,��ô�ᵼ����ʾʧ�ܡ�
 */
public class Test02_setIcon {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,300);
		f.setLocation(580, 200);
		f.setLayout(null);
		
		JLabel l = new JLabel();
		//����ͼƬ����ImageIcon����
		ImageIcon i = new ImageIcon("E:/project/JavaMiddle08_Swing/image/shana.png");
		//����ImageIcon
		l.setIcon(i);
		//label�Ĵ�С����ΪImageIcon,������ʾ������
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
