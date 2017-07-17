package ieee.testquasifinale;

import java.util.ArrayList;

public class Grafo {
    private ArrayList<NodoTensore> nodi;
    private String radice;
    
    public boolean addNodo() {
        boolean fatto = true;
        
        return fatto;
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
