package cn.gtmap.meun;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * �˵���
 *
 */
public class Test02 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,400);
		f.setLocation(200, 200);
		
		JMenuBar mb = new JMenuBar();
		
		JMenu mHero = new JMenu("Ӣ��");
		JMenu mItem = new JMenu("����");
		JMenu mWord = new JMenu("����");
		JMenu mSummon = new JMenu("�ٻ�ʦ");
		JMenu mTalent = new JMenu("�츳��");
		
		//�˵���
		mHero.add(new JMenuItem("�ϵ�"));
		mHero.add(new JMenuItem("�е�"));
		mHero.add(new JMenuItem("��Ұ"));
		mHero.add(new JMenuItem("����"));
		mHero.add(new JMenuItem("ADC"));
		
		//�ָ���
		mHero.addSeparator();
		mHero.add(new JMenuItem("EZ"));
		mHero.add(new JMenuItem("Annie"));
		mHero.add(new JMenuItem("BH"));
		
		mb.add(mHero);
		mb.add(mItem);
		mb.add(mWord);
		mb.add(mSummon);
		mb.add(mTalent);
		
		f.setJMenuBar(mb);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
	}
}
