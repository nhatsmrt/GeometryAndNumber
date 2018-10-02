import java.util.*;
public class GeometryComplex {
   
   // Check if a set of points is complex
   // unimplemented
   public boolean isConvex(Complex[] pts) {
      return false;
   }
   
   
   // Find the convex hull of an array of points
   // unimplemented
   public ArrayList<Complex> findConvexHull(Complex[] pts) {
      return null;
   }
   
   public double dotProduct(Complex a, Complex b) {
      return a.conjugate().multiply(b).re();
   }
   
   // Projection of b onto a
   public Complex proj(Complex a, Complex b) {
      if (a.isZero())
         throw new IllegalArgumentException();
      
      double aNorm = a.norm();
      double scale = dotProduct(a, b) / (aNorm * aNorm);
      
      return a.scale(scale);
   }
   
   public double pointDist(Complex a, Complex b) {
      return a.subtract(b).norm();
   }
   
   public static void main (String[] args) {
      Complex a = new Complex(1.0, 2.0);
      Complex b = new Complex(2, 4);
      GeometryComplex geometer = new GeometryComplex();
      
      System.out.println(geometer.dotProduct(a, b));
   }
   
   
}