package patterns.factory;

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

class Point {
    private double x, y;

    protected Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double a, double b, CoordinateSystem cs) {
        switch (cs) {
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                this.x = a * Math.cos(b);
                this.y = a * Math.sin(b);
                break;
        }
    }

// steps to add a new system
    // 1. augment CoordinateSystem
    // 2. change ctor

    // singleton field
    public static final Point ORIGIN = new Point(0, 0);

    // factory method
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
    }

    public static class Factory {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}

class PointFactory {
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }
}

class FactoryDemo {
    public static void main(String[] args) {
        Point point1 = new Point(1, 3, CoordinateSystem.CARTESIAN);
        Point origin = Point.ORIGIN;

        Point point2 = Point.newCartesianPoint(1, 5);
        Point point3 = Point.newCartesianPoint(3, 7);

        System.out.println(origin);

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);

        Point point4 = PointFactory.newCartesianPoint(4, 6);
        System.out.println(point4);
    }
}
