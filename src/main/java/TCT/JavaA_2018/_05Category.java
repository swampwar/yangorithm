package TCT.JavaA_2018;

import java.util.*;

public class _05Category {

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        _05Category obj = new _05Category();

        String[][] input1 = new String[][]{
                {"M", "B"}, {"M", "C"}, {"M", "K"},
                {"B", "E"}, {"C", "F"}, {"C", "G"}, {"C", "H"}, {"K", "I"}, {"K", "J"},
                {"E", "D"}, {"F", "L"}, {"F", "A"}, {"H", "N"}, {"H", "O"}, {"J", "P"}, {"J", "Q"}
        };


        obj.run(input1, "F", "N", "J");

        System.out.println("-------------------------------------------------------------------");


        String[][] input2 = new String[][]{
                {"Z", "B"}, {"Z", "W"}, {"Z", "V"},
                {"B", "E"}, {"W", "F"}, {"W", "G"}, {"V", "H"}, {"V", "I"}, {"V", "J"},
                {"E", "K"}, {"F", "L"}, {"G", "M"}, {"G", "N"}, {"H", "O"}, {"I", "P"}, {"J", "Q"}
        };

        obj.run(input2, "I", "O", "G");

    }

    public void run(String[][] input, String a, String b, String c){
        list = getList(input);
        System.out.println(list);

        String rsltStr = getTopCategory(input, Arrays.asList(a, b));
        System.out.println(rsltStr);

        int rsltint = getNumberOfSubcategories(input, c);
        System.out.println(rsltint);

    }

    public String getTopCategory(String[][] inputData, List<String> categories){
        List<String> list2 = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            if(str.indexOf(categories.get(0)) != -1){
                if(!list2.contains(str)){
                    list2.add(str);
                }
            }

            if(str.indexOf(categories.get(1)) != -1){
                if(!list2.contains(str)){
                    list2.add(str);
                }
            }

        }

        System.out.println(list2);


        String checkStr = list2.get(0).substring(0,1);
        String rsltStr = "";
        boolean flag = true;
        for(int i=0; ;i++){
            for(int j=0; j<list2.size(); j++){
                if(list2.get(j).startsWith(checkStr)){
                }else{
                    flag = false;
                    break;
                }
            }

            if(!flag) break;
            rsltStr = checkStr;
            checkStr = list2.get(0).substring(0, i+2);
        }



        return rsltStr.substring(rsltStr.length()-1, rsltStr.length());
    }

    public int getNumberOfSubcategories(String[][] inputData, String categoryStr){
        List<String> list2 = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            if(list.get(i).indexOf(categoryStr) != -1){
                categoryStr = list.get(i).substring(list.get(i).indexOf(categoryStr)-1, list.get(i).indexOf(categoryStr));
                break;
            }
        }


        for(int i=0; i<list.size(); i++){
            if(list.get(i).indexOf(categoryStr) != -1){
                if(!list2.contains(list.get(i))){
                    list2.add(list.get(i));
                }
            }
        }

        System.out.println("list2 : " + list2);
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<list2.size(); i++){
            String str = list2.get(i).substring(list2.get(i).indexOf(categoryStr)+1);
            char[] chars = str.toCharArray();
            for(char c : chars){
                set.add(c);
            }
        }


        System.out.println(set);
        return set.size();
    }

    List<String> getList(String[][] input){
        List<String> list = new ArrayList<>();
        String startStr = input[0][0];

        for(int i=0; i<input.length; i++){
            if(startStr.equals(input[i][0])){
                list.add(input[i][0] + input[i][1]);
            }else{

                for(int j=0; j<list.size(); j++){
                    if(list.get(j).indexOf(input[i][0]) != -1){ // 마지막에 포함된다면
                        list.add(list.get(j) + input[i][1]);

                        if(i==input.length-1){
                            list.remove(j);
                        }else{
                            if(!input[i+1][0].equals(input[i][0])){
                                list.remove(j);
                            }
                        }
                        break;
                    }

                }

            }
        }

        return list;
    }

}
