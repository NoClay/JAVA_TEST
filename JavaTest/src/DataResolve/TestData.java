package DataResolve;

/**
 * Created by NoClay on 2016/11/20.
 */
public class TestData {
    private String resolveData(String data) {
        int start = 0;
        int end = 0;
        while (start != -1 && end != -1){
            start = data.indexOf("dcba");
            if (start != -1 && data.length() > 4){
                end = data.indexOf("dcba", start + 1);
            }
            if (start != -1 && end != -1 && start != end ){
                analysisData(data.substring(start, end));
                data = data.substring(end);
            }
        }
        return data;
    }

    private void analysisData(String substring) {
        if (substring == null || substring.length() <= 6){
            return;
        }
        if(substring.startsWith("dcaba")){
            int i = 2;
        }
        int pos = substring.indexOf('e');
        int type = Integer.valueOf(substring.substring(pos + 1, pos + 2), 16);
        int highLength = Integer.valueOf(substring.substring(pos + 2, pos + 4), 16);
        int lowLength = Integer.valueOf(substring.substring(pos + 4, pos + 6), 16);
        int data = Integer.valueOf(substring.substring(pos + 6, pos + (highLength + lowLength)* 2 + 6), 16);
        int sum = 0;
        for (int i = 2; i < substring.length();) {
            sum += Integer.valueOf(substring.substring(i - 2, i), 16);
            i += 2;
        }

        String sumString = Integer.toHexString(sum);
        String string1 = sumString.substring(sumString.length() - 2, sumString.length());
        String string2 = substring.substring(substring.length() - 2, substring.length());

        if (string1.equals(string2)){
            System.out.println("符合数据");
        }
    }
    public static void main(String[] args) {
        String data = "dcbae2000200007a" +
                "dcbae200020fc64f0c7b007b020fc8510200007a" +
                "dcbae";
        System.out.println(new TestData().resolveData(data));

    }
}