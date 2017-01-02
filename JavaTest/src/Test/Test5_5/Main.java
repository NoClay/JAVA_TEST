package Test.Test5_5;

/**
 * Created by NoClay on 2016/12/22.
 */
public class Main {
    interface ClassName{
        public String getClassName();
    }
    static class Company implements ClassName{

        @Override
        public String getClassName() {
            return this.getClass().getSimpleName();
        }
    }
    public static void main(String []args){
        Company company = new Company();
        System.out.println(company.getClassName());
    }
}
