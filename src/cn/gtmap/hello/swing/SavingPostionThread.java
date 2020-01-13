package cn.gtmap.hello.swing;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * 	SavingPostionThread 用于每隔100毫秒记录当前的位置信息到location.txt中，
 * 	记录数据的时候用到了数据输出流可以方便的保存多个整数
 *
 */
public class SavingPostionThread extends Thread{
    private JFrame f;
    File file = new File("E:/project/JavaMiddle08_Swing/location.txt");
 
    SavingPostionThread(JFrame f) {
        this.f = f;
    }
 
    public void run() {
        while (true) {
            int x = f.getX();
            int y = f.getY();
 
            try (FileOutputStream fos = new FileOutputStream(file);
                    DataOutputStream dos = new DataOutputStream(fos);) {
                dos.writeInt(x);
                dos.writeInt(y);
            } catch (Exception e) {
                e.printStackTrace();
            }
 
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
 
        }
    }
	
	
	
}
