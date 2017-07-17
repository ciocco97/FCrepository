package ieee.testquasifinale;

import java.util.ArrayList;

public class Tensore {
    private ArrayList<Matrice> matrici;
    private double indice;
    
    public Tensore() { matrici = new ArrayList<>(); }
    
    public double calcolaIndice() {
        indice = 0;
            for(Matrice m: matrici) indice += m.calcolaDeterminante();
        return indice;
    }

    public ArrayList<Matrice> getMatrici() {
        return matrici;
    }

    public double getIndice() {
        return indice;
    }
    
    public void addMatrice(Matrice m) {
        matrici.add(m);
    }
    
}
