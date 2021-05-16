package text;

/**
 * 利用二分法开根号
 */
public class s {

    static double r;

    public static void sqrt(double number) {
        process(number, 0, number);
    }

    private static void process(double number, double min, double max) {
        double mid = min + (max - min) / 2;
        double result = mid * mid;
        //设置精度为0.001
        if (Math.abs(result - number) <= 0.001) {
            r = mid;
            return;
        }
        if (result > number) {
            max = mid;
        } else {
            min = mid;
        }
        //递归调用
        process(number, min, max);
    }

    public static void main(String[] args) {
        //二分法开根号
        sqrt(25);
        System.out.println(r);
    }
}


