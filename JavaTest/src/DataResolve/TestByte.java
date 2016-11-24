package DataResolve;

/**
 * Created by NoClay on 2016/11/23.
 */
public class TestByte {

    public static void main(String[] args) {
        byte[] b = new byte[3];
        for (int i = 0; i < b.length; i++) {
            Integer a = new Integer(i-30);
            b[i] = a.byteValue();
        }
        String data = "00a7";
        System.out.println("" + data);
        Integer c = Integer.valueOf(data, 16).intValue();
        System.out.println("" + valueOfHexString(data));
    }

    /**
     * 将一个十六进制字符串转换为十进制整型
     */
    public static int valueOfHexString(String data){
        int result = Integer.valueOf(data, 16).intValue();
        String value = Integer.toBinaryString(result);
        if (value.length() == data.length() * 4 && value.startsWith("1")){
            result --;
            value = Integer.toBinaryString(result);
            StringBuilder string = new StringBuilder(value.length());
            for (int i = 0; i < value.length(); i++) {
                if (i == 0){
                    string.append(1);
                }else if (value.charAt(i) == '1'){
                    string.append(0);
                }else{
                    string.append(1);
                }
            }
            result = -Integer.valueOf(string.toString(), 2);
        }
        return result;
    }
    public static String valueOfBytes(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}