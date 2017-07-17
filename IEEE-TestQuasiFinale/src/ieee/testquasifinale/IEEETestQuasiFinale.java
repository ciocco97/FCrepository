package ieee.testquasifinale;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import myutil.MyUtil;

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
        
    }
    
}
