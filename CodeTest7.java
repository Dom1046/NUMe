public class CodeTest7 {
    public String solution(String my_string, int n) {
        return isChech(my_string, n);
    }

    private String isChech(String a, int b) {
        char[] charArray = a.toCharArray();
        String container = "";
        for (int i = 0; i < b; i++) {
            container += charArray[charArray.length - b + i];

        }
        return null;
    }
    public static void main(String[] args) {
        String string1 = "banana";
        CodeTest7 test = new CodeTest7();
        String result = test.solution(string1, 3);
        System.out.println(result);
    }
}
