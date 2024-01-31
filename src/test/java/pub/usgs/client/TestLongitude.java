package pub.usgs.client;

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
}
