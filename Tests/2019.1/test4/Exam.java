public class Exam {

    public static void main(String args[]) {
    
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,0);
        Point p3 = new Point(0,4);

        RightTriangle t1 = new RightTriangle(p2,p3,p1);
        System.out.printf("%s\n%s%s%.2f\n%s%.2f\n\n",
                "Right triangle", t1,
                "area: ", t1.getArea(),
                "perimeter: ", t1.getPerimeter());

        p1.setCoordinate0(-1);
        p1.setCoordinate1(0);
        p2.setCoordinate0(1);
        p2.setCoordinate1(0);
        p3.setCoordinate0(0);
        p3.setCoordinate1(Math.sqrt(3));

        EquilateralTriangle t2 = new EquilateralTriangle(p2,p3,p1);
        System.out.printf("%s\n%s%s%.2f\n%s%.2f\n",
                "Equilateral triangle", t2,
                "area: ", t2.getArea(),
                "perimeter: ", t2.getPerimeter());
    }
}


class Point {
    private double coordinate0, coordinate1;

    public Point(double coordinate0, double coordinate1) {
        this.coordinate0 = coordinate0; this.coordinate1 = coordinate1;
    }

    public double getCoordinate0(){
        return coordinate0;
    }

    public double getCoordinate1(){
        return coordinate1;
    }

    public void setCoordinate0(double coordinate0) {
        this.coordinate0 = coordinate0;
    }

    public void setCoordinate1(double coordinate1) {
        this.coordinate1 = coordinate1;
    }

    static double dotProduct(Point u, Point v) {
        return u.getCoordinate0()*v.getCoordinate0() + u.getCoordinate1()*v.getCoordinate1();
    }

    static Point difference(Point u, Point v) {
        return new Point(u.getCoordinate0()-v.getCoordinate0(), u.getCoordinate1()-v.getCoordinate1());
    }

    static double distance(Point u, Point v) {
        double x = Math.pow(u.getCoordinate0() - v.getCoordinate0(),2);
        double y = Math.pow(u.getCoordinate1() - v.getCoordinate1(),2);
        return Math.sqrt(x+y);
    }

    static double getParallelogramArea(Point vertex0, Point vertex1, Point vertex2) {
        double a1 = vertex1.getCoordinate0() - vertex0.getCoordinate0();
        double a2 = vertex1.getCoordinate1() - vertex0.getCoordinate1();
        double b1 = vertex2.getCoordinate0() - vertex0.getCoordinate0();
        double b2 = vertex2.getCoordinate1() - vertex0.getCoordinate1();
        return Math.abs(a1*b2 - a2*b1);
    }
}


class Triangle {

    public static final double EPSILON = 0.0001D;

    private Point vertex0, vertex1, vertex2;
    private double angle0, angle1, angle2;
    private double edge0, edge1, edge2;

    public Triangle(Point vertex0, Point vertex1, Point vertex2) {
        if (Point.getParallelogramArea(vertex0,vertex1,vertex2) > 0) {
            this.vertex0 = vertex0;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            angle0 = Point.dotProduct( Point.difference(getVertex1(),getVertex0()),
                    Point.difference( getVertex2(),getVertex0()) );
            angle1 = Point.dotProduct( Point.difference(getVertex2(),getVertex1()),
                    Point.difference(getVertex0(),getVertex1()) );
            angle2 = Point.dotProduct( Point.difference(getVertex0(),getVertex2()),
                    Point.difference(getVertex1(),getVertex2()) );
            edge0 = Point.distance(getVertex1(),getVertex2());
            edge1 = Point.distance(getVertex0(),getVertex2());
            edge2 = Point.distance(getVertex0(),getVertex1());
        }
        else
            throw new IllegalArgumentException("The given points are NOT vertices of a triangle!");
    }

    public Point getVertex0() {
        return vertex0;
    }

    public Point getVertex1() {
        return vertex1;
    }

