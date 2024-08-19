package codeTest;

public class Review {
    int times= 1;
    int count = 0;
    int sum = 0;
    public int solution(String[][] clothes) {
//        String[][] clothes = new String[n][m];
        for (int i = 0; i < clothes.length; i++) {
            sum += clothes[i].length;
            for (int j = 0; j < clothes.length; j++) {
                if ((i != j) && (j > i)) {
                    times *= clothes[j].length;
                }
            }
        }
        return -1;
    }

    public int volution(String[][] clothes) {
        if (clothes.length == 0) {
            return count = 1;
        }
        int x = 0;
        for (int j = 0; j < clothes.length; j++) {
            if ((x != j) && (j > x)) {
                sum += clothes[x].length * clothes[j].length;
                x++;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Review review = new Review();

    }
}
