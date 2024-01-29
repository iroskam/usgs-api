package pub.usgs.client;

record Medium(String medium){};

public class Mediums {
    public static final Medium SEDIMENT = new Medium("sediment");
    public static final Medium SOIL = new Medium("soil");
    public static final Medium ROCK = new Medium("rock");
    public static final Medium CONCENTRATE = new Medium("concentrate");
    public static final Medium MINERAL = new Medium("mineral");
}
