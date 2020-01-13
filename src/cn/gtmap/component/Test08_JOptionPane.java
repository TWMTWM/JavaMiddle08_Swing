package cn.gtmap.component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * �Ի���
 *	JOptionPane ���ڵ����Ի���
 *	JOptionPane.showConfirmDialog(f, "�Ƿ� ʹ����� ��");
 *	��ʾѯ�ʣ���һ�������ǸöԻ������ĸ��������
 *	JOptionPane.showInputDialog(f, "������yes������ʹ����Һ���Ը�");
 *	�����û�������
 *	JOptionPane.showMessageDialog(f, "��ʹ����ұ�ץס�� �������3�Σ�");
 *	��ʾ��Ϣ
 */
public class Test08_JOptionPane {
	public static void main(String[] args) {
		
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLayout(null);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
		int option = JOptionPane.showConfirmDialog(f, "�Ƿ�ʹ�����");
		if(JOptionPane.OK_OPTION == option){
			String answer = JOptionPane.showInputDialog(f,"������yes������ʹ����Һ���Ը�");
			if("yes".equals(answer))
				JOptionPane.showMessageDialog(f, "��ʹ����ұ�ץס�� �������3�Σ�");
		}else if(JOptionPane.NO_OPTION == option){
			JOptionPane.showMessageDialog(f, "��������Ҷ�����ʹ��");
		}else{
			JOptionPane.showMessageDialog(f, "�ú��ӣ���Ȼ����ס���ջ�");
		}
		
	}
}
