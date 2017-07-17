package ieee.testquasifinale;

import static java.lang.Math.pow;

public class Matrice {
    private int DIM;
    private double[][] valori;
    
    /**
     * Costruttore con parametro
     * @param DIMENSIONE, la dimensione della matrice
     */
    public Matrice(int DIMENSIONE) {
        this.DIM = DIMENSIONE;
        valori = new double[DIMENSIONE][DIMENSIONE];
        setAtZero();
    }
    
    /**
     * Costruttore con paramentro tutti i valori della matrice
     * @param valori, array di dimensione due che corrisponde ai valori della matrice
     */
    public Matrice(double[][] valori) {
        this.valori = valori;
        DIM = valori.length;
    }
    
    /**
     * Azzera tutti i valori della matrice
     */
    private void setAtZero() {
        for(int i = 0; i < DIM; i++)
            for(int j = 0; j < DIM; j++)
                valori[i][j] = 0;
    }
    
    /**
     * Aggiunge un valore a determinate riga e colonna; se queste rappresentassero
     * valori superiori alla dimensione della matrice, verrà creata una nuova matrice
     * con dimensione pari a max(row, col)
     * @param valore, valore da aggiungere
     * @param col, colonna della matrice
     * @param row, riga della matrice
     */
    public void addVal(double valore, int col, int row) {
        if(col < DIM && row < DIM)
            valori[col][row] = valore;
        else {
            int max = Integer.max(col, row);
            max ++;
            double[][] newVal = new double[max][max];
            
            for(int i = 0; i < max; i++)
                for(int j = 0; j < DIM; j++)
                    newVal[i][j] = 0;
            
            for(int i = 0; i < DIM; i++)
                for(int j = 0; j < DIM; j++)
                    newVal[i][j] = valori[i][j];
            newVal[col][row] = valore;
            DIM = max;
            valori = newVal;
        }
    }
    
    /**
     * Ritorna il valore del determinante calcolato esclusivamente con Laplace
     * @return determinante
     */
    public double calcolaDeterminante() {
        double determinante = 0;
        if(DIM != valori[0].length) {
            System.err.println("Il determinante non può essere calcolato");
        } else {
            if(DIM == 1) determinante = valori[0][0];
            else determinante = laplace();
        }
        return determinante;
    }
    
    /**
     * Calcola il determinante utilizzando sarrus per matrici di dimensione 3
     * @return determinante
     */
    public double calcolaDeterminanteConSarrus() {
        double determinante = 0;
        if(DIM != valori[0].length) {
            System.err.println("Il determinante non può essere calcolato");
        } else {
            switch (DIM) {
                case 1:
                    return valori[0][0];
                case 2:
                    return (valori[0][0] * valori[1][1]) + (valori[0][1] * valori[1][0]);
                case 3:
                    return sarrus();
                default:
                    determinante = laplace();
                    break;
            }
        }
        return determinante;
    }
    
    /**
     * Ritorna una matrice di ordine DIM - 1 senza le riga e colonna scelte
     * @param riga, riga da eliminare
     * @param colonna, colonna da eliminare
     * @return new Matrice(...), la nuova matrice senza riga e colonna selezionate
     */
    public Matrice rimuoviRigaColonna(int riga, int colonna) {
        if(DIM == 1) System.err.println("Impossibile rimuovere riga e colonna");
        double[][] nuoviValori = new double[DIM - 1][DIM - 1];
        
        boolean rigaTrovata = false;
        boolean colonnaTrovata;
        for(int i = 0; i < DIM; i++) {
            if(i == riga) { rigaTrovata = true; i++; }
            colonnaTrovata = false;
            for(int j = 0; j < DIM; j++) {
                if(j == colonna) { colonnaTrovata = true; j++; }
                if(j < DIM && i < DIM) {
                    if(colonnaTrovata && rigaTrovata){
                        nuoviValori[i - 1][j - 1] = valori[i][j];
                    }
                    else if(rigaTrovata)
                        nuoviValori[i - 1][j] = valori[i][j];
                    else if(colonnaTrovata)
                        nuoviValori[i][j - 1] = valori[i][j];
                    else
                        nuoviValori[i][j] = valori[i][j];
                }
            }
        }
        return new Matrice(nuoviValori);
    }
    
    /**
     * Calcola il determinante delle matrici di dimensione 3 
     * @return ritorno, il determinante della matrice
     */
    public double sarrus() {
        double ritorno = 0;
        ritorno = 
            valori[0][0]*valori[1][1]*valori[2][2] +
            valori[0][1]*valori[1][2]*valori[2][0] +
            valori[0][2]*valori[1][0]*valori[2][1] -
            valori[2][0]*valori[1][1]*valori[0][2] -
            valori[2][1]*valori[1][2]*valori[0][0] -
            valori[2][2]*valori[1][0]*valori[0][1];
        return ritorno;
    }
    
    /**
     * Funzione ricorsiva per il calcolo del determinanete delle matrici di dimensione
     * superiore a 3
     * @return
     */
    public int laplace() {
        int ritorno = 0;
        for(int i = 0, j = 0; i < DIM; i++) {
            Matrice matriceTemp = this.rimuoviRigaColonna(i, j);
            ritorno += pow(-1, i+j) * valori[i][j] * matriceTemp.calcolaDeterminante();
        }
        return ritorno;
    }
    
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < DIM; i++) {
            for(int j = 0; j < DIM; j++)
                s += valori[i][j] + " ";
            s += "\n";
        }
        return s.trim();
    }
}
