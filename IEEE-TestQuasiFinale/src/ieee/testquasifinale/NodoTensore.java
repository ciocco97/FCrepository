package ieee.testquasifinale;

import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class NodoTensore {
    private boolean radice;
    private boolean foglia;
    private String nome;
    private ArrayList<Tensore> tensori;
    private ArrayList<Integer> indiciTensori;
    private double unitaTensore;
    private ArrayList<NodoTensore> figli;
    private boolean aperto;

    /**
     * Costruttore vuoto
     */
    public NodoTensore() {
        tensori = new ArrayList<>();
        indiciTensori = new ArrayList<>();
        figli = new ArrayList<>();
        aperto = false;
    }

    /**
     * Costruttore con parametri
     * @param radice
     * @param foglia
     * @param nome
     * @param tensori
     * @param indiciTensori
     * @param unitaTensore
     * @param figli
     * @param aperto
     */
    public NodoTensore(boolean radice, boolean foglia, String nome, ArrayList<Tensore> tensori, ArrayList<Integer> indiciTensori, int unitaTensore, ArrayList<NodoTensore> figli, boolean aperto) {
        this.radice = radice;
        this.foglia = foglia;
        this.nome = nome;
        this.tensori = tensori;
        this.indiciTensori = indiciTensori;
        this.unitaTensore = unitaTensore;
        this.figli = figli;
        this.aperto = aperto;
    }

    /**
     * Imposta i tensori a dei valori prestabiliti
     * @param tensori
     */
    public void setTensori(ArrayList<Tensore> tensori) {
        this.tensori = tensori;
    }

    /**
     * Ritorna un ArrayList di tensori
     * @return tensori
     */
    public ArrayList<Tensore> getTensori() {
        return tensori;
    }

    /**
     * Dopo aver calcolato l'indice di ogni tensore, se il nodo preso in considerazione
     * è una radice, ritorna il valore di indice più basso mentre se è un nodo standard
     * verrà ritornato l'indice con valore più alto
     * @return unitaSensore
     */
    public double getUnitaTensore() {
        for(Tensore t: tensori)
            t.calcolaIndice();
        if(!radice) {
            unitaTensore = Integer.MIN_VALUE;
            for(Tensore t: tensori) {
                if(t.getIndice() > unitaTensore)
                    unitaTensore = t.getIndice();
            }
        } else {
            unitaTensore = Integer.MAX_VALUE;
            for(Tensore t: tensori) {
                if(t.getIndice() < unitaTensore)
                    unitaTensore = t.getIndice();
            }           
        }
        if(unitaTensore == Integer.MAX_VALUE) unitaTensore = 0;
        return unitaTensore;
    }
    
    /**
     * Aggiunge un Tensore alla lista dei tensori
     * @param t, il tensore da aggiungere
     */
    public void addTensore(Tensore t) {
        tensori.add(t);
    }
    
    /**
     * Aggiunge un NodoTensore alla lista dei figli del nodo
     * @param n, il NodoTensore da aggiungere alla lista di figli
     */
    public void addFiglio(NodoTensore n) {
        figli.add(n);
    }
    
    /**
     * Ritorna il nome del nodo
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Imposta lo stato del nodo come "aperto" (Utile in "getDaXML")
     */
    public void apri() {
        aperto = true;
    }
    
    /**
     *Imposta lo stato del nodo come "chiuso"
     */
    public void chiudi() {
        aperto = false;
    }
    
    /**
     * Indica se il nodo è una foglia o no
     * @param b, flag che indica se il nodo è una foglia
     */
    public void setFoglia(boolean b) {
        foglia = b;
    }
    
    /**
     * Indica se il nodo è la radice del grafo
     * @param b, flag che indica se il nodo è la radice
     */
    public void setRoot(boolean b) {
        radice = b;
    }
    
    public boolean isAperto() {
        return aperto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        String s = "";
        s += nome + " Root: " + radice + " Foglia: " + foglia + " nTensor: " + tensori.size();
        return s;
    }
    
}
