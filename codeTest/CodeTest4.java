package codeTest;

import java.util.Arrays;

public class CodeTest4 {
    public int[] solution(int[] num_list, int n) {
        int[] array1 = Arrays.copyOfRange(num_list, 0, n );
        int[] array2 = Arrays.copyOfRange(num_list, n, num_list.length);
        for (int i = 0; i < array2.length; i++) {
            num_list[i] = array2[i];
        }
        for (int i = 0; i < array1.length; i++) {
            num_list[array2.length+i] = array1[i];
        }
        return num_list;
    }

    public static void main(String[] args) {
        int[] num_list = {5,2,1,7,5};
        int n = 3;
        CodeTest4 codeTest4 = new CodeTest4();
        int[] array = codeTest4.solution(num_list, n);
    }
}