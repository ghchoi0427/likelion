package p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    public static final String INPUT_MONEY = "금액을 넣으세요 : ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cash = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int[] result = new int[cash.length];

        System.out.print(INPUT_MONEY);
        int cost = Integer.parseInt(br.readLine());

        for (int i = 0; i < cash.length; i++) {
            if (cash[i] <= cost) {
                result[i] = cost / cash[i];
                cost %= cash[i];
            }
        }

        for (int i = 0; i < cash.length; i++) {
            System.out.printf("%d원 %d개\n",cash[i],result[i]);
        }
    }
}