    public Point getVertex2() {
        return vertex2;
    }

    public double getAngle0() {
        return angle0;
    }

    public double getAngle1() {
        return angle1;
    }

    public double getAngle2() {
        return angle2;
    }

    public double getEdge0() {
        return edge0;
    }

    public double getEdge1() {
        return edge1;
    }

    public double getEdge2() {
        return edge2;
    }

    public void setVertex0(Point vertex0) {
        this.vertex0 = vertex0;
    }

    public void setVertex1(Point vertex1) {
        this.vertex1 = vertex1;
    }

    public void setVertex2(Point vertex2) {
        this.vertex2 = vertex2;
    }

    public void setAngle0(double angle0) {
        this.angle0 = angle0;
    }

    public void setAngle1(double angle1) {
        this.angle1 = angle1;
    }

    public void setAngle2(double angle2) {
        this.angle2 = angle2;
    }

    public void setEdge0(double edge0) {
        this.edge0 = edge0;
    }

    public void setEdge1(double edge1) {
        this.edge1 = edge1;
    }

    public void setEdge2(double edge2) {
        this.edge2 = edge2;
    }

    public boolean isRight() {
        if (Math.abs(angle0) < EPSILON ||
            Math.abs(angle1) < EPSILON ||
            Math.abs(angle2) < EPSILON)
            return true;
        else return false;
    }

    public boolean isEquilateral() {
        if (Math.abs(edge0 - edge1) < 
        	EPSILON && Math.abs(edge1 - edge2) < EPSILON)
            return true;
        return false;
    }

    public double getPerimeter() {
        return edge0 + edge1 + edge2;
    }

    public double getArea() {
        return Point.getParallelogramArea(vertex0,vertex1,vertex2)/2;
    }

    @Override
    public String toString() {
        return String.format(
            "%s(%.2f,%.2f)\n%s(%.2f,%.2f)\n%s(%.2f,%.2f)\n%s%.2f\n%s%.2f\n%s%.2f\n",
            "vertex0 = ", vertex0.getCoordinate0(), vertex0.getCoordinate1(),
            "vertex1 = ", vertex1.getCoordinate0(), vertex1.getCoordinate1(),
            "vertex2 = ", vertex2.getCoordinate0(), vertex2.getCoordinate1(),
            "edge0 = ", edge0, "edge1 = ", edge1,
            "edge2 = ", edge2
            );
    }
}


class RightTriangle extends Triangle {

    public RightTriangle(Point vertex0, Point vertex1, Point vertex2) {
        super(vertex0,vertex1,vertex2);
        if (isRight()) {
            if (Math.abs(getAngle1()) < EPSILON) {
                setAngle1(getAngle0());
                setAngle0(0);
                Point a = getVertex1();
                setVertex1(getVertex0());
                setVertex0(a);
                double b = getEdge1();
                setEdge1(getEdge0());
                setEdge0(b);
            } else if (Math.abs(getAngle2()) < EPSILON) {
                setAngle2(getAngle0());
                setAngle0(0);
                Point a = getVertex2();
                setVertex2(getVertex0());
                setVertex0(a);
                double b = getEdge2();
                setEdge2(getEdge0());
                setEdge0(b);
            }
        }
        else
            throw new IllegalArgumentException("The given points are NOT vertices of a right triangle!");
    }

    @Override
    public double getArea() {
        return getEdge1()*getEdge2()/2;
    }
}


class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(Point vertex0, Point vertex1, Point vertex2) {
        super(vertex0,vertex1,vertex2);
        if (isEquilateral() == false) {
            throw new IllegalArgumentException("The given points are NOT vertices of an equilateral triangle!");
        }
    }

    @Override
    public double getArea() {
        return Math.sqrt(3)*getEdge0()*getEdge0()/4;
    }

    @Override
    public double getPerimeter() {
        return 3*getEdge0();
    }
}
