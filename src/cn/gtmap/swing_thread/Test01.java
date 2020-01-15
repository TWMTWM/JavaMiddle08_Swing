package cn.gtmap.swing_thread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 * ��ʼ���߳�
 * �������ʾ��ͬʱ�����ڳ�ʼ��һ��ͼ�ν����ʱ�򣬶���ֱ���������������߳��ֱ�ӵ������´��������г�ʼ��
 * new TestFrame().setVisible(true);
 * �����С������û��ʲô���⣬����Ǹ��ӵĳ�����п��ܲ��������ˡ���Ϊ�����������߳���ͬʱ���������1. ���߳� 2. �¼������̡߳� ����Ǹ��ӵ�ͼ�ν�����򣬾��п��ܳ����������߳�ͬʱ���������������ͬ������Ĳ�����
 * Ϊ�˹���������Ĳ�������������ʾ����Ĺ��������Ҳ�����¼������̣߳������ͱ�֤��ֻ��һ���߳��ڷ�����Щ���
 * SwingUtilities.invokeLater(new Runnable() {
 * 	public void run() {
 * 		new TestFrame().setVisible(true);
 * 		}
 * 	});
 * ��������new TestFrame().setVisible(true); ��δ���������¼������߳���ִ���ˡ�
 * ������ʹ��SwingUtilities.isEventDispatchThread()���жϵ�ǰ�߳��Ƿ����¼������߳�
 *
 */
public class Test01 {
	public static void main(String[] args) {
		
		//new TestFrame().setVisible(true);
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TestFrame().setVisible(true);
			}
		});
		
	}
	
	static class TestFrame extends JFrame{
		public TestFrame(){
			setTitle("LoL");
			setSize(400, 300);
			setLocation(200, 200);
			setLayout(null);
			
			JButton b = new JButton("һ����Է����ع�");
			b.setBounds(50, 50, 280, 30);
			
			add(b);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			System.out.println("��ǰ�߳��Ƿ��� �¼������߳�: " + SwingUtilities.isEventDispatchThread());
		}
	}
}
