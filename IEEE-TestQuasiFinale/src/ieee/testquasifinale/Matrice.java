package ieee.testquasifinale;

import static java.lang.Math.pow;

public class Matrice {
    private int DIM;
    private int[][] valori;
    
    public Matrice(int DIMENSIONE) {
        this.DIM = DIMENSIONE;
        valori = new int[DIMENSIONE][DIMENSIONE];
        setAtZero();
    }
    
    public Matrice(int[][] valori) {
        this.valori = valori;
        DIM = valori.length;
    }
    
    private void setAtZero() {
        for(int i = 0; i < DIM; i++)
            for(int j = 0; j < DIM; j++)
                valori[i][j] = 0;
    }
    
    public void addVal(int valore, int col, int row) {
        if(col < DIM && row < DIM)
            valori[col][row] = valore;
        else {
            int max = Integer.max(col, row);
            int[][] newVal = new int[max][max];
            setAtZero();
            
            for(int i = 0; i < DIM; i++)
                for(int j = 0; j < DIM; j++)
                    newVal[i][j] = valori[i][j];
            newVal[col][row] = valore;
            valori = newVal;
        }
    }
    
    public int calcolaDeterminante() {
        int determinante = 0;
        if(DIM != valori[0].length) {
            System.err.println("Il determinante non può essere calcolato");
        } else {
            if(DIM < 4) determinante = sarrus();
            else determinante = laplace();
        }
        return determinante;
    }
    
    public Matrice rimuoviRigaColonna(int riga, int colonna) {
        int[][] nuoviValori = new int[DIM][DIM];
        boolean rigaTrovata = false;
        boolean colonnaTrovata = false;
        for(int i = 0; i < DIM - 1; i++) {
            if(i == riga) { rigaTrovata = true; i++; }
            colonnaTrovata = false;
            for(int j = 0; j < DIM - 1; j++) {
                if(j == colonna) { colonnaTrovata = true; j++; }
                if(colonnaTrovata && rigaTrovata)
                    nuoviValori[i - 1][j - 1] = valori[i][j];
                else if(rigaTrovata)
                    nuoviValori[i - 1][j] = valori[i][j];
                else if(colonnaTrovata)
                    nuoviValori[i][j - 1] = valori[i][j];
                else
                    nuoviValori[i][j] = valori[i][j];
            }
        }
        return new Matrice(nuoviValori);
    }
    
    public int sarrus() {
        int ritorno = 0;
        switch (DIM) {
            case 1:
                ritorno = valori[0][0];
                break;
            case 2:
                ritorno = (valori[0][0] + valori[1][1]) * (valori[0][1] + valori[1][0]);
                break;
            case 3:
                ritorno = 
                    valori[0][0]*valori[1][1]*valori[2][2] +
                    valori[0][1]*valori[1][2]*valori[2][0] +
                    valori[0][2]*valori[1][0]*valori[2][1] -
                    valori[2][0]*valori[1][1]*valori[0][2] -
                    valori[2][1]*valori[1][2]*valori[0][0] -
                    valori[2][2]*valori[1][0]*valori[0][1];
                break;
        }
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
}
