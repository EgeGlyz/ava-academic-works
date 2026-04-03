package EGE.prog2.Tank;


import java.util.Collections;
import java.util.Iterator;

public class CylindricalTank extends Tank {
    private final double radius, height;
    private static final double PI = Math.PI;

    public CylindricalTank(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return PI * radius * radius * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * PI * radius * height + 2 * PI * radius * radius;
    }

    @Override
    public Iterator<Tank> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public CylindricalTank clone() {
        return new CylindricalTank(radius, height);
    }

    @Override
    public String toString() {
        return String.format("Cylinder(r=%.2f,h=%.2f)", radius, height);
    }
}
