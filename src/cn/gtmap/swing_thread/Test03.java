package cn.gtmap.swing_thread;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 * ����ʱ�����̣߳�
 * ��ʱ����Ҫִ�г���ʱ���񣬱������ݿ��ѯ���ļ����ƣ���������ȵȡ�

����Щ����һ�㶼�����¼���Ӧ���𣬾ͻ��Զ������¼������̡߳� ���¼������߳����ǵ��߳�ģʽ�������ͻ�����ִ����Щ����ʱ�����ʱ�򣬽��������Ӧ�ˡ� 

��ͼ��ʾ���������һ����ť��ʱ�򣬻������н���һ��5���ӵ���������ڼ䣬��һ����ť�ᱣ�ְ���״̬��������ťҲ�޷����������������Ӧ��״̬��

Ϊ�˽��������⣬Swing�ṩ��һ��SwingWorker��������� SwingWorker��һ�������࣬Ϊ��ʹ�ã�����ʵ�ַ��� doInBackground����doInBackground�У��Ϳ��Ա�д���ǵ�����Ȼ��ִ��SwingWorker��execute����������ר�ŵĹ����߳���ȥ���С�
 
SwingWorker worker = new SwingWorker() {
	protected Object doInBackground() throws Exception {
		//����ʱ����
		return null;
	}
};
worker.execute();
 

SwingWorker������ι������أ� 
��SwingWorkerִ��execute��ʱ�򣬵���Ĭ����10���̵߳��̳߳أ�ִ��doInBackground�еĴ��룬ͨ�����´��룬���Ի�ִ֪�е�ǰSwingWorder���߳�����
 
System.out.println("ִ�����SwingWorder���߳��ǣ�" + Thread.currentThread().getName());
 *
 */
public class Test03 {
    public static void main(String[] args) {
    	 
        JFrame f = new JFrame("LoL");
        f.setSize(300, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("���¼������߳���ִ�г���ʱ����");
        JButton b2 = new JButton("ʹ��SwingWorkerִ�г���ʱ����");
        JLabel l = new JLabel("����ִ�н��");
        f.add(b1);
        f.add(b2);
        f.add(l);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        b1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("��ʼִ�����");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                l.setText("����ִ����ϣ�");
            }
        });
        b2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
 
                    @Override
                    protected Void doInBackground() throws Exception {
                        System.out.println("ִ�����SwingWorder���߳��ǣ�" + Thread.currentThread().getName());
                        l.setText("��ʼִ��");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        l.setText("����ִ�����");
                        return null;
                    }
                };
                worker.execute();
 
            }
        });
 
        f.setVisible(true);
    }	
}
