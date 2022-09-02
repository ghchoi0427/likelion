package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    public static final String INPUT_RADIUS = "반지름을 입력하세요 : ";
    public static final String AREA_RESULT = "반지름의 넓이는 : ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(INPUT_RADIUS);                 //안내 메시지 출력
        int radius = Integer.parseInt(br.readLine());   // 반지름 입력
        double area = Math.pow(radius, 2) * Math.PI;    // (넓이) = (반지름)^2 * pi
        System.out.printf(AREA_RESULT + area);          //결과 출력
    }
}
