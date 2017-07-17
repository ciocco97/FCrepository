package ieee.testquasifinale;

import java.util.ArrayList;

public class Grafo {
    private ArrayList<NodoTensore> nodi;
    private String radice;

    public Grafo() {
        nodi = new ArrayList<>();
    }
    
    public void setNodi(ArrayList<NodoTensore> n) {
        nodi = n;
    }
    
    public int getIlCosoPiuGrande() {
        int cosoPiuGrande = Integer.MIN_VALUE;
        for(NodoTensore n: nodi) {
            if(n.getUnitaTensore() > cosoPiuGrande)
                cosoPiuGrande = n.getUnitaTensore();
        }
        if(cosoPiuGrande == Integer.MIN_VALUE) cosoPiuGrande = 0;
        return cosoPiuGrande;
    }
    
    public NodoTensore trovaNodoDaNome(String nome) {
        for(NodoTensore n: nodi) {
            if(n.getNome().equals(nome))
                return n;
        }
        System.err.println("Il nodo con nome \"" + nome + "\" non è presente nel grafo");
        return null;
    }
}
