import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodeTest6 {
    public int solution(String my_string, String is_suffix) {
        return IntStream.rangeClosed(0, my_string.length()).mapToObj(s-> my_string.substring(my_string.length()-s,my_string.length())).anyMatch(s->s.equals(is_suffix))? 1:0;
    }
    public int solution1(String my_string, String is_suffix) {
        return my_string.endsWith(is_suffix)? 1:0;
    }
    public static void main(String[] args) {
        String string1 = "banana";
        String string2 = "ana";
        CodeTest5 test = new CodeTest5();
        int result = test.solution(string1, string2);
        System.out.println(result);
    }
}
