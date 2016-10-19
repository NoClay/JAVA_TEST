package test02;

/**
 * Created by 82661 on 2016/10/13.
 */
public class Test {


    public static final int MODE_SHIFT = 30;
    public static final int MODE_MASK  = 0x3 << MODE_SHIFT;
    public static final int UNSPECIFIED = 0 << MODE_SHIFT;
    public static final int EXACTLY     = 1 << MODE_SHIFT;
    public static final int AT_MOST     = 2 << MODE_SHIFT;


    public int getMeasureSpec(int size, int mode) {
        return (size & ~MODE_MASK) | (mode & MODE_MASK);
    }

    public int getMode(int measureSpec) {
        return (measureSpec & MODE_MASK);
    }

    public int getSize(int measureSpec) {
        return (measureSpec & ~MODE_MASK);
    }
    public static void main(String []args){
        Test test = new Test();
        int measureSpec;
        measureSpec = test.getMeasureSpec(3, Test.UNSPECIFIED);
        toToast("The measureSpec is " + measureSpec);
        toToast("The mode is " + (test.getMode(measureSpec) == Test.UNSPECIFIED));
        toToast("The size is " + test.getSize(measureSpec));
        measureSpec = test.getMeasureSpec(3, Test.EXACTLY);
        toToast("The measureSpec is " + measureSpec);
        toToast("The mode is " + (test.getMode(measureSpec) == Test.EXACTLY));
        toToast("The size is " + test.getSize(measureSpec));
        measureSpec = test.getMeasureSpec(3, Test.AT_MOST);
        toToast("The measureSpec is " + measureSpec);
        toToast("The mode is " + (test.getMode(measureSpec) == Test.AT_MOST));
        toToast("The size is " + test.getSize(measureSpec));
    }

    private static void toToast(String s) {
        System.out.println(s);
    }
}
