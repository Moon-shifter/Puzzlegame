package com.kuma.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] arr2D = new int[4][4];//用来存储打乱后的二维数组
    //记录空白方块的位置
    int x=0;
    int y=0;

    //测试用图片路径
    String path=getRandomImagePath(8,"animal");


    //定义变量用来统计步数
    int step=0;

    //记录胜利数组
    int [][]win={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };


    //记录胜利的次数
    int winCount=0;
    //记录胜利的最小步数
    int minStep=9999;

    //创建功能选项
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("账号信息");

    //创建更换图片选项
    JMenuItem girlItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");


   //窗体构造方法
    public GameJFrame(boolean flag){
        
        //初始化界面
        initJFrame();
        
        //初始化菜单
        initJMenuBar();

        //初始化数据
        initData();



        //初始化图片
        initImage(path);




        //界面显示写在最后
         this.setVisible(flag);//设置窗口不可见
    }

   //初始化数据，包括打乱二维数组，以及空白方块位置
    private void initData() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            int p = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
        }


        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                x=i/4;
                y=i%4;
            }

            arr2D[i / 4][i % 4] = arr[i];
        }

    }

    //初始化图片，包括背景图片，拼图图片，胜利图片
    private void initImage(String path) {
        //移除所有图片
        this.getContentPane().removeAll();

        //如果胜利了就显示胜利图片
        if(isWin()){
            //显示胜利的图标
            JLabel winJLabel=new JLabel(new ImageIcon(".idea\\素材\\image\\win.png"));
            winJLabel.setBounds(290,300,197,73);
            this.getContentPane().add(winJLabel);
            //胜利次数增加
            winCount++;
            //获得最小步数
            minStep=Math.min(minStep,step);
        }

        //添加步数统计
        JLabel stepCount=new JLabel("步数："+this.step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取图片序号
                int num=arr2D[i][j];
                //创建一个JLabel的对象（相当于一个容器）
                JLabel jLabel=new JLabel(new ImageIcon(path+num+".jpg") );
                //指定图片位置
                jLabel.setBounds(105*j+175,105*i+145,105,105);
                //设置边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                //将图片添加到容器中
                this.getContentPane().add(jLabel);
            }
        }

         //添加背景图片
        JLabel background = new JLabel(new ImageIcon(".idea\\素材\\image\\background.png"));
        background.setBounds(131,51,508,560);
        this.getContentPane().add(background);

        //刷新图片
        this.getContentPane().repaint();

    }

    //初始化菜单，包括功能菜单，账户信息菜单，更换图片菜单
    private void initJMenuBar() {
        //菜单的创建
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单项
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("账户信息");
        JMenu imgJMenu = new JMenu("更换图片");


        //将功能选项添加到菜单中
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        //将更换图片选项添加到功能菜单中
        functionJMenu.add(imgJMenu);

        //将账户信息选项添加到菜单中
        aboutJMenu.add(accountItem);
        //将更换图片选项添加到菜单中
        imgJMenu.add(girlItem);
        imgJMenu.add(animalItem);
        imgJMenu.add(sportItem);


        //给条目绑定事件
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        //给更换图片选项绑定事件
        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);


        //将菜单添加到菜单栏中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);


        //将菜单栏添加到界面中
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面，包括大小，标题，关闭模式，布局，居中，置顶，键盘监听等等
    private void initJFrame() {
        //创建一个游戏主界面
        this.setSize(800,750);//设置窗口大小
        this.setTitle("拼图小游戏 V1.0");//设置窗口标题
        this.setAlwaysOnTop(true);//设置窗口置顶（总在最前端）
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭模式
        this.setResizable(false);//设置窗口大小不可变
        this.setLocationRelativeTo(null);//设置窗口居中显示
        this.setLayout(null);//取消内部默认布局,使其可以xy定位
        this.addKeyListener(this);//让键盘监听器与当前界面相关联
    }

    //获取随机图片路径
    private String getRandomImagePath(int num,String imageName){
        //获得1——num之间的随机数
        Random random=new Random();
        //序号为1——num之间
        int p=random.nextInt(num+1)+1;
        //返回拼接好的路径
        return ".idea\\素材\\image\\"+imageName+"\\"+imageName+p+"\\";
    }

    //键盘按下事件
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
    //键盘按下事件
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        //首先判断游戏是否胜利
        if(isWin()) {
            return;//如果胜利则不再执行下面的代码
        }


        //设置作弊键
        int code=keyEvent.getKeyCode();
        if(code==81)//Q键
        {
            //清除界面所有图片
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            JLabel jLabel=new JLabel(new ImageIcon(path+"all.jpg"));
            jLabel.setBounds(175,145, 420,420);
            this.getContentPane().add(jLabel);
            //添加背景图片
            JLabel background = new JLabel(new ImageIcon(".idea\\素材\\image\\background.png"));
            background.setBounds(131,51,508,560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }
    }
    //键盘释放事件
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //首先判断游戏是否胜利
        if(isWin()) {
            return;//如果胜利则不再执行下面的代码
        }



        //对上下左右进行判断
        //左：37，上：38，右：39，下：40
        int code = keyEvent.getKeyCode();
        if(code==37||code==65){//左
            System.out.println("向左移动");
            //xy表示空白方块的位置
            //x，y+1表示空白方块右边的数字

            //y<3表示空白方块不在最右边一列
            if(y<3) {
                //把空白方块右边的数字赋值给空白方块
                arr2D[x][y] = arr2D[x][y + 1];
                //把空白方块右边的数字变成0
                arr2D[x][y + 1] = 0;
                y++;//更新空白方块的y坐标

                //步数增加
                step++;
                //调用方法去更新图片
                initImage(path);
            }




            }else if(code==38||code==87){//上
            System.out.println("向上移动");
            //xy表示空白方块的位置
            //x+1，y表示空白方块下方的数字

            //x<3表示空白方块不在最下面一行
            if(x<3){
                //把空白方块下面的数字赋值给空白方块
                arr2D[x][y]=arr2D[x+1][y];
                //把空白方块下面的数字变成0
                arr2D[x+1][y]=0;
                x++;//更新空白方块的x坐标

                //步数增加
                step++;
                //调用方法去更新图片
                initImage(path);

            }




        }else if(code==39||code==68){//右
            System.out.println("向右移动");
            //xy表示空白方块的位置
            //x，y-1表示空白方块左边的数字

            //y>0表示空白方块不在最左边一列
            if(y>0){
                //把空白方块左边的数字赋值给空白方块
                arr2D[x][y]=arr2D[x][y-1];
                //把空白方块左边的数字变成0
                arr2D[x][y-1]=0;
                y--;//更新空白方块的y坐标
                //步数增加
                step++;
                //调用方法去更新图片
                initImage(path);

            }



        }else if(code==40||code==83) {//下
            System.out.println("向下移动");
            //xy表示空白方块的位置
            //x+1，y表示空白方块下方的数字

            //x>0表示空白方块不在最上面一行
            if(x>0){
                //把空白方块上面的数字赋值给空白方块
                arr2D[x][y]=arr2D[x-1][y];
                //把空白方块上面的数字变成0
                arr2D[x-1][y]=0;
                x--;//更新空白方块的x坐标

                //步数增加
                step++;
                //调用方法去更新图片
                initImage(path);

            }

        } else if (code==81) {
            initImage(path);
        } else if (code==192) {
            arr2D=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            x=3;
            y=3;
            initImage(path);
        }

    }

    //判断是否胜利
    public boolean isWin(){
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if(win[i][j]!=arr2D[i][j]){
                    return false;
                }
            }

        }
      return true;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //获取被点击的条目对象
        Object obj=actionEvent.getSource();
        //判断
        if(obj==replayItem){
            System.out.println("重新游戏");
            //步数清零
            step=0;
            //重新打乱二维数组
            initData();
            //重新加载图片
            initImage(path);

        } else if (obj==reloginItem) {
            System.out.println("重新登陆");
            //关闭当前界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();

        } else if (obj==closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);//JVM退出
        } else if (obj==accountItem) {
            System.out.println("账户信息");

            //调用弹窗方法
             showJDialog();

        } else if (obj==girlItem) {
            //更新图片路径
            path=getRandomImagePath(13,"girl");
            //步数清零
            step=0;
            //重新打乱二维数组
            initData();
            //重新加载图片
            initImage(path);
        } else if (obj==animalItem) {
            //更新图片路径
            path=getRandomImagePath(8,"animal");
            //步数清零
            step=0;
            //重新打乱二维数组
            initData();
            //重新加载图片
            initImage(path);
        } else if (obj==sportItem) {
            //更新图片路径
            path=getRandomImagePath(10,"sport");
            //步数清零
            step=0;
            //重新打乱二维数组
            initData();
            //重新加载图片
            initImage(path);

        }

    }

    private void showJDialog() {
        //创建一个弹框对象
        JDialog jDialog=new JDialog();
        //设置标题
        jDialog.setTitle("账户信息");
        //设置大小
        jDialog.setSize(400,300);
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
        JLabel  userLabel=new JLabel("账号：user");
        JLabel  theMinStep=new JLabel("胜利最少步数："+minStep+"步");
        JLabel countLabel=new JLabel("胜利次数："+(winCount)+"次");

        //设置位置
        userLabel.setBounds(150,30,200,20);
        theMinStep.setBounds(150,80,200,20);
        countLabel.setBounds(150,130,200,20);

        //添加到弹框
        jDialog.getContentPane().add(userLabel);
        jDialog.getContentPane().add(theMinStep);
        jDialog.getContentPane().add(countLabel);

        //让弹框展示出来
        jDialog.setVisible(true);



    }
}
