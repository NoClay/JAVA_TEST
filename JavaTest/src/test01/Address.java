package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public class Address {
    private String name;
    private String phoneNumber;
    private String email;

    public Address(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public void showMessage(){
        System.out.println(
                "姓名:" + name
                + "\n电话:" + phoneNumber
                + "\n邮箱:" + email
        );
    }
    public static void main(String []args){
        Address adress1 = new Address("王二", "15115151511", "wanger@163.com");
        Address adress2 = new Address("张三", "15115151523", "zhangsan@163.com");
        Address adress3 = new Address("李四", "15115157286", "lisi@163.com");
        adress1.showMessage();
        adress2.showMessage();
        adress3.showMessage();

    }
}
