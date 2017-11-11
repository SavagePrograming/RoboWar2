public class ArenaControler extends Thread {

    final int SPEED_DEFAULT = 1;

    private boolean On;
    private boolean Run;
    private boolean Step;
    private int speed = SPEED_DEFAULT;
    private Arena arena;

    public ArenaControler(Arena a){
        this.arena = a;
    }

    @Override
    public void run() {
        Run = false;
        On = true;

        while (On){
            if (Step){
                Step = false;
                this.arena.update();
            }else if (Run){
                this.arena.update();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void turnOff(){
        Run = false;
    }

    public void turnOnOff(){
        Run = !Run;
    }

    public void turnOn(){
        Run = true;
    }

    public void step(){
        Step = true;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
