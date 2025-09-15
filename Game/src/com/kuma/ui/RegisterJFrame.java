package com.kuma.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {

    public RegisterJFrame(){
        this.setSize(488,430);
        this.setTitle("注册界面");//设置窗口标题
        this.setAlwaysOnTop(true);//设置窗口置顶（总在最前端）
        this.setVisible(true);
        this.setResizable(false);//设置窗口大小不可变
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//设置窗口居中显示
        //创建一个注册界面
    }


}
