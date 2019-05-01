package TCT.JavaA_2018;

import java.util.ArrayList;
import java.util.List;

public class _05Category {
    public static void main(String[] args) {

        _05Category obj = new _05Category();
        String[][] input1 = new String[][]{
                {"M", "B"}, {"M", "C"}, {"M", "K"},
                {"B", "E"}, {"C", "F"}, {"C", "G"}, {"C", "H"}, {"K", "I"}, {"K", "J"},
                {"E", "D"}, {"F", "L"}, {"F", "A"}, {"H", "N"}, {"H", "O"}, {"J", "P"}, {"J", "Q"}
        };

        System.out.println(input1.length);
        obj.getList(input1);

    }

    public String getTopCategory(String[][] inputData, List<String> categories){

        return null;
    }

    public int getNumberOfSubcategories(String[][] inputData, String categoryStr){
        return 0;
    }

    List<String> getList(String[][] input1){
        List<String> list = new ArrayList<>();
        String startStr = input1[0][0];

        for(int i=0; i<input1.length; i++){
            String nowStr = input1[i][0];
            String nowStr2 = input1[i][1];
            System.out.println("현재 nowStr: " + i + ", "+ nowStr);

            if(nowStr.equals(startStr)){
                System.out.println("nowStr == startStr : " + startStr);
                list.add(startStr + nowStr2);
            }else{
                System.out.println("nowStr != startStr : " + nowStr);
                for(int j=0; j < list.size(); j++){
                    String s = list.get(j);
                    String lastStr = s.substring(s.length()-1);
                    if(lastStr.equals(nowStr)){
                        System.out.println("lastStr == nowStr : " + s);
                        list.remove(j);
                        list.add(j, s+nowStr2);
                    }
                }

            }
            System.out.println(list);

        }

        System.out.println(list);

        return list;
    }

}
