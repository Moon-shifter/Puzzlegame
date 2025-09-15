package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame3 extends JFrame implements KeyListener {

    public MyFrame3() throws HeadlessException {
        //设置标题
        this.setTitle("MyFrame3");
        //设置大小
        this.setSize(400,300);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口置顶
        this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置布局为null
        this.setLayout(null);

        //添加键盘监听器
        //调用者this是窗体对象，表示给该窗体添加键盘监听器
        //第二个this代表当前对象，也就是MyFrame3对象
        //当在窗体上按下键盘时，会触发键盘事件，调用KeyListener接口中的方法
        this.addKeyListener(this);





        //设置窗体可见
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("键盘按下");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("键盘释放");
        //获取按键的编号
        int code= keyEvent.getKeyCode();
        System.out.println(code);

    }
}
