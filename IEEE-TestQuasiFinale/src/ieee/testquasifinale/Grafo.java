package ieee.testquasifinale;

import java.util.ArrayList;
import java.util.Random;

public class Grafo {
    private ArrayList<NodoTensore> nodi;
    private String radice;

    public Grafo() {
        nodi = new ArrayList<>();
    }
    
    public void setNodi(ArrayList<NodoTensore> n) {
        nodi = n;
    }
    
    public ArrayList<Matrice> prendiMatriciAcasoooo() {
        Random r = new Random();
        int i = r.nextInt(nodi.size());
        ArrayList<Tensore> ts = nodi.get(i).getTensori();
        i = r.nextInt(ts.size());
        return ts.get(i).getMatrici();
    }
    
    public double getIlCosoPiuGrande() {
        double cosoPiuGrande = Integer.MIN_VALUE;
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
