package codeTest;

public class CodeTest9 {
    public int solution(int n) {
        int sum = 0;
        if(n%2==0 ){
            for(int i = 0; i<=n/2; i++){
                sum += (i*2)*(i*2);
            }return sum;
        }
        for(int i = 0; i<=n/2; i++){
            sum += i*2;
        }return ((n+1)*n/2)-sum;
    }

    public static void main(String[] args) {
        int num = 10;
        CodeTest9 test = new CodeTest9();
        System.out.println("test.solution(num) = " + test.solution(num));
    }
}
