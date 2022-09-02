package p2;

public class Program {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (i % 7 == 0 && i % 8 == 0) {             //7의 배수이면서 8의 배수인 경우
                System.out.printf("찾는 정수 : %d",i);     //출력
                return;                                  //종료 해줌으로써 가장 작은 수 하나만 출력하고 멈춘다.
            }
        }
    }
}
