package pub.usgs.client;

record Format(String format){}

public class Formats {
    public static final Format XML = new Format("XML");
    public static final Format JSON = new Format("JSON");
    public static final Format HTML = new Format("HTML");
}
