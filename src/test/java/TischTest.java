import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TischTest {

    Speise s1 = new Speise(5.00, "Sushi");
    Speise s2 = new Speise(11.00, "Pizza");
    Kunden k1 = new Kunden("Emil", "U.", s1);
    Kunden k2 = new Kunden("Brandon", "W.", s2);
    Tisch t = new Tisch();
    ArrayList <Kunden> kunden = new ArrayList<>();


    @Test
    void rechnungTotal() {

        kunden.add(k1);
        kunden.add(k2);

        t.setKunden(kunden);
        assertEquals(16.00, t.rechnungTotal());
    }
}