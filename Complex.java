class Complex {
  private float real;
  private float img;

  public Complex(float re, float im) {
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
    float newRe = re() * other.re() - im() * other.im();
    float newIm = im() * other.re() + re() * other.im();
    return new Complex(newRe, newIm);
  }
  
  public Complex reciprocal() {
    if (re() == 0 && im() == 0)
       throw new IllegalArgumentException();
      
    float scale = re() * re() + im() * im();
    float newRe = re() / scale;
    float newIm = -im() / scale;
    
    return new Complex(newRe, newIm);
  }
  
  public Complex divide(Complex other) {
    return multiply(other.reciprocal());
  }
  
  public boolean equals(Complex other) {
    return re() == other.re() && im() == other.im();
  }

  public float re() {
    return real;
  }

  public float im() {
    return img;
  }
}
