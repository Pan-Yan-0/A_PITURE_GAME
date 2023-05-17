package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, MouseListener {
    //最终的胜利条件
    final static int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    //定义一个变量，去记录玩家的操作步数（不包括作弊码）
    static int count = 0;
    //各个数据的坐标集合
    int[][] data = new int[4][4];
    //空白的坐标
    int x, y;
    //定义一个变量去记录当前的图片的路径
    String path = "image/animal/animal3/";
    //创建选项下面的条目对象
    JMenu chooceClass = new JMenu("更换图片");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");

    //JFrame  界面，窗体
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initData();
        //初始化图片
        initImage();


        //界面是否显示
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        System.out.println();

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];

        }
    }

    private void initImage() {
        //清空现在所有的图片
        this.getContentPane().removeAll();
        if (victory()) {
            JLabel winJLabel = new JLabel(new ImageIcon("image/win.png"));
            winJLabel.setBounds(203, 250, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        //步数显示器
        JLabel step = new JLabel("步数：" + count);
        step.setBounds(50, 20, 100, 20);
        this.getContentPane().add(step);

        //路径分为两种
        //相对路径是相对当前项目而言的
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前要加载图片的符号
                int number = data[i][j];
                //创建一个图片ImageIcon的对象。创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(new ImageIcon(path + number + ".jpg"));
                //指定图片的位置
                jLabel.setBounds(105 * j + 83, 105 * i + 105, 105, 105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        ImageIcon bg = new ImageIcon("image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(39, 11, 508, 560);
        //吧背景图片添加到界面当中
        this.getContentPane().add(background);

        //刷新一下界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        //初始化菜单
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上边的两个选项的对象（功能  关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");


        //给条目绑定事件
        replayItem.addMouseListener(this);
        reLoginItem.addMouseListener(this);
        closeItem.addMouseListener(this);
        accountItem.addMouseListener(this);
        girl.addMouseListener(this);
        animal.addMouseListener(this);
        sport.addMouseListener(this);
        //更换图片的条目
        chooceClass.add(girl);
        chooceClass.add(animal);
        chooceClass.add(sport);
        //将更换图片Menu放到功能中
        functionJMenu.add(chooceClass);
        //将每一个选项下面的条目添加到选项中去
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);


        aboutJMenu.add(accountItem);
        //将菜单里边的选项添加到哦菜单当中

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);

        //设置页面的标题
        this.setTitle("拼图小游戏  v1.0");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中方式，只有取消了才会按照XY轴的形势添加组件
        this.setLayout(null);

        //给整个键盘添加键盘的监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (victory()) {
            return;
        }
        int keyCode = e.getKeyCode();

        if (keyCode == 65) {
            //把界面中所有的图片完全加载
            this.getContentPane().removeAll();

            //加载第一张完整图片

            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 105, 420, 420);
            this.getContentPane().add(all);

            //加载图片
            ImageIcon bg = new ImageIcon("image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(39, 11, 508, 560);

            //吧背景图片添加到界面当中
            this.getContentPane().add(background);

            //刷新界面
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利直接返回，不要让图片可以继续运行
        if (victory()) {
            return;
        }
        //对上下左右进行判断
        //左：37，上：38，右：39，下：40
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case 37 -> {
                if (y == 3) {
                    return;
                }
                System.out.println("向左移动");
                //逻辑：
                //把空白方块下方的数字往上移动
                //x，y  表示空白方块
                //x+1，y 表示空白方块下方的数字

                //把空白方块下方的数字赋值给空白方块
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++;
                count++;
                //调用方法按照最新的数字加载图片
                initImage();

            }
            case 38 -> {
                if (x == 3) {
                    return;
                }
                System.out.println("向上移动");
                //逻辑：
                //把空白方块下方的数字往上移动
                //x，y  表示空白方块
                //x+1，y 表示空白方块下方的数字

                //把空白方块下方的数字赋值给空白方块
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++;
                count++;
                //调用方法按照最新的数字加载图片
                initImage();
            }
            case 39 -> {
                if (y == 0) {
                    return;
                }
                System.out.println("向右移动");
                //逻辑：
                //把空白方块下方的数字往上移动
                //x，y  表示空白方块
                //x+1，y 表示空白方块下方的数字

                //把空白方块下方的数字赋值给空白方块
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--;
                count++;
                //调用方法按照最新的数字加载图片
                initImage();
            }
            case 40 -> {
                if (x == 0) {
                    return;
                }
                System.out.println("向下移动");
                //逻辑：
                //把空白方块下方的数字往上移动
                //x，y  表示空白方块
                //x+1，y 表示空白方块下方的数字

                //把空白方块下方的数字赋值给空白方块
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--;
                count++;
                //调用方法按照最新的数字加载图片
                initImage();
            }
            case 65 -> {
                initImage();
            }
            case 87 -> {

                for (int i = 0; i < 15; i++) {
                    data[i / 4][i % 4] = i + 1;
                }
                data[3][3] = 0;
                initImage();
            }
        }
    }

    //判断data数组是否满足胜利条件
    //全部相同返回true
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            if (data[i / 4][i % 4] != win[i / 4][i % 4]) {
                //只要一个数据不同，返回false
                return false;
            }
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Random r = new Random();
        //获取当前的被点击的条目对象
        Object source = e.getSource();
        if (source == replayItem) {
            System.out.println("重新游戏");
            this.getContentPane().removeAll();
            //重新生成data二维数组
            initData();
            //计数器清零
            count = 0;
            //重新加载图片
            initImage();
        } else if (source == reLoginItem) {
            System.out.println("重新登录");
            //关闭当前的游戏界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        } else if (source == closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);
        } else if (source == accountItem) {
            System.out.println("公众号");
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建以哦个管理图片的容器对象JLabal
            JLabel jLabel = new JLabel(new ImageIcon("image/about.png"));
            //设置位置和宽高
            jLabel.setBounds(0, 0, 258, 258);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //给弹框去设置大小
            jDialog.setSize(344, 344);
            //让弹框置顶设置
            jDialog.setAlwaysOnTop(true);
            //让弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        } else if (source == girl) {
            int num = r.nextInt(13);
            path = ("image/girl/girl" + num + "/");
            this.getContentPane().removeAll();
            initData();
            initImage();
            count = 0;
        } else if (source == animal) {
            int num = r.nextInt(8);
            path = ("image/animal/animal" + num + "/");
            this.getContentPane().removeAll();
            initData();
            initImage();
            count = 0;
        } else if (source == sport) {
            int num = r.nextInt(10);
            path = ("image/sport/sport" + num + "/");
            this.getContentPane().removeAll();
            initData();
            initImage();
            count = 0;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
