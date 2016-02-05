import newpackage.OffertaEventoBean;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alessandro on 27/01/2016.
 */
public class OffertaEventoBeanTest {

    @Test
    public void testFillToFind() throws Exception {
        OffertaEventoBean ofb = new OffertaEventoBean();
        ofb.setOfcity("Roma");
        ofb.setOftype("Concerto");
        ofb.setOfname("Bubu");
        ofb.setOfprice(33);
        assertTrue(ofb.fillToFind());
    }
}