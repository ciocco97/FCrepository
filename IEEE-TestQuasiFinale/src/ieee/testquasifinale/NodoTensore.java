package ieee.testquasifinale;

import java.util.ArrayList;

public class NodoTensore {
    private boolean radice;
    private boolean foglia;
    private String nome;
    private ArrayList<Tensore> tensori;
    private ArrayList<Integer> indiciTensori;
    private double unitaTensore;
    private ArrayList<NodoTensore> figli;
    private boolean aperto;

    public NodoTensore() {
        tensori = new ArrayList<>();
        indiciTensori = new ArrayList<>();
        figli = new ArrayList<>();
        aperto = false;
    }

    public NodoTensore(boolean radice, boolean foglia, String nome, ArrayList<Tensore> tensori, ArrayList<Integer> indiciTensori, int unitaTensore, ArrayList<NodoTensore> figli, boolean aperto) {
        this.radice = radice;
        this.foglia = foglia;
        this.nome = nome;
        this.tensori = tensori;
        this.indiciTensori = indiciTensori;
        this.unitaTensore = unitaTensore;
        this.figli = figli;
        this.aperto = aperto;
    }

    public void setTensori(ArrayList<Tensore> tensori) {
        this.tensori = tensori;
    }

    public ArrayList<Tensore> getTensori() {
        return tensori;
    }

    public double getUnitaTensore() {
        for(Tensore t: tensori)
            t.calcolaIndice();
        if(!radice) {
            unitaTensore = Integer.MIN_VALUE;
            for(Tensore t: tensori) {
                if(t.getIndice() > unitaTensore)
                    unitaTensore = t.getIndice();
            }
        } else {
            unitaTensore = Integer.MAX_VALUE;
            for(Tensore t: tensori) {
                if(t.getIndice() < unitaTensore)
                    unitaTensore = t.getIndice();
            }           
        }
        if(unitaTensore == Integer.MAX_VALUE) unitaTensore = 0;
        return unitaTensore;
    }
    
    public void addTensore(Tensore t) {
        tensori.add(t);
    }
    
    public void addFiglio(NodoTensore n) {
        figli.add(n);
    }
    
    public String getNome() {
        return nome;
    }
    
    public void apri() {
        aperto = true;
    }
    
    public void chiudi() {
        aperto = false;
    }
    
    public void setFoglia(boolean b) {
        foglia = b;
    }
    
    public void setRoot(boolean b) {
        radice = b;
    }
    
    public boolean isAperto() {
        return aperto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        String s = "";
        s += nome + " Root: " + radice + " Foglia: " + foglia + " nTensor: " + tensori.size();
        return s;
    }
    
}
