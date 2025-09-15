package com.kuma.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class LoginJFrame extends JFrame implements MouseListener {
    String rightCode=verifyCode();
    //集合存储用户数据
    static ArrayList<User> list=new ArrayList<>();
    static{
        list.add(new User("123456","admin"));
        list.add(new User("123456","user"));
    }
    //添加登录按钮
    JButton login = new JButton();
    //添加注册按钮
    JButton register = new JButton();
    //添加显示密码的小眼睛图标
    JButton showPassword = new JButton();
    //添加隐藏的更换验证码按钮
    JButton changeCode = new JButton();
    //添加密码输入框
    JPasswordField passwordInput=new JPasswordField();
    //添加用户名输入框
    JTextField usernameInput=new JTextField();
    //添加验证码输入框
    JTextField identityCodeInput=new JTextField();
    //添加验证码Label
    JLabel code=new JLabel(rightCode);

    //构造方法
    public LoginJFrame(){
        //初始化界面
        initJFrame();

        //初始化组件与背景
        initView();


        //界面显示写在最后
        this.setVisible(true);//设置界面可见
    }


    //初始化界面组件
   public void initView() {

        this.getContentPane().removeAll();//移除所有组件

        //添加图片

        //1.添加用户名图片
        JLabel username = new JLabel(new ImageIcon(".idea//素材//image//login//用户名.png"));
        username.setBounds(115,135,47,17);
        this.getContentPane().add(username);

        //用户名输入框设置参数
        usernameInput.setBounds(190,130,200,30);
        this.getContentPane().add(usernameInput);

        //2.添加密码图片
        JLabel password = new JLabel(new ImageIcon(".idea//素材//image//login//密码.png"));
        password.setBounds(115,195,32,16);
        this.getContentPane().add(password);

        //密码输入框设置参数
        //默认回显字符为*
        passwordInput.setEchoChar('*');
        passwordInput.setBounds(190,190,200,30);
        this.getContentPane().add(passwordInput);


        //3.添加验证码图片
        JLabel identityCode = new JLabel(new ImageIcon(".idea//素材//image//login//验证码.png"));
        identityCode.setBounds(115,255,56,21);
        this.getContentPane().add(identityCode);
        //验证码输入框设置参数
        identityCodeInput.setBounds(190,250,100,30);
        this.getContentPane().add(identityCodeInput);


        //4.设置登录按钮参数
        login.setIcon(new ImageIcon(".idea//素材//image//login//登录按钮.png"));
        login.setBounds(123,310,128,47);
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);
        //给登录按钮添加鼠标点击事件
        login.addMouseListener(this);


        //5.设置注册按钮参数
        register.setIcon(new ImageIcon(".idea//素材//image//login//注册按钮.png"));
        register.setBounds(263,310,128,47);
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);
        //给注册按钮添加鼠标点击事件
        register.addMouseListener(this);


        //6.设置显示密码按钮参数
        showPassword.setIcon(new ImageIcon(".idea//素材//image//login//显示密码.png"));
        showPassword.setBounds(395,190,30,30);
        //去除按钮的边框
        showPassword.setBorderPainted(false);
        //去除按钮的背景
        showPassword.setContentAreaFilled(false);
        this.getContentPane().add(showPassword);
        //给显示密码按钮添加鼠标点击事件
        showPassword.addMouseListener(this);


       //7.设置验证码Label参数
        code.setBounds(300,250,50,30);
        this.getContentPane().add(code);


        //8.设置更换验证码按钮参数
        changeCode.setIcon(new ImageIcon(".idea//素材//image//login//更换验证码.png"));
        changeCode.setBounds(300,250,50,30);
        //去除按钮的边框
        changeCode.setBorderPainted(false);
        //去除按钮的背景
        changeCode.setContentAreaFilled(false);
        this.getContentPane().add(changeCode);
       // 给更换验证码按钮添加鼠标点击事件
        changeCode.addMouseListener(this);



        //创建一个装载背景图片的JLabel
        JLabel background = new JLabel(new ImageIcon(".idea//素材//image//login//background.png"));
        //设置图片位置和宽高
        background.setBounds(0,0,470,390);
        //把标签添加到界面中
        this.getContentPane().add(background);



       this.repaint();//刷新界面

   }

    //初始化JFrame
    public void initJFrame(){
        this.setSize(488,430);
        this.setTitle("登录界面");//设置窗口标题
        this.setAlwaysOnTop(true);//设置窗口置顶（总在最前端）
        this.setResizable(false);//设置窗口大小不可变
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭模式
        this.setLocationRelativeTo(null);//设置窗口居中显示
        this.setLayout(null);//取消内部默认布局
        //创建一个登录界面
    }

    // 生成验证码
    public static String verifyCode(){
        StringBuilder sb=new StringBuilder();
        Random r=new Random();
        //创建string builder对象用于存放验证码，random对象用于生成随机数

        for (int i = 0; i < 4; i++) {
            char c=(char)(r.nextInt(26)+'A');
            char C=(char)(r.nextInt(26)+'a');
            int num=r.nextInt(11)+1;
            if(num%2==0){
                sb.append(c);
            }else {
                sb.append(C);
            }

        }
        //先随机生成四个大小写字母，并随机选择存放

        int number=r.nextInt(10);
        sb.insert(r.nextInt(5),number);
        //再随机生成一个数字，插入到前面生成的四个字母

        return sb.toString();
    }

    //要展示用户名或密码错误
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置提示
        jDialog.setTitle("提示");
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);
        //取消弹框的默认布局
        jDialog.setLayout(null);
        //设置关闭弹框时释放资源
       jDialog.setDefaultCloseOperation(2);


        //创建JLabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(50, 30, 100, 20);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Object obj=mouseEvent.getSource();
        if(obj==login){
            //登录按钮功能

            //获取输入框信息
            String username=usernameInput.getText();
            String password=new String(passwordInput.getPassword());
            String code=identityCodeInput.getText();

            //校验非空
            if("".equals(username)|| password.isEmpty()){
                showJDialog("用户名或密码为空");
                return;
            }
            //校验验证码是否正确
            if(!code.equals(rightCode)){
                showJDialog("验证码输入错误");
                //刷新验证码
                rightCode=verifyCode();
                this.code.setText(rightCode);
                return;
            }

            //校验测试用用户名和密码是否正确
            if(username.equals("user")&&password.equals("123456")){
                //登录成功


                //隐藏登陆界面，显示游戏界面
                this.setVisible(false);
                new GameJFrame(true);

            }else {
              showJDialog("用户名或密码错误");
              return;
            }


        } else if (obj==register) {
            //注册按钮功能


        } else if (obj == changeCode) {
            //更换验证码功能

            //刷新验证码
            rightCode=verifyCode();
            this.code.setText(rightCode);

        }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Object obj=mouseEvent.getSource();
        if(obj==login){
            //更新登录按钮图片
            login.setIcon(new ImageIcon(".idea//素材//image//login//登录按下.png"));
        }else if(obj==register){
            //更新注册按钮图片
            register.setIcon(new ImageIcon(".idea//素材//image//login//注册按下.png"));
        } else if (obj==showPassword) {
            //更新显示密码按钮图片
            showPassword.setIcon(new ImageIcon(".idea//素材//image//login//显示密码按下.png"));
            //显示密码功能
            passwordInput.setEchoChar((char)0);
            //将密码框的密码显示出来，设置回车字符为空字符
        }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        Object obj=mouseEvent.getSource();
        if(obj==login){
            //更新登录按钮图片
            login.setIcon(new ImageIcon(".idea//素材//image//login//登录按钮.png"));
        } else if (obj==register) {
            //更新注册按钮图片
            register.setIcon(new ImageIcon(".idea//素材//image//login//注册按钮.png"));
        } else if (obj==showPassword) {
            //更新显示密码按钮图片
            showPassword.setIcon(new ImageIcon(".idea//素材//image//login//显示密码.png"));
            //隐藏密码功能
            passwordInput.setEchoChar('*');
            //将密码框的密码隐藏起来，设置回车字符为黑色圆点
        }

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
