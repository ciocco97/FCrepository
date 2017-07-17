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
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class MyUtil {
    public static Grafo getGrafoDaXML(String fileName) throws FileNotFoundException, XMLStreamException {
        File file = new File(fileName);
        if(!file.exists()) {
            System.err.println("Il file" + fileName + " non esiste");
            return null;
        }
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));
        NodoTensore nTemporaneo = null;
        Matrice mTemporanea = null;
        String dati;
        ArrayList<Tensore> tensori = new ArrayList<>();
        while(reader.hasNext()) {
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
                    if("tree".equals(lettore.getLocalName()))
            }
            
            funzioneTroppoPowaPerComuniMortali(); 
        }
        
    }

    private static void funzioneTroppoPowaPerComuniMortali() {
        
    }
}
