package TCT.JavaA_2018;

public class _01Stick {
    public static void main(String[] args) {
        _01Stick obj = new _01Stick();

        System.out.println(obj.getNumberOfStickForTriangle(6)); // 13
        System.out.println(obj.getNumberOfStickForTriangle(8)); // 17

        System.out.println(obj.getNumberOfStickForPyramid(4)); // 30
        System.out.println(obj.getNumberOfStickForPyramid(7)); // 84
    }

    public int getNumberOfStickForTriangle(int i){
        return 3+(i-1)*2;
    }

    public int getNumberOfStickForPyramid(int input){
        int rslt = 0;
        int i = input;
        while (i > 0) {
            rslt += 3+(2*i-2)*2;
            i--;
        }

        input--;
        while(input > 0){
            rslt -= input;
            input--;
        }

        return rslt;
    }
}
