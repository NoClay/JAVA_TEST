package DataResolve;

/**
 * Created by NoClay on 2016/11/3.
 */
public class DoData {

    public static final String FLAG = "E2";


    public static void toToast(String content){
        System.out.println(content);
    }
    public static String doData(String data){
        String result = null;
        int type;
        int lowLength;
        int highLength;
        int sum;
        int check;
        int tool;
        int start, end;
        start = end = 0;
        while(end != -1){
            start = data.indexOf("DC BA ");
            end = data.indexOf("DC BA ", start + 5);
            if(start != -1 && end != -1){
                result = data.substring(start, end);
                data = data.substring(end);
                toToast(result);
                tool = 7 + start;
                type = Integer.valueOf(result.substring(tool, tool + 1), 16);
                toToast("type = E" + type);
                tool = 9 + start;
                lowLength = Integer.valueOf(result.substring(tool, tool + 2), 16);
                toToast("lowLength = " + lowLength);
                tool = 12 + start;
                highLength = Integer.valueOf(result.substring(tool, tool + 2), 16);
                toToast("highLength = " + highLength);
                toToast("length = " + (highLength + lowLength));
                tool = start + 15;
                String string =  result.substring(tool, tool + (highLength + lowLength) * 3 - 1);
                string = string.replace(" ", "");
                toToast(Integer.valueOf(string, 16).toString());
                tool = start + (5 + highLength + lowLength) * 3;
                sum = Integer.valueOf(result.substring(tool, tool + 2), 16);
                toToast("sum = " + sum);
            }
        }
        result = data;
        return result;
    }



    public static void main(String[] args) {
        String data = "DC BA E2 00 02 08 13 95 " +
                "DC BA E2 00 02 08 18 9A " +
                "DC BA E4 00 02 09 2B B0 " +
                "DC BA E2 00 02 08 15 97 " +
                "DC BA E1 00 04 54 42 00 00 11 " +
                "DC BA E2 00 02 08 17 99 " +
                "DC BA E5 00 04 00 00 04 32 B5" +
                "DC BA E2 00"
                + " ";
        //模拟一个流的过程
        DoData.toToast("处理剩余数据 + " + DoData.doData(data));
    }
}