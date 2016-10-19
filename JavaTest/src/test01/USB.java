package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public interface USB {
    public void start();
    public void work();
    public void stop();
}
class Computer{
    public static void plugin(USB usb){
        usb.start();

        usb.work();

        usb.stop();
    }
    public static void main(String [] args){
        Computer computer = new Computer();
        Flash uPan = new Flash("xiaoMi");
        computer.plugin(uPan);
        Print print = new Print("some");
        computer.plugin(print);
    }
}
class Print implements USB{

    private String name;

    public Print(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("打印机" + name + "已连接");

    }

    @Override
    public void work() {
        System.out.println("打印机" + name + "正在打印。。。");


    }

    @Override
    public void stop() {
        System.out.println("打印机" + name + "已断开");


    }
}
class Flash implements USB{
    private String name;

    public Flash(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("U盘" + name + "已插入");
    }

    @Override
    public void work() {
        System.out.println("U盘" + name + "正在读取。。。");
    }

    @Override
    public void stop() {
        System.out.println("U盘" + name + "已弹出");
    }
}
