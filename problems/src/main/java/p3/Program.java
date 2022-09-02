package p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    public static final String INPUT_MONEY = "금액을 넣으세요 : ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cash = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10}; //화폐를 담은 배열
        int[] result = new int[cash.length];                                //결과를 담을 배열

        System.out.print(INPUT_MONEY);
        int cost = Integer.parseInt(br.readLine());     //금액 입력받기

        for (int i = 0; i < cash.length; i++) {     //화폐 배열에 대해 큰 순서대로
            if (cash[i] <= cost) {      //금액이 화폐보다 큰 경우
                result[i] = cost / cash[i];     //결과 배열에 금액을 화폐로 나눈 몫 저장
                cost %= cash[i];                //금액은 화폐로 나눈 나머지가 된다.
            }
        }

        for (int i = 0; i < cash.length; i++) {         //결과 출력
            System.out.printf("%d원 %d개\n",cash[i],result[i]);
        }
    }
}
