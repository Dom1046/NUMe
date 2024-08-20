package dfs;

public class SplitResearch {
    public static void main(String[] args) {
        String str = "asdf asdfzcviou asdfwen,fsdoi";
        String[] result = str.split("!");
        for(String re: result){
            System.out.println(re);
        }
    }
}
