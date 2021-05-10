import java.util.Arrays;
//class to represent a Distance. Holds two RandomPoint objects along with th distance between them.
import java.util.Comparator;
public  class PointPairDistance implements Comparable<PointPairDistance>{
	private  RandomPoint startpoint;
	private  RandomPoint endpoint;
	private  double distance;
	
	public PointPairDistance (RandomPoint startpoint,RandomPoint endpoint, double distance) {
		this.startpoint=startpoint;
	    this.endpoint=endpoint;
		this.distance=distance;
	}
	public RandomPoint getstartpoint() {
		return this.startpoint;
	}
	public RandomPoint getendpoint() {
		return this.endpoint;
	}
	public double getdistance() {
		return this.distance;
	}
	public String toString(){//overriding the toString() method  
		  String firstpoint="("+Double.toString(startpoint.x())+","+Double.toString(startpoint.y())+")";
		  String secondpoint="("+Double.toString(endpoint.x())+","+Double.toString(endpoint.y())+")";
		  String dist=Double.toString(distance);
		  return firstpoint+" "+secondpoint + " with a distance of " +dist;
		
		 }  
	@Override
	 public int compareTo(PointPairDistance p) {
		
			return Double.compare(getdistance(),p.getdistance());
		
		
	}

}
