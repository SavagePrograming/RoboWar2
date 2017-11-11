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
                waitTillReady();
            }else if (Run){
                this.arena.update();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                waitTillReady();
            }

        }
    }

    public synchronized void waitTillReady(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void wakeOthers(){
        notifyAll();
    }

    public synchronized void turnOff(){
        Run = false;
        notifyAll();
    }

    public synchronized void turnOnOff(){
        Run = !Run;
        notifyAll();
    }

    public synchronized void turnOn(){
        Run = true;
        notifyAll();
    }

    public synchronized void step(){
        Step = true;
        notifyAll();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public synchronized void exit(){
        On = false;
        notifyAll();
    }
}
