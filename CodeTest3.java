import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CodeTest3 {
    static BufferedReader br;

    public int solution(int a, int b) {
        int answer = 0;
        String array1 = a+""+b;
        String array2 = b+""+a;
        return whoBig(array1, array2);
    }
    public int whoBig(String array1,String array2){
        if (array1.equals(array2)){
            return Integer.parseInt(array1);
        }else if (Integer.parseInt(array1)>Integer.parseInt(array2)){
            return Integer.parseInt(array1);
        }else if (Integer.parseInt(array1)<Integer.parseInt(array2)){
            return Integer.parseInt(array2);
        }return -1;
    }

    public static void main(String[] args) throws IOException {
        CodeTest3 codeTest3 = new CodeTest3();
        int a = 12;
        int b = 2;
        System.out.println("codeTest3.solution(a,b) = " + codeTest3.solution(a, b));
    }
}
//"He11oWor1d"	"lloWorl"	2	"HelloWorld"
//"Program29b8UYP"	"merS123"	7	"ProgrammerS123"