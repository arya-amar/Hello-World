

import java.util.Arrays;
import java.util.Comparator;



public final class RandomPoint {
	//class to represent a Point as an x,y coordinate
    

    private final double x;    // x coordinate
    private final double y;    // y coordinate

    /**
     * Initializes a new point (x, y).
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @throws IllegalArgumentException if either {@code x} or {@code y}
     *    is {@code Double.NaN}, {@code Double.POSITIVE_INFINITY} or
     *    {@code Double.NEGATIVE_INFINITY}
     */
    public RandomPoint(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0) this.x = 0.0;  // convert -0.0 to +0.0
        else          this.x = x;

        if (y == 0.0) this.y = 0.0;  // convert -0.0 to +0.0
        else          this.y = y;
    }

    /**
     * Returns the x-coordinate.
     * @return the x-coordinate
     */
    public double x() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     * @return the y-coordinate
     */
    public double y() {
        return y;
    }

  

    /**
     * Returns the angle of this point in polar coordinates.
     * @return the angle (in radians) of this point in polar coordiantes (between –&pi; and &pi;)
     */
 
    public double distanceTo(RandomPoint that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }


    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;
        RandomPoint obj=(RandomPoint)object;

        if (obj != null && obj instanceof RandomPoint)
        {
        	if (x==obj.x() && this.y==obj.y()){
             sameSame = true;
        	}
        }

        return sameSame;
    }
  

    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    //can remove below
    public String reversetoString() {
        return "(" + y + ", " + x + ")";
    }



}
