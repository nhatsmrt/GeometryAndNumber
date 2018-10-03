public class Complex {
  private double real;
  private double img;
  private int precision;
  private final int DEFAULT_PRECISION = 3;

  public Complex(double re, double im) {
    this.real = re;
    this.img = im;
    precision = DEFAULT_PRECISION;
  }
  
  public void setPrecision(int precision) {
    this.precision = precision;
  }

  public Complex add(Complex other) {
    return new Complex(re() + other.re(), im() + other.im());
  }

  public Complex subtract(Complex other) {
    return new Complex(re() - other.re(), im() - other.im());
  }

  public Complex multiply(Complex other) {
    double newRe = re() * other.re() - im() * other.im();
    double newIm = im() * other.re() + re() * other.im();
    return new Complex(newRe, newIm);
  }
  
  public Complex scale(double factor) {
    return new Complex(real * factor, img * factor);
  }
  
  public Complex reciprocal() {
    if (re() == 0 && im() == 0)
       throw new IllegalArgumentException();
      
    double scale = re() * re() + im() * im();
    double newRe = re() / scale;
    double newIm = -im() / scale;
    
    return new Complex(newRe, newIm);
  }
  
  public Complex conjugate() {
    return new Complex(re(), -im());
  }
  
  public double norm() {
    return Math.sqrt(re() * re() + im() * im());
  }
  
  public Complex divide(Complex other) {
    return multiply(other.reciprocal());
  }
  
  public boolean equals(Complex other) {
    return re() == other.re() && im() == other.im();
  }
  
  public boolean equalsString(Complex other) {
    return toString().equals(other.toString());
  }

  public double re() {
    return real;
  }

  public double im() {
    return img;
  }
  
  // return argument of the complex number
  // wrapper for atan2
  public double arg() {
    return Math.atan2(img, real);
  }
  
  public boolean isZero() {
    return real == 0 && img == 0;
  }
  
  public boolean isReal() {
    return img == 0;
  }
  
  public boolean isImaginary() {
    return real == 0 && img != 0;
  }
  
  // snippet from https://stackoverflow.com/questions/22186778/using-math-round-to-round-to-one-decimal-place
  private double round (double value, int precision) {
    int scale = (int) Math.pow(10, precision);
    return (double) Math.round(value * scale) / scale;
  }

  
  public String toString() {
    double realTruncated = round(real, precision);
    double imgTruncated = round(img, precision);
    
    if (realTruncated == 0 && imgTruncated == 0)
      return "0";
    
    if (realTruncated != 0 && imgTruncated == 0)
      return Double.toString(real);
    
    String imgString = "";
    if (Math.abs(imgTruncated) == 1)
      imgString = "i";
    else
      imgString = Double.toString(Math.abs(imgTruncated)) + "i";
      
    if (realTruncated == 0) {
      if (imgTruncated < 0)
         imgString = "-" + imgString;
         
      return imgString;
    }
      
    String ret = Double.toString(realTruncated);
    if (imgTruncated < 0)
      ret += " - ";
    else
      ret += " + ";
    ret += imgString;
    
    return ret;
  }
}
