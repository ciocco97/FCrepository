package ieee.testquasifinale;

import java.util.ArrayList;

public class Tensore {
    private ArrayList<Matrice> matrici;
    private double indice;
    
    /**
     * Costruttore vuoto
     */
    public Tensore() { matrici = new ArrayList<>(); }
    
    /**
     * Calcola la somma dei determinanti delle matrici quadrate 
     * @return indice
     */
    public double calcolaIndice() {
        indice = 0;
            for(Matrice m: matrici) indice += m.calcolaDeterminante();
        return indice;
    }

    /**
     * Ritorna l'ArrayList delle matrici
     * @return matrici
     */
    public ArrayList<Matrice> getMatrici() {
        return matrici;
    }

    /**
     * Ritorna l'indice che deve essere già stato calcolato
     * @return indice
     */
    public double getIndice() {
        return indice;
    }
    
    /**
     * Aggiunge una matrice alle matrici del tensore
     * @param m, matrice da aggiungere
     */
    public void addMatrice(Matrice m) {
        matrici.add(m);
    }
    
}
