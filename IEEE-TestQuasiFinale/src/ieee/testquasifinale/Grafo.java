package ieee.testquasifinale;

import java.util.ArrayList;
import java.util.Random;

public class Grafo {
    private ArrayList<NodoTensore> nodi;
    private String radice;

    /**
     * Costruttore vuoto
     */
    public Grafo() {
        nodi = new ArrayList<>();
    }
    
    /**
     * Imposta i nodi a dei valori stabiliti
     * @param n, arrayList dei nodi già istanziati e settati
     */
    public void setNodi(ArrayList<NodoTensore> n) {
        nodi = n;
    }
    
    /**
     * Funzione che ritorna un set di matrici estratte casualmente da un sensore
     * di un nodo di un grafo
     * @return ts, ArrayList di matrici
     */
    public ArrayList<Matrice> prendiMatriciAcasoooo() {
        Random r = new Random();
        int i = r.nextInt(nodi.size());
        ArrayList<Tensore> ts = nodi.get(i).getTensori();
        i = r.nextInt(ts.size());
        return ts.get(i).getMatrici();
    }
    
    /**
     * Funzione che calcola e restituisce il valore dell'indice più grande del grafo
     * @return cosoPiuGrande
     */
    public double getIlCosoPiuGrande() {
        double cosoPiuGrande = Integer.MIN_VALUE;
        for(NodoTensore n: nodi) {
            if(n.getUnitaTensore() > cosoPiuGrande)
                cosoPiuGrande = n.getUnitaTensore();
        }
        if(cosoPiuGrande == Integer.MIN_VALUE) cosoPiuGrande = 0;
        return cosoPiuGrande;
    }
    
    /**
     * Ritorna un nodo partendo dal nome di questo
     * @param nome
     * @return
     */
    public NodoTensore trovaNodoDaNome(String nome) {
        for(NodoTensore n: nodi) {
            if(n.getNome().equals(nome))
                return n;
        }
        System.err.println("Il nodo con nome \"" + nome + "\" non è presente nel grafo");
        return null;
    }
}
