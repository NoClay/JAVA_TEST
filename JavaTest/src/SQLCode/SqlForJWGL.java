package SQLCode;

import java.util.Random;

/**
 * Created by NoClay on 2016/11/3.
 */
public class SqlForJWGL {
    private String []Sname = {"张三","李四","王武","刘能","尼古拉斯","冯诺依曼","堂吉诃德"
                                ,"六小龄童","李思思","胡啦","故事会"};
    private String []Sex = {"男","女"};
    private String []Sdept = {"art","计算机","软件工程","网页开发"};
    private String []Cname = {"英语","数学","高等数学","软件工程","数据库原理与应用","java语言"
                                ,"大学英语","云时代","电影鉴赏"};
    private String []Sno = {"023","023","032","055","085","086","320"
                            ,"426","432","578","627","714","715","877","878"};
    private String []Cno = {"10","11","12","13","14","15","16","89","90","91"};


    public void getStudent(int n){
        Random random = new Random();
        System.out.println("insert into Student (Sno, Sname, Sex, Age, Phonenumber, Sdept)");
        for (int i = 0; i < n; i++) {
            System.out.println("select '04141" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9)
                    + "','" + Sname[random.nextInt(Sname.length)]
                    + "','" + Sex[random.nextInt(Sex.length)]
                    + "'," + (random.nextInt(15) + 15)
                    + ",'1566702" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9)
                    + "','" + Sdept[random.nextInt(Sdept.length)]
                    + "'\nunion all");
        }
    }

    public void getCourse(int n){
        Random random = new Random();
        System.out.println("insert into Course (Cno,Cname, Total_perior, Week_perior, credit, Pcno)");
        for (int i = 0; i < n; i++) {
            System.out.println("select '01234567" + (10 + i)
                + "','" + Cname[i]
                + "'," + (random.nextInt(108 - 32) + 32)
                + "," + (random.nextInt(5) + 2)
                + "," + (random.nextInt(6) + 1)
                + ",'01234567" + (10 + i) + "'\nunion all");
        }

    }

    public void getSC(int n){
        Random random = new Random();
        System.out.println("insert into SC (Sno, Cno, Grade)");
        for (int i = 0; i < n; i++) {
            System.out.println("select '04141" + Sno[random.nextInt(Sno.length)]
                    + "','01234567" + Cno[random.nextInt(Cno.length)]
                    + "'," + (random.nextInt(60) + 40) +
                    "\nunion all");
        }
    }

    public static void main(String[] args) {
        SqlForJWGL s = new SqlForJWGL();
        s.getSC(10);
    }
}