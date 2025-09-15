package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    //创建一个按钮对象
    private JButton jtb=new JButton("按钮");
    //创建一个按钮对象
    private JButton jtb2=new JButton("按钮2");

    public MyFrame() {
        //创建一个窗体对象
        JFrame jf=new JFrame("测试窗体");
        //设置窗体大小
        jf.setSize(400,300);
        //设置窗体位置
        jf.setLocation(200,200);
        //设置窗体关闭模式
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体时退出程序
        //设置窗体布局为null
        jf.setLayout(null);



        //设置位置和宽高
        jtb.setBounds(0,0,100,50);
        //添加动作监听
        //jtb:组件对象，MyActionListener:动作监听器对象(包含鼠标左键点击，空格键点击)
        //参数是一个实现了ActionListener接口的对象，表示当按钮被点击时要执行的动作
        jtb.addActionListener(this);


        //设置位置和宽高
        jtb2.setBounds(100,100,100,50);
        //添加动作监听
        jtb2.addActionListener(this);




        //把按钮添加到窗体
        jf.getContentPane().add(jtb);
        jf.getContentPane().add(jtb2);


        //设置窗体可见
        jf.setVisible(true);

    }
//重写actionPerformed方法,当按钮被点击时会调用该方法
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //对当前的按钮进行判断

        //获取触发事件的组件对象
       Object source= actionEvent.getSource();

       if(source==jtb2){
           System.out.println("按钮2被点击了");
       }else if(source==jtb){
           System.out.println("按钮1被点击了");
       }else {
              System.out.println("未知按钮被点击了");
       }

    }
}
