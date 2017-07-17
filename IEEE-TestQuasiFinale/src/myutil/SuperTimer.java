package myutil;

public class SuperTimer {
    private long inizio;

    public SuperTimer(long inizio) {
        this.inizio = System.currentTimeMillis();
    }

    public long getTempuscolo() {
        return System.currentTimeMillis() - inizio;
    }
    
    
}
