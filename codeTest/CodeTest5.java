package codeTest;

import java.util.stream.IntStream;

public class CodeTest5 {
    public int solution(String my_string, String is_prefix) {
        return IntStream.rangeClosed(0, my_string.length()).
                mapToObj((s) -> my_string.substring(0, s)).anyMatch(s -> s.equals(is_prefix)) ? 1 : 0;
    }


    public static void main(String[] args) {
        String string1 = "banana";
        String string2 = "ban";
        CodeTest5 test = new CodeTest5();
        int result = test.solution(string1, string2);
        System.out.println(result);
    }
}
