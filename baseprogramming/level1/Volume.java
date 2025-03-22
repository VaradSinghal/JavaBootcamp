public class Volume {
    public static void main(String[] args) {
        double radiusKm = 6378; 
        double radiusMiles = radiusKm * 0.621371;
        double pi = Math.PI;

        
        double volumeKm3 = (4.0 / 3) * pi * Math.pow(radiusKm, 3);
        double volumeMiles3 = (4.0 / 3) * pi * Math.pow(radiusMiles, 3);

        System.out.println(String.format(
            "The volume of earth in cubic kilometers is %.2f and cubic miles is %.2f",
            volumeKm3, volumeMiles3
        ));
    }
}
