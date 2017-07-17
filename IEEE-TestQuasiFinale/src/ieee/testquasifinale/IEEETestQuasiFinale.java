package ieee.testquasifinale;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import myutil.MyUtil;
import myutil.SuperTimer;

public class IEEETestQuasiFinale {

    public static void main(String[] args) {
        Grafo g = null;
        try {
            g = MyUtil.getGrafoDaXML("input_0.xml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IEEETestQuasiFinale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(IEEETestQuasiFinale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(g.getIlCosoPiuGrande());
        
        System.out.println("Prova tempo straPowa");
        System.out.println("Con Laplace");
        ArrayList<Matrice> ms = g.prendiMatriciAcasoooo();
        long somma = 0;
        SuperTimer st = new SuperTimer();
        for(Matrice m: ms)
            somma += m.calcolaDeterminante();
        long tempuscolo = st.getTempuscolo();
        System.out.println("Tempuscolo: " + tempuscolo + " Somma: " + somma);
        System.out.println("Con Sarrus");
        somma = 0;
        st = new SuperTimer();
        for(Matrice m: ms)
            somma += m.calcolaDeterminante();
        tempuscolo = st.getTempuscolo();
        System.out.println("Tempuscolo: " + tempuscolo + " Somma: " + somma);
        
    }
    
}
