import java.util.Scanner;

public class CodeTest8 {
    //재귀함수 연습문제, 팩토리얼 만들기
    public long dfs(int n) {
        if (n==0) return 1;
        return n*dfs(n-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CodeTest8 test = new CodeTest8();
        int input = scan.nextInt();
        test.dfs(input);
    }
}
