package com.mycompany.gradedexercise1;

/**
 *
 * @author katie
 */
public class Matrix {
    
    private final double[][] elements;

    //DONE
    public Matrix() {
        this.elements = new double[4][4];
        this.identity();
    }

    //DONE
    public double get(int row, int column) {
        return this.elements[row][column];
    }

    //DONE
    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    }

    //DONE
    public final void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    this.set(i, j, 1.0);
                } else {
                    this.set(i, j, 0.0);
                }
            }
        }
    }

    //DONE
    private String rowToString(int row) {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < 3; i++) {
            result.append(this.get(row, i));
            result.append(", ");
        }
        result.append(this.get(row, 3));
        result.append(" ]");
        return result.toString();
    }

    //DONE
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            result.append(rowToString(i));
            result.append("\n");
        }
        return result.toString();
    }

    //DONE
    public Matrix multiply(Matrix otherMatrix) {
        Matrix product = new Matrix();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                double sum = 0.0;
                for (int k = 0; k < 4; k++) {
                    sum += this.elements[row][k]
                            * otherMatrix.elements[k][column];
                }
                product.set(row, column, sum);
            }
        }
        return product;
    }

    // The rotateX() method has a single floating point parameter. Its return
    // type is void. That parameter represents an angle. The method sets the 
    // values of the elements of the matrix to create a matrix that models a
    // rotation about the x-axis.
    //DONE/TO TEST
    public void rotateX(double angle) {
        this.identity();
        this.set(1, 1, Math.cos(angle));
        this.set(1, 2, - Math.sin(angle));
        this.set(2, 1, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    }

    //The rotateY() method has a single floating point parameter. Its return
    // type is void. That parameter represents an angle. The method sets the
    // values of the elements of the matrix to create a matrix that models a
    // rotation about the y-axis.
    //DONE/TO TEST
    public void rotateY(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 2, Math.sin(angle));
        this.set(2, 0, - Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    }

    //The rotateZ() method has a single floating point parameter. Its return type
    // is void. That parameter represents an angle. The method sets the values of
    // the elements of the matrix to create a matrix that models a rotation about
    // the z-axis
    //DONE
    public void rotationZ(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 1, - Math.sin(angle));
        this.set(1, 0, Math.sin(angle));
        this.set(1, 1, Math.cos(angle));
    }

    //The scale() method has 3 floating point parameters. Its return type is
    // void. The parameters specify the factor by which a geometric figure is to
    // be enlarged (or shrunk) along the x, y, and z axes. The method sets the
    // values of the elements of the matrix to create a matrix that models a scaling.
    //DONE/TO TEST
    public void scale(double xChange, double yChange, double zChange) {
        this.identity();
        //System.out.println(this.get(0, 0));
        this.set(0, 0, xChange);
        this.set(1, 1, yChange);
        this.set(2, 2, zChange);
    }

    //The translate() method has 3 floating point parameters. Its return type is
    // void. The parameters specify the distance by which a geometric figure is
    // to be translated (moved) along the x, y, and z axes. The method sets the
    // values of the elements of the matrix to create a matrix that models a
    // translation.
    //DONE/TO TEST
    public void translate(float xChange, float yChange, float zChange) {
        this.identity();
        this.set(3, 0, xChange);
        this.set(3, 1, yChange);
        this.set(3, 2, zChange);
    }

    //The multiply() method has a Vector parameter. Its return type is Vector.
    // The method computes the product of this matrix and the parameter.
    //DONE
    public Vector multiply(Vector v) { //Fixed
        Vector newV = new Vector();
        int vectorIndex = 0;
        int indexNewV = 0;
        double newVValue = 0;
        for (int row = 0; row < 4; row++) {
            vectorIndex = 0;
            for (int column = 0; column < 4; column++) {
                double currentM = this.get(row, column);
                double currentV = v.get(vectorIndex);
                double newVal = currentM * currentV;
                newVValue += newVal;
                if (vectorIndex == 3) {
                    newV.set(indexNewV, newVValue);
                    indexNewV += 1;
                    newVValue = 0;
                }
                vectorIndex += 1;
            }
        }
        return newV;
    }

    public static void compare(Matrix m1, Matrix m2) {
        for (int m1Row = 0; m1Row < 4; m1Row++) {
            for (int m1Column = 0; m1Column < 4; m1Column++) {
                double m1Val = m1.get(m1Row, m1Column);
                double m2Val = m2.get(m1Row, m1Column);
                System.out.println("m1Val: "+m1Val+" m2Val: "+m2Val);
                if (m1Val != m2Val){
                    System.out.println("Fail");
                }
            }
        }
    }

    public static void main(String[] args) {
        
        
//        double angle = 10;
//        Matrix actual = new Matrix();
//        actual.rotateX(angle);
//        Matrix expected = new Matrix();
//        expected.set(1, 1, Math.cos(angle));
//        expected.set(1, 2, -Math.sin(angle));
//        expected.set(2, 1, Math.sin(angle));
//        expected.set(2, 2, Math.cos(angle));
//        System.out.println(expected.toString());
//        System.out.println(actual.toString());
//        compare(expected, actual);
    }

}

