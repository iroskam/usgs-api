package pub.usgs.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLongitude {
    @Test
    @DisplayName("Test for argument out of range.")
    public void outsideRange(){
        // String argument out of range
        assertThrows(IllegalArgumentException.class, ()->new Longitude("-181"));
        assertThrows(IllegalArgumentException.class, ()->new Longitude("181"));

        // degree argument out of range
        assertThrows(IllegalArgumentException.class, ()->new Longitude(181,10,10));
        assertThrows(IllegalArgumentException.class, ()->new Longitude(-181,10,10));
        // minute argument out of range
        assertThrows(IllegalArgumentException.class, ()->new Longitude(10,61,10));
        assertThrows(IllegalArgumentException.class, ()->new Longitude(10,-1,10));
        // second argument out of range
        assertThrows(IllegalArgumentException.class, ()->new Longitude(10,10,61));
        assertThrows(IllegalArgumentException.class, ()->new Longitude(10,10,-1));

        assertThrows(IllegalArgumentException.class, ()->new Longitude(180,0,1));
        assertThrows(IllegalArgumentException.class, ()->new Longitude(-180,0,1));
    }

    @Test
    @DisplayName("String Constructor")
    public void stringConstructor(){
        Longitude longitude = new Longitude("131.87356");
        assertEquals(131, longitude.getDegrees());
        assertEquals(52, longitude.getMinutes());
        assertEquals(24.816, longitude.getSeconds());
        assertEquals("131.87356", longitude.toDecimalDegrees().toPlainString());

        longitude = new Longitude("-131.87356");
        assertEquals(-131, longitude.getDegrees());
        assertEquals(52, longitude.getMinutes());
        assertEquals(24.816, longitude.getSeconds());
        assertEquals("-131.87356", longitude.toDecimalDegrees().toPlainString());
    }

    @Test
    @DisplayName("DMS Constructor")
    public void dmsConstructor(){
        Longitude longitude = new Longitude(131,52,24.816);
        assertEquals(131, longitude.getDegrees());
        assertEquals(52, longitude.getMinutes());
        assertEquals(24.816, longitude.getSeconds());
        assertEquals("131.87356", longitude.toDecimalDegrees().toPlainString());

        longitude = new Longitude(-131,52,24.816);
        assertEquals(-131, longitude.getDegrees());
        assertEquals(52, longitude.getMinutes());
        assertEquals(24.816, longitude.getSeconds());
        assertEquals("-131.87356", longitude.toDecimalDegrees().toPlainString());
    }
}
