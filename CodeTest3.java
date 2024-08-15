import java.io.BufferedReader;
import java.io.IOException;


public class CodeTest3 {
    static BufferedReader br;

    public String solution(String str1, String str2) {
        String answer = "";
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        for(int i = 0; i <array1.length; i++){
            answer = answer + array1[i]+array2[i];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        CodeTest3 codeTest3 = new CodeTest3();
        String array1 = "aaaa";
        String array2 = "bbbb";
        System.out.println("codeTest3.solution(array1, array2) = " + codeTest3.solution(array1, array2));
    }
}
//"He11oWor1d"	"lloWorl"	2	"HelloWorld"
//"Program29b8UYP"	"merS123"	7	"ProgrammerS123"