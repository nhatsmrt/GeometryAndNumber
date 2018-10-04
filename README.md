# Geometry and Numbers
This repository holds my implementation of various (computational) geometry concepts through related numbers.
# Implemented Class and Functionality:
## Complex:
A class representing complex numbers. Its main purpose is to represent points in 2D plane, with the real component representing x-coordinate and the imaginary component representing y-coordinate.
## GeometryComplex:
A class representing a geometer that can compute or perform different geometrical concepts. Functionality:
1. boolean isCollinear(Complex a, Complex b, Complex c): Return true if a, b, c are collinear.
2. boolean isConcyclicComplex a, Complex b, Complex c, Complex d): Return true if a, b, c, d are concyclic.
3. Complex translate(Complex pt, Complex vector): Translate pt in the direction of vector.
4. Complex rotate(Complex pt, Complex center, double angle): Rotate pt about center by angle radians.
## PolygonComplex
A class representing polygons, whose points are represented by Complex. Functionality:
1. double findArea(): return the area of the polygon using shoelace formula.
## Point3D
A class representing points (or vectors) in 3D space, whose coordinates are real numbers (of type double). Functionality:
1. double dot(Point3D other): return dot product between this point and other.
2. Point3D cross(Point3D other): return cross product between this vector and other.
