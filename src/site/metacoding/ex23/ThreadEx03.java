package site.metacoding.ex23;

// 익명 클래스를 만들어보자.
// 추상클래스와 인터페이스를 new할 수 없는 이유? => 개념 : 추상적이기 때문
//                                                                         => 문법 : 추상메서드를 가지고 있기 때문
public class ThreadEx03 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i < 6; i++) {
                    try {
                        System.out.println("새로운 스레드 : " + i);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        System.out.println("메인 스레드 종료");
    }
}
