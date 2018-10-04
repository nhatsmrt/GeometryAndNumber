public class PolygonComplex {
   private Complex[] points;
   
   public PolygonComplex(Complex[] points) {
//       GeometryComplex geometer = new GeometryComplex();
//       if (!geometer.isConvex(points))
//          throw new IllegalArgumentException("List of points must be convex");
         
      this.points = points;
   }
   
   // Find area using shoelace's formula
   public double area() {
      int numPoints = points.length;      
      double firstHalf = 0;
      double secondHalf = 0;
      
      for (int i = 0; i < numPoints - 1; i++)
         firstHalf += points[i].re() * points[i + 1].im();
      firstHalf += points[numPoints - 1].re() * points[0].im();
      
      for (int i = 1; i < numPoints; i++)
         secondHalf += points[i].re() * points[i - 1].im();
      secondHalf += points[0].re() * points[numPoints - 1].im();
      
      return Math.abs(firstHalf - secondHalf) / 2;
   }
   
   public double perimeter() {
      double ret = 0;
      
      for (int i = 0; i < points.length - 1; i++)
         ret += points[i].subtract(points[i + 1]).norm();
      
      ret += points[points.length - 1].subtract(points[0]).norm();
      return ret;
   }
   
   public static void main(String[] args) {
      Complex[] points = new Complex[3];
      points[0] = new Complex(0, 1);
      points[1] = new Complex(0, 0);
      points[2] = new Complex(3, 4);
      
      Complex zero = new Complex(0, 0);
      Complex one = new Complex(1, 0);
      Complex i = new Complex(0, 1);
      Complex mixed1 = new Complex(0, -1);
      Complex mixed2 = new Complex(-1, 0);

      
      Complex[] squarePoints = new Complex[4];
      squarePoints[0] = i;
      squarePoints[1] = one;
      squarePoints[2] = mixed1;
      squarePoints[3] = mixed2;
      
      PolygonComplex square = new PolygonComplex(squarePoints);
      PolygonComplex polygon1 = new PolygonComplex(points);
      
      System.out.println(polygon1.area());
      System.out.println(square.area());
   }
   
}