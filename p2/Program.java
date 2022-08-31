package backendschool2.p2;

public class Program {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (i % 7 == 0 && i % 8 == 0) {
                System.out.printf("찾는 정수 : %d",i);
                break;
            }
        }
    }
}
