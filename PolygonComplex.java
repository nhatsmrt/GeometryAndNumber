class PolygonComplex {
   private Complex[] points;
   
   public PolygonComplex(Complex[] points) {
      GeometryComplex = new GeometryComplex();
      if (!GeometryComplex.isConvex(points)
         throw new IllegalArgumentException("List of points must be convex");
         
      this.points = points;
   }
   
   // Find area using shoelace's formula
   public double findArea() {
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
   
   public static void main(String[] args) {
      Complex[] points = new Complex[3];
      points[0] = new Complex(0, 1);
      points[1] = new Complex(0, 0);
      points[2] = new Complex(3, 4);
      
      PolygonComplex polygon1 = new PolygonComplex(points);
      System.out.println(polygon1.findArea());
   }
   
}