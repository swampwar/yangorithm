package TCT.JavaA_2018;

public class _04Aggregate {
    public static void main(String[] args) {
        _04Aggregate obj = new _04Aggregate();

        int[][] case1 = {{-1, 0, 7, 9},
                         {-6, 2, -3, 5},
                         {3, -6, 0, -5},
                         {7, 8, -7, 2}};
        System.out.println("Case1");
        System.out.println("4 X 4 배열의 부분 배열 갯수(30개) : "  + obj.getNumberofSubArrays(case1.length));
        System.out.println("4 X 4 배열의 부분 배열내의 최대합(18) : "  + obj.getMaximumValue(case1));

        int[][] case2 = {{1, -3, 0, 2, 5},
                         {-3, 0, 8, -3, 7},
                         {9, -1, -2, 6, 0},
                         {-2, -5, 9, 7, 6},
                         {3, 2, 4, 7, -5}};
        System.out.println("Case2");
        System.out.println("4 X 4 배열의 부분 배열 갯수(55개) : "  + obj.getNumberofSubArrays(case2.length));
        System.out.println("4 X 4 배열의 부분 배열내의 최대합(52) : "  + obj.getMaximumValue(case2));
    }

    private int getNumberofSubArrays(int arraySize){
        int cnt = 0;
        for(int i=0; i<arraySize; i++){
            for(int j=0; j<arraySize; j++){
                int range = 0;
                while(i+range < arraySize && j+range < arraySize){
                    cnt++;
                    range++;
                }
            }
        }
        return cnt;
    }

    private int getMaximumValue(int[][] inputData){
        int max = 0;

        for(int i=0; i<inputData.length; i++){
            for(int j=0; j<inputData[i].length; j++){
                int range = 0;

                while(i+range < inputData.length && j+range < inputData[i].length){
                    int tmpSum = 0;

                    for(int ii = 0; ii <= range; ii++){
                        for(int jj = 0; jj <= range; jj++){
                            tmpSum += inputData[i + ii][j + jj];
                        }
                    }

                    if(max < tmpSum) max = tmpSum;
                    range++;
                }
            }
        }
        return max;
    }
}