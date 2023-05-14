package com.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //设置界面的宽高
        jFrame.setSize(603, 680);

        //设置页面的标题
        jFrame.setTitle("拼图小游戏  v1.0");

        //设置界面置顶
        jFrame.setAlwaysOnTop(true);

        //设置界面居中
        jFrame.setLocationRelativeTo(null);

        //设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中方式，只有取消了才会按照XY轴的形势添加组件
        jFrame.setLayout(null);


        //創建一個按鈕對象
        JButton jtb = new JButton("点我啊");
        //设置位置和宽高
        jtb.setBounds(0,0,100,50);
        //给按钮添加动作监听
        //jtb:组件对象，表示你要给哪个组件添加时间
        //addActionListener(): 表示我要给组件添加哪个事件监听（动作监听鼠标左键点击，空格）
        /*jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });*/
        jtb.addActionListener(e -> {
            System.out.println("");
        });
        //把按钮添加到界面当中
        jFrame.getContentPane().add(jtb);

        jFrame.setVisible(true);

    }
}
