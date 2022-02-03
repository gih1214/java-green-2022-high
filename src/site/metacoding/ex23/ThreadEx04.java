package site.metacoding.ex23;

// 익명 클래스를 만들어보자.
// 추상클래스와 인터페이스를 new할 수 없는 이유? => 개념 : 추상적이기 때문
//                                                                         => 문법 : 추상메서드를 가지고 있기 때문
public class ThreadEx04 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> { // {}는 run 타겟
            // 이 부분이 run 메서드 내부
        });

        t1.start();
        System.out.println("메인 스레드 종료");
    } // end of main
}
