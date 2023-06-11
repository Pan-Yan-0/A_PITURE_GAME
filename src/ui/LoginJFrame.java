package ui;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// import java.util.ArrayList;
import java.util.Random;

public class LoginJFrame extends JFrame implements KeyListener, MouseListener {
    //2.添加用户名输入框
    JTextField username = new JTextField();
    //4.密码输入框
    JPasswordField password = new JPasswordField();

    //验证码的输入框
    JTextField code = new JTextField();
    //添加登录的按钮
    JButton login = new JButton();
    //6.添加注册按钮
    JButton register = new JButton();
    //用户名
    StringBuilder InputUserName = new StringBuilder();
    //密码
    StringBuilder InputUserPassword = new StringBuilder();
    //验证码
    StringBuilder InputUserCode = new StringBuilder();
    String codeStr ="";//当前验证码

    public LoginJFrame() {
        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("src\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //输入user的框架构建
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);
        username.addKeyListener(this);
        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("src\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //输入密码的框架
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("src\\image\\login\\验证码.png"));
        codeText.setBounds(111, 256, 50, 30);
        this.getContentPane().add(codeText);

        //输入验证码的输入框架
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        //构建验证码
        StringBuilder stringBuilder = new StringBuilder();
        Random r = new Random();
        String arr = new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String arr1 = new String("1234567890");
        for (int i = 0; i < 4; i++) {
            int num = r.nextInt(arr.length());
            stringBuilder.append(arr.charAt(num));
        }
        stringBuilder.append(arr1.charAt(r.nextInt(arr1.length())));
         codeStr =new String(stringBuilder);
        JLabel rightCode = new JLabel();
        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //5.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("src\\image\\login\\登录按钮.png"));
        login.addMouseListener(this);
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);

        //注册框架的构建
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("src\\image\\login\\注册按钮.png"));
        //添加事件
        register.addMouseListener(this);
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("src\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
            
    }


    public void initJFrame() {
        this.setSize(488, 430);//设置宽高
        this.setTitle("拼图游戏 V1.0登录");//设置标题
        this.setDefaultCloseOperation(3);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
    }


    //要展示用户名或密码错误
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置标签和大小
        jDialog.setTitle("提示");
        jDialog.setSize(300, 100);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        //设置字体
        warning.setFont(new Font("微软雅黑", 1, 17));
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object source = e.getSource();
        //输入用户名的监听
        if (source==username){
            InputUserName.append(e.getKeyChar());
            System.out.println(InputUserName);
        } else if (source==password) {
            InputUserPassword.append(e.getKeyChar());
            //输入密码的监听
        } else if (source==code) {
            //输入验证码的监听
            InputUserCode.append(e.getKeyChar());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        System.out.println(new String(password.getPassword()));
        if (source==login){
        switch (User.login_name(username.getText(),new String(password.getPassword()) ,code.getText(),codeStr)){
        case 0:showJDialog("用户不存在");break;
        case 1:showJDialog("密码错误");break;
        case 2:showJDialog("用户已经登录");break;
        case 3:new GameJFrame(username.getText());showJDialog("登录成功");dispose();break;
        case 4:showJDialog("验证码错误");break;
        }
        } else if (source==register) {
            //进入注册页面
            new RegisterJFrame();//注册页面
            setVisible(false);
        }
    }

    

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}