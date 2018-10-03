import java.util.*;
/**
Some sources:
http://web.evanchen.cc/handouts/cmplx/en-cmplx.pdf
https://codeforces.com/blog/entry/22175
**/
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
   
   // angle is in radians
   // unimplemented
   public Complex rotate(Complex pt, double angle) {
      return null;
   } 
   
   public double pointDist(Complex a, Complex b) {
      return a.subtract(b).norm();
   }
   
   // return slope through two points a, b
   public double slopeThrough(Complex a, Complex b) {
      return Math.tan(b.subtract(a).arg());
   }
   
   public boolean isCollinear(Complex a, Complex b, Complex c) {
      if(a.equals(b) || b.equals(c) || c.equals(a))
         return true;
      
      Complex diff = c.subtract(a).divide(c.subtract(b));
      return diff.isReal();
   }
   
   public boolean isConcyclic(Complex a, Complex b, Complex c, Complex d) {
      if (a.equals(b) ||
          b.equals(c) ||
          c.equals(d) ||
          d.equals(a) ||
          a.equals(c) ||
          b.equals(d))
          return true;
          
      Complex diff1 = c.subtract(a).divide(c.subtract(b));
      Complex diff2 = d.subtract(a).divide(d.subtract(b));
      
      return diff1.divide(diff2).isReal();
   }
   
   public static void main (String[] args) {
      Complex a = new Complex(1.0, 2.0);
      Complex b = new Complex(2, 4);
      Complex c = new Complex(3, 5);
      GeometryComplex geometer = new GeometryComplex();
      
      System.out.println(geometer.dotProduct(a, b));
      System.out.println(geometer.slopeThrough(c, a));
   }
   
   
}