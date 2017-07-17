package ieee.testquasifinale;

import static java.lang.Math.pow;

public class Matrice {
    private int DIM;
    private double[][] valori;
    
    public Matrice(int DIMENSIONE) {
        this.DIM = DIMENSIONE;
        valori = new double[DIMENSIONE][DIMENSIONE];
        setAtZero();
    }
    
    public Matrice(double[][] valori) {
        this.valori = valori;
        DIM = valori.length;
    }
    
    private void setAtZero() {
        for(int i = 0; i < DIM; i++)
            for(int j = 0; j < DIM; j++)
                valori[i][j] = 0;
    }
    
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
