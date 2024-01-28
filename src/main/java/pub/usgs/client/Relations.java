package pub.usgs.client;

record Relation(String rel){};

public class Relations {
    public static final Relation BEGINS = new Relation("begins");
    public static final Relation CONTAINS = new Relation("contains");
    public static final Relation MATCHES = new Relation("matches");
}
