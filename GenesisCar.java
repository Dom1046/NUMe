import java.util.*;

public class GenesisCar {

    public int solution(String[][] string) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] str : string) {
            String type = str[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        int sum = 1;
        var iter = map.values().iterator();
        while (iter.hasNext()) {
            sum *= iter.next();
        }
        return sum - 1;
    }

    public static void main(String[] args) {
        String[][] sss = {{"A", "B"}, {"I", "J"}, {"K", "L"}, {"M", "N"}};
        GenesisCar gc = new GenesisCar();
        System.out.println("gc.solution(sss) = " + gc.solution(sss));
    }
}
//{"E","F","G","H"},