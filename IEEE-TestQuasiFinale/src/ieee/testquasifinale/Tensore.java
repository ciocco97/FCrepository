package ieee.testquasifinale;

import java.util.ArrayList;

public class Tensore {
    private ArrayList<Matrice> matrici;
    private int indice;
    
    public Tensore() { matrici = new ArrayList<>(); }
    
    public int calcolaIndice() {
        indice = 0;
            for(Matrice m: matrici) indice += m.calcolaDeterminante();
        return indice;
    }
    
    
    public void addMatrice(Matrice m) {
        matrici.add(m);
        indice = calcolaIndice();
    }
    
}
