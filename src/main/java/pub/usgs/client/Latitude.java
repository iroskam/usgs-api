package pub.usgs.client;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Class for latitude ordinate.
 */
public class Latitude{
    private static final MathContext MC = new MathContext(8, RoundingMode.HALF_UP);
    private static final int MAX_DEG = 90;
    private static final int MIN_DEG = -90;
    private static final int SIXTY = 60;
    private static final int ZERO = 0;
    
    private int degrees;
    private int minutes;
    private double seconds;


    /**
     * 
     * @param latitude in decimal degrees
     */
    public Latitude(String latitude){
        BigDecimal lat = new BigDecimal(latitude, MC);
        BigDecimal sixty = new BigDecimal(60);
        degrees = lat.intValue();
        lat = lat.abs();
        lat = lat.subtract((new BigDecimal(degrees)).abs());
        lat = lat.multiply(sixty);
        minutes = lat.intValue();
        lat = lat.subtract(new BigDecimal(minutes));
        lat = lat.multiply(sixty);
        seconds = lat.doubleValue();

        System.out.println(degrees);
        System.out.println(minutes);
        System.out.println(seconds);

        if(degrees < MIN_DEG || degrees > MAX_DEG){
            throw new IllegalArgumentException("Degrees latitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        if(minutes < ZERO || minutes > SIXTY){
            throw new IllegalArgumentException("Minutes latitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if(seconds < ZERO || seconds > SIXTY){
            throw new IllegalArgumentException("Seconds latitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if((degrees == MIN_DEG || degrees == MAX_DEG) && (minutes > 0 || seconds > 0)){
            throw new IllegalArgumentException("Latitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
    }

    public Latitude(int degrees, int minutes, double seconds){
        if(degrees < MIN_DEG || degrees > MAX_DEG){
            throw new IllegalArgumentException("Degrees latitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        if(minutes < ZERO || minutes > SIXTY){
            throw new IllegalArgumentException("Minutes latitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if(seconds < ZERO || seconds > SIXTY){
            throw new IllegalArgumentException("Seconds latitude must be between "+ZERO+" and "+SIXTY+".");
        }
        if((degrees == MIN_DEG || degrees == MAX_DEG) && (minutes > 0 || seconds > 0)){
            throw new IllegalArgumentException("Latitude must be between "+MIN_DEG+" and "+MAX_DEG+".");
        }
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public BigDecimal toDecimalDegrees(){
        BigDecimal lat = new BigDecimal(degrees, MC);
        BigDecimal min = new BigDecimal(minutes, MC);
        BigDecimal sec = new BigDecimal(seconds, MC);
        BigDecimal sixty = new BigDecimal(SIXTY, MC);

        min = min.divide(sixty, MC);
        sec = sec.divide(sixty, MC).divide(sixty, MC);

        if(lat.compareTo(BigDecimal.ZERO) < 0)
            lat = lat.subtract(min).subtract(sec);
        else
            lat = lat.add(min).add(sec);

        return lat.setScale(6, RoundingMode.HALF_UP).stripTrailingZeros();
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
        BigDecimal lat = toDecimalDegrees();
        return lat.toPlainString();
    }
}