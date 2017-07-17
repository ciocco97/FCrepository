package myutil;

public class SuperTimer {
    private long inizio;

    public SuperTimer() {
        this.inizio = System.nanoTime();
    }

    public long getTempuscolo() {
        return System.nanoTime() - inizio;
    }
    
    
}
