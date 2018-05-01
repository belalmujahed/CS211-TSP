public class university {
    int ranking;
    String name;
    double lat;
    double lon;

    public university(int ranking, String name, double lat, double lon){
        this.ranking=ranking;
        this.name=name;
        this.lat=lat;
        this.lon=lon;
    }
    public double getLat(){
        return lat;
    }
    public double getLon(){
        return lon;
    }
}
