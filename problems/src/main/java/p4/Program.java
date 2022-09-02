package p4;

import p4.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    private static final String INFO = "1.전체리스트  2.등록  0.종료>";
    public static final String INFO_EXIT = "프로그램이 종료되었습니다.";

    private static final Controller controller = new Controller();
    public static final String COMMAND_EXIT = "0";
    public static final String COMMAND_LIST = "1";
    public static final String COMMAND_REGISTER = "2";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print(INFO);             //안내 메시지를 출력한다.
            String cmd = br.readLine();         //명령어를 입력받는다.
            if (cmd.equals(COMMAND_EXIT)) {     //종료 명령어를 입력받을 경우
                System.out.println(INFO_EXIT);  //종료 메시지를 출력하고
                return;                         //리턴한다.
            }
            handleCommand(cmd);                 //명령어를 처리한다.
        }
    }

    static void handleCommand(String cmd) throws IOException {      //명령어 처리를 담당하는 메서드
        if (cmd.equals(COMMAND_LIST)) {     //조회 명령어를 입력받을 경우
            controller.wholeList();         //컨트롤러 조회 메서드를 실행한다.
        }

        if (cmd.equals(COMMAND_REGISTER)) { //등록 명령어를 입력받을 경우
            controller.register();          //컨트롤러 등록 메서드를 실행한다.
        }
    }
}
