package cn.gtmap.component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * �ı���
 *	JTextArea���ı���
 *	���ı���JTextField��ͬ���ǣ��ı�����������������
 *	���Ҫ���ı����ʼ�ı���ͨ��\n��ʵ�ֻ���Ч��
 *	JTextAreaͨ�����õ�append����������׷��
 *	����ı�̫�������ܳ�ȥ������ͨ��setLineWrap(true) �������Զ�����
 */
public class Test11_JTextArea {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new FlowLayout());
		JLabel l = new JLabel("�ı���");
		
		JTextArea ta = new JTextArea();
		ta.setPreferredSize(new Dimension(200, 150));
		
		//\n���з�
		ta.setText("����ͷ��\n�����ð�����\n");
		//׷������
		ta.append("��ȥ��������������������������������������������������");
		//�����Զ�����
		ta.setLineWrap(true);
		f.add(l);
		f.add(ta);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
			
	}
}
