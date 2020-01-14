package cn.gtmap.meun;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ��ϰ���һ�������ļ��±�����
 *
 */
public class Test03 {

    public static void main(String[] args) {
    	  
        JFrame f = new JFrame("���±�");
        f.setSize(400, 400);
        f.setLocation(200, 200);
  
        JMenuBar mb = new JMenuBar();
  
        JMenu document = new JMenu("�ļ�(A)");
        JMenu editor = new JMenu("�༭(E)");
        JMenu layout = new JMenu("��ʽ(O)");
        JMenu viewing = new JMenu("�鿴(V)");
        JMenu help = new JMenu("����(H)");
  
        // �ļ���
        document.add(new JMenuItem("�½�(N)                         Ctrl+N"));
        document.add(new JMenuItem("��(O)                         Ctrl+O"));
        document.add(new JMenuItem("����(S)                         Ctrl+S"));
        document.add(new JMenuItem("���Ϊ(N)"));
        document.addSeparator();
        document.add(new JMenuItem("ҳ������(U)"));
        document.add(new JMenuItem("��ӡ(P)                         Ctrl+P"));
        document.addSeparator();
        document.add(new JMenuItem("�˳�(X)"));
        // �༭��
        editor.add(new JMenuItem("����(U)                         Ctrl+Z"));
        editor.addSeparator();
        editor.add(new JMenuItem("����(T)                         Ctrl+X"));
        editor.add(new JMenuItem("����(C)                         Ctrl+C"));
        editor.add(new JMenuItem("ճ��(P)                         Ctrl+V"));
        editor.add(new JMenuItem("ɾ��(L)                             Del"));
        editor.addSeparator();
        editor.add(new JMenuItem("����(F)                         Ctrl+F"));
        editor.add(new JMenuItem("������һ��(N)                    F3"));
        editor.add(new JMenuItem("�滻(R)                         Ctrl+H"));
        editor.add(new JMenuItem("ת��(G)                         Ctrl+G"));
        editor.addSeparator();
        editor.add(new JMenuItem("ȫѡ(A)                         Ctrl+A"));
        editor.add(new JMenuItem("ʱ��/����(D)                       F5"));
        //��ʽ
        layout.add(new JMenuItem("�Զ�����(W)            "));
        layout.add(new JMenuItem("����(F)"));
        //�鿴
        viewing.add(new JMenuItem("״̬��(S)"));
        //����
        help.add(new JMenuItem("�鿴����(H)"));
        help.add(new JMenuItem("���ڼ��±�(A)"));
         
        mb.add(document);
        mb.add(editor);
        mb.add(layout);
        mb.add(viewing);
        mb.add(help);
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta);
  
        f.setContentPane(sp);
        f.setJMenuBar(mb);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }

}
