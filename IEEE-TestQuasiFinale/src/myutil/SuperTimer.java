package myutil;

public class SuperTimer {
    private long inizio;

    /**
     * Costruttore
     */
    public SuperTimer() {
        this.inizio = System.nanoTime();
    }

    /**
     * Il tempo trascorso dall'istanza
     * @return
     */
    public long getTempuscolo() {
        return System.nanoTime() - inizio;
    }
    
    
}
