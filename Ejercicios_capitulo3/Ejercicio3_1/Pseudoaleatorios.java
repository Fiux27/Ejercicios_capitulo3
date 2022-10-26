import java.util.Random;

public class Pseudoaleatorios {    
    public static void main(String[] args){

        int a = 12;
        int b = 5;
        int n = 100;
        int cur = 92;
        int next = 0;

        for(int i = 0; i < 5; i++){

            next = (a * cur + b) % n;

            System.out.println(next);
            cur = next;
        }
    }
}
