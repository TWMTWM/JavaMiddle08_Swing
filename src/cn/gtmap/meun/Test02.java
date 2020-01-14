package cn.gtmap.meun;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 菜单项
 *
 */
public class Test02 {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setSize(400,400);
		f.setLocation(200, 200);
		
		JMenuBar mb = new JMenuBar();
		
		JMenu mHero = new JMenu("英雄");
		JMenu mItem = new JMenu("道具");
		JMenu mWord = new JMenu("符文");
		JMenu mSummon = new JMenu("召唤师");
		JMenu mTalent = new JMenu("天赋树");
		
		//菜单项
		mHero.add(new JMenuItem("上单"));
		mHero.add(new JMenuItem("中单"));
		mHero.add(new JMenuItem("打野"));
		mHero.add(new JMenuItem("辅助"));
		mHero.add(new JMenuItem("ADC"));
		
		//分隔符
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
