import java.util.Scanner;

/**
 * 
 */

/**
 * @author Michael Shemesh
 *
 */
public class Point3D {
	
	float x;
	float y;
	float z;
	
	public Point3D(){
		
	}
	public Point3D(float x, float y, float z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public Point3D(Point3D p) {
		// TODO Auto-generated constructor stub
		this.x=p.x;
		this.y=p.y;
		this.z=p.z;
	}
	public Point3D add(Point3D p){
		Point3D result = new Point3D(this);
		result.x+=p.x;
		result.y+=p.y;
		result.z+=p.z;
		return result;
		
	}
	
	public void subtract(Point3D p){
		this.x-=p.x;
		this.y-=p.y;
		this.z-=p.z;
	}
	
	public Point3D scale(float f){
		Point3D p=new Point3D(this);
		p.x*=f;
		p.y*=f;
		p.z*=f;
		return p;
		
	}
	
	public float dotProduct(Point3D p){
		return (float)(x*p.x)+(y*p.y)+(z*p.z);
	}
	
	public Point3D crossProduct(Point3D p){
		Point3D result = new Point3D(p);
		result.x=(this.y*p.z-this.z*p.y);
		result.y=(this.z*p.x-this.x*p.z);
		result.z=(this.x*p.y-this.y*p.x);
		return result;
	}
	
	public float vecLength(){
		return (float) Math.sqrt(norm());
	}
	
	public float norm(){
		return dotProduct(this);
	}
	
	public Point3D normalize(){
		Point3D result =new Point3D(this);
		float xx= x/vecLength();
		float yy= y/vecLength();
		float zz=z/vecLength();
		result.x=xx;
		result.y=yy;
		result.z=zz;
		return result;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("x:");
		float x=scan.nextFloat();
		System.out.println("y:");
		float y=scan.nextFloat();
		System.out.println("z:");
		float z=scan.nextFloat();
		Point3D p = new Point3D(x,y,z);
		
		System.out.println("The length of the vector "+p.toString()+" is "+p.vecLength()+". ");
		System.out.println("The norm of the vector "+p.toString()+" is "+p.norm()+". ");
		System.out.println("The vector "+p.toString()+" normalized is "+p.normalize()+". ");
	
		System.out.println("x2:");
		float x2=scan.nextFloat();
		System.out.println("y2:");
		float y2=scan.nextFloat();
		System.out.println("z2:");
		float z2=scan.nextFloat();
		Point3D p2 = new Point3D(x2,y2,z2);
		
		System.out.println("The sum of the vector "+p.toString()+" and the second vector "+p2.toString()+" is "+p.add(p2));
		System.out.println("The cross product of the vector "+p.toString()+" and the second vector "+p2.toString()+" is "+p.crossProduct(p2)+".");
		System.out.println("The dot product of the vector "+p.toString()+" and the second vector "+p2.toString()+" is "+p.dotProduct(p2)+".");
		System.out.println("Enter a scale factor:");
		float sca=scan.nextFloat();
		System.out.println("The first vector scaled is "+p.scale(sca)+" and the second "+p2.scale(sca)+". ");
	}
	
	public String toString(){
		return "("+this.x+", "+this.y+", "+this.z+")";
	}
	
	
}


