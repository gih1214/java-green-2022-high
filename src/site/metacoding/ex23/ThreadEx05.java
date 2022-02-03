package site.metacoding.ex23;

class Monster implements Runnable {
    int x = 10;
    int speed = 1; // 1초마다
    boolean isActive = true;

    @Override
    public void run() { // 몬스터의 실 (타겟)
        while (isActive) {
            try {
                x = x + speed;
                Thread.sleep(1000);
                System.out.println("몬스터의 x좌표 : " + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Host implements Runnable {
    int x = 0;
    int speed = 2; // 1초마다
    boolean isActive = true;

    @Override
    public void run() {
        while (isActive) {
            x = x + speed;
            try {
                Thread.sleep(1000);
                System.out.println("호스트의 x좌표 : " + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 실습 -> Monster와 Host는 1초마다 각자의 speed 만큼 움직이는 run()을 가진다.
// -> 둘의 x좌표가 동일해지면 게임은 종료된다.

public class ThreadEx05 {
    public static void main(String[] args) {
        Monster monster = new Monster();
        Thread monsterThread = new Thread(monster); // 몬스터 실
        monsterThread.start();

        Host host = new Host();
        Thread hostThread = new Thread(host); // 호스트 실
        hostThread.start();

        while (true) {
            if (host.x >= monster.x) {
                System.out.println("몬스터가 죽었습니다. 게임이 종료됩니다.");
                // 1. 몬스터 종료
                monster.isActive = false;
                // 2. 호스트 종료
                host.isActive = false;
                // 3. 메인종료
                break;
            } else {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}