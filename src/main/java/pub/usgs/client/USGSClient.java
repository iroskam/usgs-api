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


/**
 * A Java client for interacting with USGS API endpoints. 
 * <br><br>
 * https://mrdata.usgs.gov/catalog/api.php
 */
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
     * Given a geographic bounding rectangle, returns complete data for NURE sediment records located withing that area.
     * @throws InterruptedException
     * @throws IOException
     */
    public String nureSedimentSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Format f) throws IOException, InterruptedException{
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
     * Given a geographic bounding rectangle, returns complete data for NURE water records located withing that area.
     * @throws InterruptedException
     * @throws IOException
     */
    public String nureWaterSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/nure/water/search-bbox.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given a geographic bounding rectangle, returns complete data for NGDB records located withing that area.
     * @throws InterruptedException
     * @throws IOException
     */
    public String ngbdSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/ngdb/rock/search-bbox.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given a geographic bounding rectangle, returns complete data for NGS records located withing that area.
     * @throws InterruptedException
     * @throws IOException
     */
    public String ngsSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/geochem/search-bbox.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns MRDS data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String mrdsSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&srs="+"EPSG:3857";
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/mrds/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns data ARDF records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String ardfSearchByName(String q, Relation r, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/mrds/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns VMS data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String vmsSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/vms/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Sediment-hosted Zn-Pb deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String znpbSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/sedznpb/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "SedEx-MVT deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String mvtSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/sedexmvt/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Porphyry Cu deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String porcuSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/porcu/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Sediment-hosted Cu deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String sedcuSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/sedcu/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Ni-Cr PGE deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String nicrSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/nicrpge/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Carbonatite deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String carbonatiteSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/carbonatite/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "REE deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String reeSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/ree/search-by-name.php"+qString))
            .GET();
        return send(req);
    }


    /**
     * Given the name of a mine, prospect, or occurence, returns "Ni-Co laterite deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String nicoSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/laterite/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given the name of a mine, prospect, or occurence, returns "Phosphate deposit records" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String phosphateSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/phosphate/search-by-name.php"+qString))
            .GET();
        return send(req);
    }


    /**
     * Given the name of a mine, prospect, or occurence, returns "Podiform Chromite deposits" data records of sites whose names match.
     * @throws InterruptedException
     * @throws IOException
     */
    public String podchromeSearchByName(String q, Relation r, State st, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "q="+q;
        qString += "&r="+r.rel();
        qString += "&st="+st.abrv();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/podchrome/search-by-name.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * SGMC map unit name at a geographic location.
     * Given a geographic point location, returns as text the name and database identifier of the geologic unit in which the point lies.
     * @param x Geographic longitude in decimal degrees with datum WGS84, west longitudes negative
     * @param y Geographic latitude in decimal degrees with datum WGS84, south latitudes negative
     * @throws InterruptedException
     * @throws IOException
     */
    public String pointUnit(BigDecimal x, BigDecimal y) throws IOException, InterruptedException{
        return pointUnit(x,y,"n");
    }

    /**
     * SGMC map unit name at a geographic location.
     * Given a geographic point location, returns as text the name and database identifier of the geologic unit in which the point lies.
     * @param x Geographic longitude in decimal degrees with datum WGS84, west longitudes negative
     * @param y Geographic latitude in decimal degrees with datum WGS84, south latitudes negative
     * @param q Type of query: u for unit link, n for unit name (default), b for both
     * @throws InterruptedException
     * @throws IOException
     */
    public String pointUnit(BigDecimal x, BigDecimal y, String q) throws IOException, InterruptedException{
        String qString = "?";
        qString += "x="+x.toPlainString();
        qString += "y="+y.toPlainString();
        qString += "&q="+q;
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/geology/state/point-unit.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Given a geologic unit identifier, returns descriptive information about the unit.
     * @param unit Unique identifier for a geologic unit, a value of unit_link from the units table of the SGMC relational database
     * @param f XML or JSON if either of those formats is desired, otherwise the XML will be transformed into HTML by the server 
     * @throws InterruptedException
     * @throws IOException
     */
    public String sgmcUnit(String unit, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "unit="+unit;
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/geology/state/point-unit.php"+qString))
            .GET();
        return send(req);
    }
    
    /**
     * Given a geologic unit identifier, returns descriptive information about the unit.
     * @param x Geographic longitude in decimal degrees with datum WGS84, west longitudes negative
     * @param y Geographic latitude in decimal degrees with datum WGS84, south latitudes negative
     * @param f XML or JSON if either of those formats is desired, otherwise the XML will be transformed into HTML by the server 
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String sgmcUnit(BigDecimal x, BigDecimal y, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "x="+x.toPlainString();
        qString += "&y="+y.toPlainString();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/geology/state/sgmc-unit.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Soil geochemical landscape samples within a geographic rectangle.
     * @param xmin West bounding coordinate in decimal degrees with WGS84 datum, west longitude negative
     * @param ymin South bounding coordinate in decimal degrees with WGS84 datum, south latitude negative
     * @param xmax East bounding coordinate in decimal degrees with WGS84 datum, west longitude negative
     * @param ymax North bounding coordinate in decimal degrees with WGS84 datum, south latitude negative
     * @param f XML (default), JSON or HTML output
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String geochemSampleSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/ds-801/search-bbox.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Alaska geochemical samples within a geographic rectangle. Given a geographic bounding rectangle, returns complete data for records located within that area. Includes best-value estimates for each analyzed chemical element.
     * @param xmin West bounding coordinate in decimal degrees with WGS84 datum, west longitude negative
     * @param ymin South bounding coordinate in decimal degrees with WGS84 datum, south latitude negative
     * @param xmax East bounding coordinate in decimal degrees with WGS84 datum, west longitude negative
     * @param ymax North bounding coordinate in decimal degrees with WGS84 datum, south latitude negative
     * @param media Type of material analyzed: sediment, soil, rock, concentrate, mineral
     * @param f XML (default), JSON or HTML output
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String agdbSearchBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Medium media, Format f) throws IOException, InterruptedException{
        String qString = "?";
        qString += "xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        qString += "&media="+media.medium();
        qString += "&f="+f.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/agdb/search-bbox.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Geographic areas intersecting a bounding box. Given a bounding box, return the well known geographic areas that intersect the box. Coordinates will be interpreted as geographic latitude and longitude NAD83.
     * @param xmin West bounding coordinate, in decimal degrees NAD83, west longitudes negative.
     * @param ymin East bounding coordinate, in decimal degrees NAD83, west longitudes negative.
     * @param xmax North bounding coordinate, in decimal degrees NAD83, south latitudes negative.
     * @param ymax South bounding coordinate, in decimal degrees NAD83, south latitudes negative. 
     * @param format XML, HTML, or JSON, not case sensitive
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String geoAreaIntersectBBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax, Format format) throws IOException, InterruptedException{
        String qString = "?";
        qString += "xmin="+xmin.toPlainString();
        qString += "&ymin="+ymin.toPlainString();
        qString += "&xmax="+xmax.toPlainString();
        qString += "&ymax="+ymax.toPlainString();
        qString += "&format="+format.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/ds-801/search-bbox.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Catalog record details. Given a catalog record identifier, show citation information, category terms, bounding coordinates, OGC web services, download links, and browse graphics.
     * @param cite
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String catalogRecord(int cite) throws IOException, InterruptedException{
        String qString = "?";
        qString += "cite="+cite;
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/catalog/record.php"+qString))
            .GET();
        return send(req);
    }

    /**
     * Geographic areas containing a point. Given a point location, return the well known geographic areas that contain the point. Coordinates will be interpreted as geographic latitude and longitude NAD83.
     * @param latitude Geographic latitude, decimal degrees NAD83, south latitudes negative.
     * @param longitude Geographic longitude, decimal degrees NAD83, west longitudes negative.
     * @param format XML, HTML, or JSON, not case sensitive
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String geoAreaContainingPoint(BigDecimal latitude, BigDecimal longitude, Format format) throws IOException, InterruptedException{
        String qString = "?";
        qString += "latitude="+latitude.toPlainString();
        qString += "&longitude="+longitude.toPlainString();
        qString += "&format="+format.format();
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create("https://mrdata.usgs.gov/catalog/record.php"+qString))
            .GET();
        return send(req);
    }
}