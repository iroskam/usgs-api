package pub.usgs.client;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Class for longitude oridinate.
 */
public class Longitude{
    private static final MathContext MC = new MathContext(9, RoundingMode.HALF_UP);
    private static final int MAX_DEG = 180;
    private static final int MIN_DEG = -180;
    private static final int SIXTY = 60;
    private static final int ZERO = 0;
    
    private int degrees;
    private int minutes;
    private double seconds;

    /**
     * 
     * @param longitude in decimal degrees
     */
    public Longitude(String longitude){
        BigDecimal lng = new BigDecimal(longitude, MC);
        BigDecimal sixty = new BigDecimal(60);
        degrees = lng.intValue();
        lng = lng.abs();
        lng = lng.subtract((new BigDecimal(degrees)).abs());
        lng = lng.multiply(sixty);
        minutes = lng.intValue();
        lng = lng.subtract(new BigDecimal(minutes));
        lng = lng.multiply(sixty);
        seconds = lng.doubleValue();

        if(degrees < MIN_DEG || degrees > MAX_DEG){
            throw new IllegalArgumentException("Degrees longitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        if(minutes < ZERO || minutes > SIXTY){
            throw new IllegalArgumentException("Minutes longitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if(seconds < ZERO || seconds > SIXTY){
            throw new IllegalArgumentException("Seconds longitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if((degrees == MIN_DEG || degrees == MAX_DEG) && (minutes > 0 || seconds > 0)){
            throw new IllegalArgumentException("Longitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
    }

    public Longitude(int degrees, int minutes, double seconds){
        if(degrees < MIN_DEG || degrees > MAX_DEG){
            throw new IllegalArgumentException("Degrees longitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        if(minutes < ZERO || minutes > SIXTY){
            throw new IllegalArgumentException("Minutes longitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if(seconds < ZERO || seconds > SIXTY){
            throw new IllegalArgumentException("Seconds longitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if((degrees == MIN_DEG || degrees == MAX_DEG) && (minutes > 0 || seconds > 0)){
            throw new IllegalArgumentException("Longitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }

        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public BigDecimal toDecimalDegrees(){
        BigDecimal lng = new BigDecimal(degrees, MC);
        BigDecimal min = new BigDecimal(minutes, MC);
        BigDecimal sec = new BigDecimal(seconds, MC);
        BigDecimal sixty = new BigDecimal(SIXTY, MC);

        min = min.divide(sixty, MC);
        sec = sec.divide(sixty, MC).divide(sixty, MC);

        if(lng.compareTo(BigDecimal.ZERO) < 0)
            lng = lng.subtract(min).subtract(sec);
        else
            lng = lng.add(min).add(sec);

        return lng.setScale(6, RoundingMode.HALF_UP).stripTrailingZeros();
    }

    public int getDegrees(){
        return degrees;
    }

    public int getMinutes(){
        return minutes;
    }

    public double getSeconds(){
        return seconds;
    }

    public String toString(){
        BigDecimal lng = toDecimalDegrees();
        return lng.toPlainString();
    }
}