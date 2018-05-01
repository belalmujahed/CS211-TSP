public class tsp {


    public static void main (String args[]){
        String filePath="C:\\Users\\Belal\\finalProject\\src\\travellingSalesman.csv";
        fileIO reader=new fileIO();
        String[] universities=reader.load(filePath);
        university[] uni=new university[1000];
        for(int i=0;i<1000;i++){
            String[] parts=universities[i].split(",");
            uni[i]= new university(i+1,parts[1],Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
            //System.out.println(i+1+parts[1]+" "+Double.parseDouble(parts[3])+" "+ Double.parseDouble(parts[4]));

        }
        createTable(uni);
    }

    private static void createTable(university[] uni){
        int[][] table=new int[1000][1000];
        int n=0;
        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){
                double lat1=uni[i].getLat();
                double lon1=uni[i].getLon();
                double lat2=uni[j].getLat();
                double lon2=uni[j].getLon();
                n++;
                if(i-j>99) {}
                else
                table[i][j]=calcDistance(lat1,lon1,lat2,lon2);
                //System.out.println(n+" "+table[i][j]);
            }
        }
        MST k=new MST();
        k.primMST(table);


    }
    private static int calcDistance(double lat1, double lon1, double lat2,
                                       double lon2) {

        final int radius = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = radius * c;

        distance = Math.pow(distance, 2);
        int l= (int) Math.sqrt(distance);

        return l;
    }


}
