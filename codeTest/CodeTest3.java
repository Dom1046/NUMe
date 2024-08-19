package codeTest;

import java.io.IOException;


public class CodeTest3 {
    public int solution(String myString, String pat) {
        return checkIndex(myString,pat);
    }
    public int checkIndex(String myString, String pat) {
        if (myString.toUpperCase().contains(pat.toUpperCase())){
            return 1;
        }else return 0;
    }

    public static void main(String[] args) throws IOException {
        CodeTest3 codeTest3 = new CodeTest3();
        String a = "AbCdEfG";
        String b = "aBc";
        System.out.println("codeTest3.solution(a,b) = " + codeTest3.solution(a, b));
    }
}
