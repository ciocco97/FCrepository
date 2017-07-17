package myutil;

import ieee.testquasifinale.Grafo;
import ieee.testquasifinale.Matrice;
import ieee.testquasifinale.NodoTensore;
import ieee.testquasifinale.Tensore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class MyUtil {
    private static Grafo g;
    
    public static Grafo getGrafoDaXML(String fileName) throws FileNotFoundException, XMLStreamException {
        File file = new File(fileName);
        if(!file.exists()) {
            System.err.println("Il file" + fileName + " non esiste");
            return null;
        }
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));
        ArrayList<NodoTensore> nodi = new ArrayList<>();
        NodoTensore nTemp = null;
        NodoTensore root = null;
        Matrice mTemp = null;
        Tensore tTemp = null;
        int[][] vTemp = null;
        int i = -1, j = -1;
        String dati = "";
        ArrayList<Tensore> tensori = null;
        while(reader.hasNext() || root == null) {
            int type = 0;
            try {
                type = reader.next();
            } catch (XMLStreamException ex) {
                System.err.println("Il file è vuoto" + ex.getMessage());
            }
            
            switch(type) {
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("Inizio Documento...");
                    break;
                    
                case XMLStreamConstants.START_ELEMENT:
                    if("TTree".equals(reader.getLocalName()))
                        g = new Grafo();
                    else if("TensorNode".equals(reader.getLocalName())) {
                        if(nTemp == null)
                            nTemp = new NodoTensore();
                        else {
                            if(nodi.isEmpty()) {
                                nTemp.setRoot(true);
                                nodi.add(nTemp);
                                root = nTemp;
                            }
                            else {
                                int indice = -1;
                                for(int c = nodi.size() - 1; c >= 0 && indice == -1; c--) {
                                    if(nodi.get(c).isAperto())
                                        indice = c;
                                }
                                if(indice != -1)
                                    nodi.get(indice).addFiglio(nTemp);
                                nodi.add(nTemp);
                            }
                            nTemp = new NodoTensore();
                            nTemp.apri();
                        }
                    }
                    else if("tensor".equals(reader.getLocalName()))
                        tTemp = new Tensore();
                    else if("matrix".equals(reader.getLocalName())) {
                        mTemp = new Matrice(1);
                        i = 0; j = 0;
                    }
                    break;
                
                case XMLStreamConstants.CHARACTERS:
                    dati = reader.getText();
                    break;
                    
                case XMLStreamConstants.END_ELEMENT:
                    if("label".equals(reader.getLocalName()))
                        nTemp.setNome(dati);
                    if("column".equals(reader.getLocalName())){
                        mTemp.addVal(Integer.parseInt(dati), i, j);
                        j ++;
                    } 
                    else if("row".equals(reader.getLocalName())){
                        j = 0; i++;
                    } 
                    else if("matrix".equals(reader.getLocalName())) {
                        tTemp.addMatrice(mTemp);
                    }
                    else if("tensor".equals(reader.getLocalName())) {
                        nTemp.addTensore(tTemp);
                    }
                    else if("TensorNode".equals(reader.getLocalName())) {
                        if(nTemp.isAperto()) {
                            nTemp.chiudi();
                            nTemp.setFoglia(true);
                        }
                        else {
                            int indice = -1;
                                for(int c = nodi.size() - 1; c >= 0 && indice == -1; c--) {
                                    if(nodi.get(c).isAperto())
                                        indice = c;
                                }
                                if(indice != -1) {
                                    nodi.get(indice).chiudi();
                                }
                        }
                    }
                    else if("TTree".equals(reader.getLocalName()))
                        g = new Grafo();
                    break;
                        
            }
            
            funzioneTroppoPowaPerComuniMortali(); 
        }
        for(int k = 0; k < nodi.size(); k++) {
            System.out.println(nodi.get(k).toString());
        }
        return g;
    }

    private static NodoTensore funzioneTroppoPowaPerComuniMortali() {
        return null;
    }
}
