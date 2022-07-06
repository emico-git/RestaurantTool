import static org.junit.jupiter.api.Assertions.*;

class SpeiseTest {

    Speise s = new Speise();

    @org.junit.jupiter.api.Test
    void getPreis() {
        assertEquals(5, s.get);
    }

    @org.junit.jupiter.api.Test
    void setPreis() {
    }
}