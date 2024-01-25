import java.io.IOException;
import java.math.BigDecimal;

import pub.usgs.client.Commodities;
import pub.usgs.client.Formats;
import pub.usgs.client.USGSClient;

public class Test {
    public static void main(String... args){
        USGSClient client = new USGSClient();

        BigDecimal xmax = new BigDecimal("-131.87356");
        BigDecimal xmin = new BigDecimal("-132.18737");
        BigDecimal ymax = new BigDecimal("55.715177");
        BigDecimal ymin = new BigDecimal("55.51866");
        
        // Longitude xmax = new Longitude("-131.87356");
        // Longitude xmin = new Longitude("-132.18737");
        // Latitude ymax = new Latitude("55.715177");
        // Latitude ymin = new Latitude("55.51866");
        // -132.18737,55.51866,-131.87356,55.715177
        // ymin,xmin,ymax,xmax
        try {
            // https://mrdata.usgs.gov/mrds/search-bbox.php?xmin=-132.18737&xmax=-131.87356&ymin=55.51866&ymax=55.715177&com=AU&f=JSON
            System.out.println(client.inBounds(xmin,ymin,xmax,ymax));
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
