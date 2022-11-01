package ca.bytetube._03_recursion;

public class PrintAllSubString {
    public static void main(String[] args) {
        PrintAllSubString("abcd");
    }

    public static void PrintAllSubString(String s){
//        test(s, 0, true, new boolean[s.length()]);
//        test(s, 0, false, new boolean[s.length()]);
          PrintAllSubString(s,0,new String());

    }
                                            //abc      0        ""
    private static void PrintAllSubString(String s,int index, String res){
        if (index == s.length()) {
            System.out.println(res);
            return;
        }
        PrintAllSubString(s,index + 1,res);
        PrintAllSubString(s,index + 1,res + s.charAt(index));
    }


                                //abc
//    private static void test(String s, int index, boolean isSelected, boolean[] selected){
//        //memory[pointer] = want;
//        if (s.length() == index+1) {
//            selected[index] = isSelected;
//            printArray(s,selected);
//            return;
//        }
//        selected[index] = isSelected;
//        test(s,index+1,true, selected);
//        test(s,index+1,false, selected);
//    }
//
//    private static void printArray(String s, boolean[] selected) {
//        for (int i = 0; i < s.length(); i++) {
//            if (selected[i] == true) System.out.print(s.substring(i,i+1) + " ");
//        }
//        System.out.println();
//    }

}
