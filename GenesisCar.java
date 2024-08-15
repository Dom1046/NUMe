public class GenesisCar{
    private static void say(){
        System.out.println("private static");
    }
    private void say1(){
        System.out.println("private");
        say();
        say2();
    }
    static void say2(){
        System.out.println("---static---");
        say();
    }
}