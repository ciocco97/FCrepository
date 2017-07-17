package ieee.testquasifinale;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import myutil.MyUtil;

public class IEEETestQuasiFinale {

    public static void main(String[] args) {
        
        Matrice m = new Matrice(2);
        m.addVal(2, 0, 0);
        m.addVal(1, 1, 0);
        System.out.println(m.toString());
        System.out.println("Determinante: " + m.calcolaDeterminante());
//        try {
//            Grafo g = MyUtil.getGrafoDaXML("input_0.xml");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(IEEETestQuasiFinale.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (XMLStreamException ex) {
//            Logger.getLogger(IEEETestQuasiFinale.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
}
