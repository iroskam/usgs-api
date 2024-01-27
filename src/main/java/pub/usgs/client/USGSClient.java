package pub.usgs.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class USGSClient {
    private static final String USER_AGENT = "USGS Java Client";
    private HttpClient http;

    public USGSClient(){
        http = HttpClient.newBuilder()
            .version(Version.HTTP_2)
            .followRedirects(Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }

    private String send(HttpRequest.Builder builder) throws IOException, InterruptedException{
        builder.version(Version.HTTP_2)
            .header("User-Agent", USER_AGENT);
        return send(builder.build());
    }
    private String send(HttpRequest req) throws IOException, InterruptedException{
        return http.send(req,BodyHandlers.ofString()).body();
    }

    /**
     * Calls {@link #inBounds(String, String, Format)} composing the bounds parameter from the argument edges 
     * with srid 4326(WGS 84)
     * @param xmin
     * @param ymin
     * @param xmax
     * @param ymax
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String inBounds(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax) throws IOException, InterruptedException{
        String bounds = xmin.toPlainString();
        bounds += ","+ymin.toPlainString();
        bounds += ","+xmax.toPlainString();
        bounds += ","+ymax.toPlainString();
        // bounds requires xmin,ymin,xmax,ymax
        return inBounds(bounds, "4326", Formats.JSON);
    }

    /**
     * Given a geographic bounding rectangle, provides a list of data resources with records that lie withing thosed bounds.
     * @throws InterruptedException
     * @throws IOException
     */
    public String inBounds(String bounds, String srid, Format format) throws IOException, InterruptedException{
        String qString = "?";
        System.out.println(bounds);
        qString += "bounds="+bounds; //-132.18737,55.51866,-131.87356,55.715177
        qString += "&srid="+srid;
        qString += "&format="+format.format();
        
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/general/in-bounds.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * 
     * @param x
     * @param y
     * @param d
     * @param xmin
     * @param ymin
     * @param xmax
     * @param ymax
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String nearPoint(BigDecimal x, BigDecimal y, int d, BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax) throws IOException, InterruptedException{
        return nearPoint(x,y,d,xmin,ymin,xmax,ymax, Formats.JSON);
    }

    /**
     * Given a geographic location or bounding rectagle, provides links to individual data records that are near the location given or within the bounding rectangle.
     *
     * @param x
     * @param y
     * @param d
     * @param xmin
     * @param ymin
     * @param xmax
     * @param ymax
     * @param format
     * @return
     * @throws InterruptedException
     * @throws IOException
     */
    public String nearPoint(BigDecimal x, BigDecimal y, int d, BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Format format) throws IOException, InterruptedException{
        String qString = "?";
        qString += "x="+x.toPlainString();
        qString += "&y="+y.toPlainString();
        qString += "&d="+d;
        qString += "&xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        qString += "&format="+format.format();

        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/general/near-point.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given a thesaurus term identifier, returns catalog records of scientific data resources pertinent to the category identified by the thesaurus term.
     */
    public void recordsMatching(){
        // TODO https://mrdata.usgs.gov/catalog/api.php?id=6
    }

    public String mrdsSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax) throws IOException, InterruptedException{
        return mrdsSearchBBox(xmin,ymin,xmax,ymax,null,Formats.JSON);
    }

    /**
     * Given a geographic bounding rectangle, returns complete data for MRDS records located within that area.
     * @throws InterruptedException 
     * @throws IOException 
     */
    public String mrdsSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Commodity com, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        if(com!=null)
            qString += "&com="+com.code();
        qString += "&f="+f.format();
        
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/mrds/search-bbox.php"+qString))
            .GET();
        return send(req);
    }
    
    /**
     * Given a geographic bounding rectangle, returns complete data for NURE records located withing that area.
     * @throws InterruptedException
     * @throws IOException
     */
    public String nureSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/nure/sediment/search-bbox.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given a geographic bounding rectangle, returns complete data for NGDB records located withing that area.
     */
    public void ngbdSearchBBox(){

    }

    /**
     * Given a geographic bounding rectangle, returns complete data for NGS records located withing that area.
     */
    public void ngsSearchBBox(){

    }

    /**
     * Given the name of a mine, prospect, or occurence, returns MRDS data records of sites whose names match.
     */
    public void mrdsSearchByName(){

    }

    /**
     * Given the name of a mine, prospect, or occurence, returns data ARDF records of sites whose names match.
     */
    public void ardfSearchByName(){
        
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns VMS data records of sites whose names match.
     */
    public void vmsSearchByName(){
        
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Sediment-hosted Zn-Pb deposits" data records of sites whose names match.
     */
    public void znpbSearchByName(){
        
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "SedEx-MVT deposits" data records of sites whose names match.
     */
    public void mvtSearchByName(){
        
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Porphyry Cu deposits" data records of sites whose names match.
     */
    public void porcuSearchByName(){
        
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Sediment-hosted Cu deposits" data records of sites whose names match.
     */
    public void sedcuSearchByName(){
        
    }


    /**
     * Given the name of a mine, prospect, or occurence, returns "Ni-Cr PGE deposits" data records of sites whose names match.
     */
    public void nicrSearchByName(){
        
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Carbonatite deposits" data records of sites whose names match.
     */
    public void carbonatiteSearchByName(){
        
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "REE deposits" data records of sites whose names match.
     */
    public void reeSearchByName(){
        
    }


    /**
     * Given the name of a mine, prospect, or occurence, returns "NNi-Co laterite deposits" data records of sites whose names match.
     */
    public void nicoSearchByName(){
        
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Phosphate deposit records" data records of sites whose names match.
     */
    public void phosphateSearchByName(){
        
    }


    /**
     * Given the name of a mine, prospect, or occurence, returns "Podiform Chromite deposits" data records of sites whose names match.
     */
    public void podchromeSearchByName(){
        
    }

    /**
     * SGMC map unit name at a geographic location.
     * Given a geographic point location, returns as text the name and database identifier of the geologic unit in which the point lies.
     */
    public void pointUnit(){
        
    }

    /**
     * Given a geologic unit identifier, returns descriptive information about the unit.
     */
    public void sgmcUnit(){
        
    }

    
}