package site.metacoding.ex23;

interface Remocon {
    public abstract void on();

    public abstract void off();
}

class Samsung {

    public void 수리를위한테스트(Remocon r) {
        r.on();
    }
}

public class ArrowEx01 {
    public static void main(String[] args) {
        Samsung s = new Samsung();
        s.수리를위한테스트(new Remocon() {
            @Override
            public void on() {
            }

            @Override
            public void off() {
            }
        });
    }
}
