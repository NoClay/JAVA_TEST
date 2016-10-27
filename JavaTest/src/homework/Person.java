package homework;

import java.util.Scanner;

/**
 * Created by NoClay on 2016/10/27.
 */
public class Person {
    private String name;
    private int age;
    private String male;


    public Person() throws MyException{
        Scanner scanner = new Scanner(System.in);
        toToast("请输入姓名：");
        this.name = scanner.next();
        toToast("请输入性别");
        this.male = scanner.next();
        if(!(this.male.equals("male") || this.male.equals("female"))){
            throw new MyException("性别输入异常，必须为male， 或者female");
        }
        toToast("请输入年龄（0-120）");
        do {
            this.age = scanner.nextInt();
        }while(this.age < 0 || this.age > 120);
    }

    public void toToast(String content){
        System.out.println(content);
    }

    public void show(){
        toToast("姓名：" + name);
        toToast("性别：" + male);
        toToast("年龄：" + age);
    }

    public class MyException extends Exception{
        public MyException() {
        }

        public MyException(String message) {
            super(message);
        }
    }

    public static void main(String []args){
        Person []persons = new Person[2];
        try {
            persons[0] = new Person();
            persons[1] = new Person();
        } catch (MyException e) {
            e.printStackTrace();
        }
        persons[0].show();
        persons[1].show();
    }
}
