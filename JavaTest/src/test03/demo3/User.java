package test03.demo3;

/**
 * Created by 82661 on 2016/10/18.
 */
public class User {
    private String userName, password;

    public User() {
        System.out.println("全部为空!");
    }

    public User(String name) {
        this.userName = name;
    }

    public User(String name, String pwd) {
        this(name);
        this.password = pwd;
        check();
    }

    void check() {
        String s=null;
        if (userName!=null)
            s="用户名："+userName;
        else
            s="用户名不能为空！";
        if (password!="12345678")
            s=s+" 口令无效！";
        else
            s=s+" 口令：********";
        System.out.println(s);
    }
}
