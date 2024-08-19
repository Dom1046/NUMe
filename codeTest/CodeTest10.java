package codeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeTest10 {
    public List<Integer> solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length-1; i >= 0; i--) {
            if (i != 0) {
                if (arr[i] != arr[i-1]) {
                    list.add(arr[i]);
                }
            } else {
                list.add(arr[i]);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
