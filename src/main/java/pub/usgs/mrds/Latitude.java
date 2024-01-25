package pub.usgs.mrds;

import java.math.BigDecimal;

/**
 * Class for latitude ordinate.
 */
public class Latitude{
    public static final int MAXIMUM = 90;
    public static final int MINIUMUM = -90;
    
    private int degrees;
    private int minutes;
    private int seconds;


    public Latitude(String latitude){
        // parse string latitute to degrees, minutes, seconds
    }

    public Latitude(int degrees, int minutes, int seconds){
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public BigDecimal toDecimalDegrees(){
        // return decimal degrees;
        return null;
    }
}