import java.util.Scanner;


public class Ray3D {

	Point3D p;
	Point3D d;
	
	public Ray3D(){
		
	}
	
	public Ray3D(Point3D p, Point3D d){
		this.p=p;
		this.d=d;
	}
	
	public Point3D findPosition(float t){
		return p.add(d.scale(t));
	}
	
	public void normalizeDirection(){
		d.normalize();
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Point coordinates");
		float x=scan.nextFloat();
		float y=scan.nextFloat();
		float z=scan.nextFloat();
		Point3D p= new Point3D(x,y,z);
		System.out.println("Enter direction coordinates");
		float dx=scan.nextFloat();
		float dy=scan.nextFloat();
		float dz=scan.nextFloat();
		Point3D d= new Point3D(dx,dy,dz);
		Ray3D r=new Ray3D(p,d);
		System.out.println(r);
		System.out.println("Enter time");
		float t=scan.nextFloat();
		System.out.println("After "+t+" time, the point is at "+r.findPosition(t)+". ");
	}
	
	public String toString(){
		return "p:"+p+", d:"+d;
	}
}
