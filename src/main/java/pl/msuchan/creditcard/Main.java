package pl.msuchan.creditcard;
public class Main {
    public static void main(String[] args) {
        String name = "Mikołaj";
        greeting(name);
    }


    static void greeting(String name) {
        var hello = String.format("Hello %s", name);
        System.out.println(hello);
    }
}