package Test;

/**
 * Created by NoClay on 2016/12/22.
 */

//����һ����������,����ӵ�г��������������ԣ�����������ĺ�����
//        ����һ������̳иó������࣬�������ӳ�Ա�����������������Ӽ��㳤���������ĺ�����
//
//        �����ʽ:
//
//        ��������õĹ��������������Ա����ֵ����ʾ�����㳤���������ĺ�����
//
//        �������:
//
//        �����������Ӧ����������磺
//        ��ʱ���õ�һ�����캯��
//        ��ʱ���õڶ������캯��
//        ��ʱ���õ��������캯��
//        ��������Ϊ�������ݣ�height=3.0
//        3.0
//        2.0
//        Volume of newCuboid is3000.0
//        Weight of newCuboid is34.3
//        superficialarea of newCuboid is1300.0
public class Rectangle {
    float x;
    float y;
    float z;

    public float getV(){
        return x * y * z;
    }
}
class TestRectangle extends Rectangle{
    float weight;
    public float getArea(){
        return 2 * (x * y + x * z + y * z);
    }

}
