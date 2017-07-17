package ieee.testquasifinale;

import java.util.ArrayList;

public class NodoTensore {
    private boolean radice;
    private boolean foglia;
    private String nome;
    private ArrayList<Tensore> tensori;
    private ArrayList<Integer> indiciTensori;
    private int unitaTensore;
    private ArrayList<NodoTensore> figli;
    private boolean aperto;

    public NodoTensore() {
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
    
    
    
    public String getNome() {
        return nome;
    }
    
}
