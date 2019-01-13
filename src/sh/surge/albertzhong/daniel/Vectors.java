package sh.surge.albertzhong.daniel;

public class Vectors {

    // Adding 2 vectors
    public double[] add (double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Cannot add vectors in different dimensions");
        }
        double[] resultVector = new double[vector1.length];
        for (int i=0; i<resultVector.length; i++) {
            resultVector[i] = vector1[i] + vector2[i];
        }
        return resultVector;
    }


    // Subtracting two vectors
    public double[] subtract (double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Cannot subtract vectors in different dimensions");
        }
        double[] resultVector = new double[vector1.length];
        for (int i=0; i<resultVector.length; i++) {
            resultVector[i] = vector1[i] - vector2[i];
        }
        return resultVector;
    }

    // Finding the distance between a point and the origin
    public double distance (double[] point) {
        double distance = 0;
        for (int i=0; i<point.length; i++) {
            distance += (Math.pow(point[i], 2));
        }
        return Math.sqrt(distance);
    }

    public double distance (double[] point1, double[] point2) {
        if (point1.length != point2.length) {
            throw new IllegalArgumentException("Cannot determine the distance between points of different dimensions");
        }
        double distance = 0;
        for (int i=0; i<point1.length; i++) {
            distance += (Math.pow(point1[i]-point2[i], 2));
        }
        return Math.sqrt(distance);
    }


    // Finding the dot product of two vectors
    public double dotProduct(double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Cannot determine the dot product of vectors with different dimensions");
        }
        double dotProduct = 0;
        for (int i=0; i<vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
        }
        return dotProduct;
    }

    // Finding the cross product of two vectors
    public double[] crossProduct(double[] vector1, double[] vector2) {
        if ((vector1.length != 3) && (vector2.length != 3)) {
            throw new IllegalArgumentException("Cannot determine the cross product of non-3D vectors");
        }
        return new double[]{ (vector1[1]*vector2[2]-vector1[2]*vector2[1]), (vector1[2]*vector2[0]-vector1[0]*vector2[2]),
                (vector1[0]*vector2[1]-vector1[1]*vector2[0]) };
    }



}
