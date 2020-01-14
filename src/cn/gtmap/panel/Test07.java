package cn.gtmap.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * ��ϰ-SplitPanel
 * ���һ����SplitPanel�����ҷ���SplitPanel
 * 	��߷�3����ť����������ֱַ���: ���ף���Ī������
 * 	�ұ�Ĭ����ʾ����
 * 	����߰�ť�����ʱ���ұ߾ͻ���ʾ��Ӧ��ͼƬ
 * 	��Ҫ��ͷ����������� ����pics.rar
 *
 */
public class Test07 {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(400,300);
		f.setLocation(200, 200);
		f.setLayout(null);
		
		JPanel pLeft = new JPanel();
		pLeft.setBounds(50, 50, 300, 60);
		pLeft.setBackground(Color.LIGHT_GRAY);
		pLeft.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("����");
		JButton b2 = new JButton("��Ī");
		JButton b3 = new JButton("����");
		
		pLeft.add(b1);
		pLeft.add(b2);
		pLeft.add(b3);
		
		JPanel pRight = new JPanel();
		JLabel lPic = new JLabel("");
		
		ImageIcon i = new ImageIcon("e:/project/JavaMiddle08_Swing/image/gareen.jpg");
		lPic.setIcon(i);
		
		pRight.add(lPic);
		
		pRight.setBackground(Color.LIGHT_GRAY);
		pRight.setBounds(10, 150, 300, 60);
		
		// ����һ��ˮƽJSplitPane�������p1,�ұ���p2
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pLeft,pRight);
		
		//���÷ָ�����λ��
		sp.setDividerLocation(80);
		
		//��sp����ContentPane
		f.setContentPane(sp);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
		
		switchPic(b1, "gareen", lPic);
		switchPic(b2, "teemo", lPic);
		switchPic(b3, "annie", lPic);
	}
	
	private static void switchPic(JButton b1,String fileName,JLabel lPic){
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon i = new ImageIcon("e:/project/JavaMiddle08_Swing/image/" + fileName + ".jpg");
				lPic.setIcon(i);
			}
		});
	}
	
}
