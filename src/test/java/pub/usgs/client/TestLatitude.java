package pub.usgs.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLatitude {
    @Test
    @DisplayName("Test for argument out of range.")
    public void outsideRange(){
        // String argument out of range
        assertThrows(IllegalArgumentException.class, ()->new Latitude("-91"));
        assertThrows(IllegalArgumentException.class, ()->new Latitude("91"));

        // degree argument out of range
        assertThrows(IllegalArgumentException.class, ()->new Latitude(91,10,10));
        assertThrows(IllegalArgumentException.class, ()->new Latitude(-91,10,10));
        // minute argument out of range
        assertThrows(IllegalArgumentException.class, ()->new Latitude(10,61,10));
        assertThrows(IllegalArgumentException.class, ()->new Latitude(10,-1,10));
        // second argument out of range
        assertThrows(IllegalArgumentException.class, ()->new Latitude(10,10,61));
        assertThrows(IllegalArgumentException.class, ()->new Latitude(10,10,-1));

        assertThrows(IllegalArgumentException.class, ()->new Latitude(90,0,1));
        assertThrows(IllegalArgumentException.class, ()->new Latitude(-90,0,1));
    }

    @Test
    @DisplayName("String Constructor")
    public void stringConstructor(){
        Latitude latitude = new Latitude("55.715177");
        assertEquals(55, latitude.getDegrees());
        assertEquals(42, latitude.getMinutes());
        assertEquals(54.6372, latitude.getSeconds());
        assertEquals("55.715177", latitude.toDecimalDegrees().toPlainString());

        latitude = new Latitude("-55.715177");
        assertEquals(-55, latitude.getDegrees());
        assertEquals(42, latitude.getMinutes());
        assertEquals(54.6372, latitude.getSeconds());
        assertEquals("-55.715177", latitude.toDecimalDegrees().toPlainString());
    }

    @Test
    @DisplayName("DMS Constructor")
    public void dmsConstructor(){
        Latitude latitude = new Latitude(55,42,54.6372);
        assertEquals(55, latitude.getDegrees());
        assertEquals(42, latitude.getMinutes());
        assertEquals(54.6372, latitude.getSeconds());
        assertEquals("55.715177", latitude.toDecimalDegrees().toPlainString());

        latitude = new Latitude(-55,42,54.6372);
        assertEquals(-55, latitude.getDegrees());
        assertEquals(42, latitude.getMinutes());
        assertEquals(54.6372, latitude.getSeconds());
        assertEquals("-55.715177", latitude.toDecimalDegrees().toPlainString());
    }
}
