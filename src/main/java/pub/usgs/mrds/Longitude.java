package pub.usgs.mrds;

import java.math.BigDecimal;

/**
 * Class for longitude oridinate.
 */
public class Longitude{
    public static final int MAXIMUM = 180;
    public static final int MINIUMUM = -180;
    
    private int degrees;
    private int minutes;
    private int seconds;


    public Longitude(String longitude){
        // parse string longitude to degrees, minutes, seconds
    }

    public Longitude(int degrees, int minutes, int seconds){
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public BigDecimal toDecimalDegrees(){
        // return decimal degrees;
        return null;
    }
}