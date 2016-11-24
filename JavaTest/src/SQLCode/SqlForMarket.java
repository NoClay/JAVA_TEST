package SQLCode;

/**
 * Created by NoClay on 2016/11/10.
 */
public class SqlForMarket {
    String [] name = {
            "张三","李四","王武","刘能","尼古拉斯","冯诺依曼","堂吉诃德"
            ,"六小龄童","李思思","胡啦","故事会","金三胖","金四胖"
    };
    String [] address = {
            "重庆市渝中区新华路4号-1号(朝天门时代天骄大厦14层) "
            , "重庆市渝中区朝天门新华路5号(时代天骄18-2)"
            , "重庆市渝中区信义街18号朝天门大酒店901F"
            , "重庆市建新北路电测村100号北辰名都19楼(茂业百货对面) "
            , "重庆市渝中区朝天门信义街18号（港口售票大厅底层） "
    };
    String city = "重庆";
    String []company = {"腾讯","阿里", "百度", "神舟数码"};


    public void getCustomers(int n){
        System.out.println("insert into Customers(Cname, Address, City, Tel, Company, Birthday)");
    }

}
