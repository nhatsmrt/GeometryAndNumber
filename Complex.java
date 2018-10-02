public class Complex {
  private double real;
  private double img;

  public Complex(double re, double im) {
    this.real = re;
    this.img = im;
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

  public double re() {
    return real;
  }

  public double im() {
    return img;
  }
  
  public boolean isZero() {
    return real == 0 && img == 0;
  }
  
  public boolean isReal() {
    return img == 0;
  }
  
  public boolean isImaginary() {
    return real == 0;
  }
}
