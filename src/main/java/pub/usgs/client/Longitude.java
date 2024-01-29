package pub.usgs.client;

import java.math.BigDecimal;

/**
 * Class for longitude oridinate.
 */
public class Longitude{
    private static final int MAX_DEG = 180;
    private static final int MIN_DEG = -180;
    private static final int SIXTY = 60;
    private static final int ZERO = 0;
    
    private int degrees;
    private int minutes;
    private int seconds;

    /**
     * 
     * @param longitude in decimal degrees
     */
    public Longitude(String longitude){
        BigDecimal lng = new BigDecimal(longitude);
        BigDecimal sixty = new BigDecimal(60);
        degrees = lng.intValue();
        lng = lng.subtract(new BigDecimal(degrees));
        lng = lng.multiply(sixty);
        minutes = lng.intValue();
        lng = lng.multiply(sixty);
        seconds = lng.intValue();

        if(degrees > MAX_DEG || degrees < MIN_DEG){
            throw new IllegalArgumentException("Degrees longitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        if(minutes > SIXTY || minutes < SIXTY){
            throw new IllegalArgumentException("Minutes longitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if(seconds > SIXTY || seconds < SIXTY){
            throw new IllegalArgumentException("Seconds longitude must be between "+ZERO+" and "+SIXTY+".");
        }
    }

    public Longitude(int degrees, int minutes, int seconds){
        if(degrees > MAX_DEG || degrees < MIN_DEG){
            throw new IllegalArgumentException("Degrees longitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        if(minutes > SIXTY || minutes < SIXTY){
            throw new IllegalArgumentException("Minutes longitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if(seconds > SIXTY || seconds < SIXTY){
            throw new IllegalArgumentException("Seconds longitude must be between "+ZERO+" and "+SIXTY+".");
        }
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public BigDecimal toDecimalDegrees(){
        BigDecimal lng = new BigDecimal(degrees);
        BigDecimal min = new BigDecimal(minutes);
        BigDecimal sec = new BigDecimal(seconds);
        BigDecimal sixty = new BigDecimal(SIXTY);

        min = min.divide(sixty);
        sec = sec.divide(sixty).divide(sixty);

        lng = lng.add(min).add(sec);

        return lng;
    }

    public String toString(){
        BigDecimal lng = toDecimalDegrees();
        return lng.toPlainString();
    }
}