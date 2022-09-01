package p4;

import backendschool2.p4.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    private static final String INFO = "1.전체리스트  2.등록  0.종료>";
    public static final String INFO_EXIT = "프로그램이 종료되었습니다.";

    private static final Controller controller = new Controller();

    public static void ma채in(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print(INFO);
            String cmd = br.readLine();
            if (cmd.equals("0")) {
                System.out.println(INFO_EXIT);
                break;
            }
            handleCommand(cmd);
        }
    }

    static void handleCommand(String cmd) throws IOException {
        if (cmd.equals("1")) {
            controller.wholeList();
        }

        if (cmd.equals("2")) {
            controller.register();
        }
    }
}
