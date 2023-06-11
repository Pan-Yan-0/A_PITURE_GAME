package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterJFrame extends JFrame implements MouseListener, ActionListener {
    //1.添加用户名输入框
    JTextField username = new JTextField();
    //2.密码输入框
    JPasswordField password = new JPasswordField();
    //3.手机号输入框
    JTextField phone = new JTextField();
    //二次秘密输入框
    JPasswordField password2 = new JPasswordField();
    //添加重置的按钮
    JButton change = new JButton();
    //添加重置的按钮
    JButton reset = new JButton();
    //6.添加注册按钮
    JButton register = new JButton();
    //7.提示面板
    JPanel hint;
    //hint = new JPanel();
    //JOptionPane.showMessageDialog(null, "信息有空缺，请补全！","消息提示",JOptionPane.WARNING_MESSAGE);
    public RegisterJFrame() {
        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initText();

        //让当前界面显示出来
        this.setVisible(true);
        this.setResizable(false);
    }
    public void initJFrame(){
        this.setSize(488,430);
        //设置页面的标题
        this.setTitle("拼图  注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void initText() {
        hint = new JPanel();
        this.add(hint);
        //修改密码
        change.setBounds(0, 306, 210, 45);
        change.setIcon(new ImageIcon("src\\image\\register\\修改密码按钮.png"));
        //去除按钮的默认边框
        change.setBorderPainted(false);
        //去除按钮的默认背景
        change.setContentAreaFilled(false);
        this.getContentPane().add(change);
        //注册按钮
        register.setBounds(180, 310, 120, 45);
        register.setIcon(new ImageIcon("src\\image\\register\\注册按钮.png"));
        //添加事件
        register.addMouseListener(this);
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);
        //重置按钮
        reset.setBounds(310, 310, 120, 45);
        reset.setIcon(new ImageIcon("src\\image\\register\\重置按钮.png"));
        //添加事件
        reset.addMouseListener(this);
        //去除按钮的默认边框
        reset.setBorderPainted(false);
        //去除按钮的默认背景
        reset.setContentAreaFilled(false);
        this.getContentPane().add(reset);
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("src\\image\\register\\注册用户名.png"));
        usernameText.setBounds(80, 123, 90, 17);
        this.getContentPane().add(usernameText);

        username.setBounds(185 , 120, 180, 27);
        username.setFont(new Font("宋体", Font.BOLD, 17));
        this.getContentPane().add(username);

        //手机号
        JLabel phonetext = new JLabel("手机号码");
        phonetext.setBounds(93, 163, 80, 17);
        phonetext.setFont(new Font("微软雅黑", 0, 17));
        phonetext.setForeground(new Color(145,69,25));
        this.getContentPane().add(phonetext);

        phone.setBounds(185 , 160, 180, 27);
        phone.setFont(new Font("宋体", Font.BOLD, 17));
        this.getContentPane().add(phone);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("src\\image\\register\\注册密码.png"));
        passwordText.setBounds(83, 200, 100, 30);
        this.getContentPane().add(passwordText);

        password.setBounds(185 , 200, 180, 27);
        password.setFont(new Font("宋体", Font.BOLD, 17));
        this.getContentPane().add(password);
        //再次输入密码
        JLabel password2Text = new JLabel(new ImageIcon("src\\image\\register\\再次输入密码.png"));
        password2Text.setBounds(68, 243, 100, 17);
        this.getContentPane().add(password2Text);

        password2.setBounds(185 , 240, 180, 27);
        password2.setFont(new Font("宋体", Font.BOLD, 17));
        this.getContentPane().add(password2);
        
        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("src\\image\\register\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);


        register.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                switch (User.addUser(username.getText(),phone.getText(), password.getText(), password2.getText())) {
                    case 1:
                        showJDialog(" 用户名已存在");
                        username.setText("");
                        break;
                    case 2:
                        showJDialog(" 电话号码已注册");
                        phone.setText("");
                        break;
                    case 3:
                        showJDialog(" 两次密码不同 ");
                        password.setText("");
                        password2.setText("");
                        break;
                    case 4:
                        showJDialog(" 用户名不能为空");
                        break;
                    case 5:
                        showJDialog(" 电话号码不能为空 ");
                        break;
                    case 6:
                        showJDialog(" 密码不能为空");
                        break;
                    case 7:
                        showJDialog(" 密码不能为空 ");
                        break;
                    case 8:
                        showJDialog(" 电话号码格式错误");
                        break;
                    case 9:
                        showJDialog("注册成功 ");
                        new LoginJFrame();
                        dispose();
                        break;
                }
            }
        });
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (User.reWrite_password(username.getText(), phone.getText(),password.getText(), password2.getText())) {
                    case 0:
                        showJDialog(" 电话号码没注册");
                        break;
                    case 1:
                        showJDialog(" 两次密码不同");
                        password.setText("");
                        password2.setText("");
                        break;
                    case 2:
                        showJDialog(" 用户名和电话号码不匹配");
                        phone.setText("");
                        break;
                    case 3:
                        showJDialog("新旧密码相同");
                        break;
                    case 4:
                        showJDialog("电话号码格式不正确，请输入11位号码");
                        break;
                    case 5:
                        showJDialog("密码不能为空");
                        break;
                    case 6:
                        showJDialog("电话号码不能为空");
                        break;
                    case 7:
                        showJDialog("用户名不能为空");
                        break;
                    case 8:
                        showJDialog("修改成功");
                        new LoginJFrame();
                        dispose();
                        break;

                }
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
    }
    private void clear() {
        password.setText("");    //设置为空
        password2.setText("");
        username.setText("");
        phone.setText("");

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
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

