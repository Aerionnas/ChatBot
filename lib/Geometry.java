package lib;

public class Geometry{

    public static double sphereVolume(double r){
      return 4.0/3.0*Math.PI*r*r*r;
    }

    public static double sphereArea(double r){
      return 8*Math.PI*r*r;
    }

    public static double boxVolume(double h, double w, double d){
      return h*w*d;
    }

    public static double boxArea(double h, double w, double d){
      return 2*(h*2 + h*d + w*d);
    }

    public static double cylinderVolume(double r, double h){
      return Math.PI*r*r*h;
    }

    public static double cylinderArea(double r, double h){
      return 2*Math.PI*r*r + 2*Math.PI*r*h;
    }
}
