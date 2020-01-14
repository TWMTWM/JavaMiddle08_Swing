package cn.gtmap.component;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 * �ļ�ѡ����
 *	JFileChooser ��ʾ�ļ�ѡ����
 *	ʹ��FileFilter���ڽ�ѡ��.txt�ļ�
 *fc.setFileFilter(new FileFilter() {
 *	public String getDescription() {
 *		return ".txt";
 *	}
 *	public boolean accept(File f) {
 *		return f.getName().toLowerCase().endsWith(".txt");
 *	}
 *});
 *	fc.showOpenDialog(); ���ڴ��ļ�
 *	fc.showSaveDialog(); ���ڱ����ļ�
 */
public class Test13_JFileChooser {
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
		f.setLayout(new FlowLayout());
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return ".txt";
			}
			
			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".txt");
			}
		});
		
		JButton bOpen = new JButton("���ļ�");
		JButton bSave = new JButton("�����ļ�");
		
		f.add(bOpen);
		f.add(bSave);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(250,150);
		f.setLocationRelativeTo(null);
		
		f.setVisible(true);
		
		bOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(f);
				File file = fc.getSelectedFile();
				if(returnVal == JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(f, "�ƻ����ļ���" + file.getAbsolutePath());
				}
			}
		});
		
		bSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal =fc.showSaveDialog(f);
				File file = fc.getSelectedFile();
				if(returnVal == JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(f, "�ƻ����浽�ļ���" + file.getAbsolutePath());
				}
			}
		});
	}
}
