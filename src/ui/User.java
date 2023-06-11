package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static ArrayList<User> userlist = new ArrayList<User>();
    private static ArrayList<User> userOnline = new ArrayList<User>();
    private String userName;
    private String userPhone;
    private String userPassword;
    public static ArrayList<User> getUserlist() {
        return userlist;
    }


    public static ArrayList<User> getUserOnline() {
        return userOnline;
    }

   


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserPhone() {
        return userPhone;
    }

     
    static void wirtefile(String name, String phone, String password, boolean append) {
        String str = name + " " + phone + " " + password + "\n";
        File f = new File("userfile.txt");
        if (f.exists()) {
        } else {
            try {
                f.createNewFile();
            } catch (IOException e) {
            }
        }
        try {
            FileWriter fw = new FileWriter("userfile.txt", append);
            fw.write(str);
            fw.close();
        } catch (IOException e) {

        }
    }

   private static void readfile() {
        userlist.removeAll(userlist);
        try {
            Scanner fileSC = new Scanner(new File("userfile.txt"));
            while (fileSC.hasNext()) {
                userlist.add(new User(fileSC.next(), fileSC.next(),fileSC.next()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件没找到！");
        }
    }

    private static boolean hasUser_name(String username) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }


   private static User findUser_name(String username) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(username)) {
                return userlist.get(i);
            }
        }
        return new User();
    }
   static boolean hasUser_phone(String userphone) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserPhone().equals(userphone)) {
                return true;
            }
        }
        return false;
    }


    private static User findUser_phone(String userphone) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserPhone().equals(userphone)) {
                return userlist.get(i);
            }
        }
        return new User();
    }

     static int login_name(String name, String password,String yanzheng,String Tyanzheng) {
        readfile();
        if(!yanzheng.equalsIgnoreCase(Tyanzheng)){
            return 4;//验证码错误
        }else if (!hasUser_name(name)) {
            return 0; // 用户没找到,没注册
        } else if (!findUser_name(name).userPassword.equals(password)) {
            return 1; // 密码错误
        }  else if(online_hasUser_name(name)){
            return  2;//用户已经登录
        }else{
            userOnline.add(findUser_name(name));
            return 3;// 登录成功
        }
    }
    //退出
    static void exit_name(String name){
        userOnline.remove(findUser_name(name));
    }
    //判断是否在线
    private static boolean online_hasUser_name(String name){
        for(int i=0;i<userOnline.size();i++){
           if(userOnline.get(i).getUserName().equals(name)){
            return true;
           }
        }
        return false;
    }

    // 注册
     static int addUser(String name, String phone, String password_1, String password_2) {
        readfile();
        if (hasUser_name(name)) {
            return 1;// 用户名已存在
        } else if (hasUser_phone(phone)) {
            return 2;// 电话号码已注册
        } else if (!password_1.equals(password_2)) {
            return 3;// 两次密码不同
        } else if (name.equals("")) {
            return 4;// 用户名为空
        } else if (phone.equals("")) {
            return 5;// 电话号码为空
        } else if (password_1.equals("")) {
            return 6;// 密码1为空
        } else if (password_2.equals("")) {
            return 7;// 密码2为空
        } else if (phone.length() != 11) {
            return 8;// 电话号码不是11位
        } else {
            wirtefile(name, phone, password_2, true);
            readfile();
            return 9;// 注册成功
        }
    }


    // 修改密码
    public static int reWrite_password(String name,String phone, String password_1, String password_2) {
        readfile();
        if (phone.length()!=11) {
            return 4;// 密码1为空
        } else if(!name.equals(findUser_phone(phone).getUserName())){
            return 2;//用户名和电话号码不匹配
        }else if (!hasUser_phone(phone)) {
            return 0;// 电话号码没注册
        } else if (!password_1.equals(password_2)) {
            return 1;// 两次密码不同
        } else if (findUser_phone(phone).getUserPassword().equals(password_2)) {
            return 3;// 新旧密码相同
        } else  if(password_2.equals("")) {
            return 5;// 密码2为空
        } else if(phone.equals("")){
            return 6;//电话号码为空
        }else if(name.equals("")){
            return 7;
        }else{
            findUser_phone(phone).setUserPassword(password_2); 
            rewirte();
            return 8;// 修改成功
        }
    }



    private static void rewirte() {
        wirtefile("", "","", false);
        for (int i = 0; i < userlist.size(); i++) {
            wirtefile(userlist.get(i).getUserName(),userlist.get(i).getUserPhone(), userlist.get(i).getUserPassword(), true);
        }
    }

     

   
    User() {
    }
    // User(String userName, String userPassword) {
    //     this.userName = userName;
    //     this.userPassword = userPassword;
    // }

    User(String userName,String userPhone, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone=userPhone;
    }

   


}
