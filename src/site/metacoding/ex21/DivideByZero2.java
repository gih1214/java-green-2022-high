package site.metacoding.ex21;

import java.util.Scanner;

public class DivideByZero2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // InputMismatchException

        // 통신, 사용자 입력 -> 무조건 예외처리!!

        while (true) {
            try {
                int x = sc.nextInt();
                int result = x / 0;
                System.out.println("받은 값 : " + x);

            } catch (Exception e) {
                System.out.println("================");
                System.out.println(e.getMessage());
                System.out.println("================");
                e.printStackTrace();
                sc.nextLine(); // 버퍼 비워!!
            }
        }
    }
}