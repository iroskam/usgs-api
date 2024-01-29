package pub.usgs.client;

import java.math.BigDecimal;

/**
 * Class for latitude ordinate.
 */
public class Latitude{
    private static final int MAX_DEG = 90;
    private static final int MIN_DEG = -90;
    private static final int SIXTY = 60;
    private static final int ZERO = 0;
    
    private int degrees;
    private int minutes;
    private int seconds;


    /**
     * 
     * @param latitude in decimal degrees
     */
    public Latitude(String latitude){
        BigDecimal lat = new BigDecimal(latitude);
        BigDecimal sixty = new BigDecimal(60);
        degrees = lat.intValue();
        lat = lat.subtract(new BigDecimal(degrees));
        lat = lat.multiply(sixty);
        minutes = lat.intValue();
        lat = lat.multiply(sixty);
        seconds = lat.intValue();

        if(degrees > MAX_DEG || degrees < MIN_DEG){
            throw new IllegalArgumentException("Degrees latitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        if(minutes > SIXTY || minutes < SIXTY){
            throw new IllegalArgumentException("Minutes latitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if(seconds > SIXTY || seconds < SIXTY){
            throw new IllegalArgumentException("Seconds latitude must be between "+ZERO+" and "+SIXTY+".");
        }
    }

    public Latitude(int degrees, int minutes, int seconds){
        if(degrees > MAX_DEG || degrees < MIN_DEG){
            throw new IllegalArgumentException("Degrees latitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        if(minutes > SIXTY || minutes < SIXTY){
            throw new IllegalArgumentException("Minutes latitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if(seconds > SIXTY || seconds < SIXTY){
            throw new IllegalArgumentException("Seconds latitude must be between "+ZERO+" and "+SIXTY+".");
        }
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public BigDecimal toDecimalDegrees(){
        BigDecimal lat = new BigDecimal(degrees);
        BigDecimal min = new BigDecimal(minutes);
        BigDecimal sec = new BigDecimal(seconds);
        BigDecimal sixty = new BigDecimal(SIXTY);

        min = min.divide(sixty);
        sec = sec.divide(sixty).divide(sixty);

        lat = lat.add(min).add(sec);

        return lat;
    }

    public String toString(){
        BigDecimal lat = toDecimalDegrees();
        return lat.toPlainString();
    }
}