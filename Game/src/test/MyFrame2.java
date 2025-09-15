package test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame2 extends JFrame {
    //创建一个按钮对象
    JButton button = new JButton("按钮");


    public MyFrame2(){
        //设置标题
        this.setTitle("MyFrame2");
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
        //设置按钮位置和大小
        button.setBounds(100,100,100,50);
        //给按钮绑定鼠标监听器
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("鼠标点击");
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                System.out.println("鼠标按下");

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                System.out.println("鼠标释放");

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                System.out.println("鼠标进入");

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                System.out.println("鼠标退出");

            }
        });

        //把按钮添加到窗体
        this.getContentPane().add(button);



        //设置可见
        this.setVisible(true);
    }
}
