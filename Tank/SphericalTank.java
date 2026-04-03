package EGE.prog2.Tank;


import java.util.Collections;
import java.util.Iterator;

public class SphericalTank extends Tank {
    private final double radius;
    private static final double PI = Math.PI;

    public SphericalTank(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return 4.0/3.0 * PI * radius * radius * radius;
    }

    @Override
    public double getSurfaceArea() {
        return 4 * PI * radius * radius;
    }

    @Override
    public Iterator<Tank> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public SphericalTank clone() {
        return new SphericalTank(radius);
    }

    @Override
    public String toString() {
        return String.format("Sphere(r=%.2f)", radius);
    }
}
