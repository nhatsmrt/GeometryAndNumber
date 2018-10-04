public class Point3D {
   private double x;
   private double y;
   private double z;
   
   public Point3D(double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }
   
   public double dot(Point3D other) {
      return x * other.x + y * other.y + z * other.z;
   }
   
   public Point3D cross(Point3D other) {
      double newX = this.y * other.z - this.z * other.y;
      double newY = this.z * other.x - this.x * other.z;
      double newZ = this.x * other.y - this.y * other.x;
      
      return new Point3D(newX, newY, newZ);
   }
}