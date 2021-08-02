package images.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    List<Integer> s = new ArrayList<>();
    List<Integer> k = new ArrayList<>();
    private static p[] p = new p[11];
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int a =scanner.nextInt();
            int b = scanner.nextInt();
            p[i] = new p(a,b);
        }

    }
}

class p {
    int a,b;

    public p(int a, int b) {
        this.a = a;
        this.b = b;
    }
}