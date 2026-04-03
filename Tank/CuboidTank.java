package EGE.prog2.Tank;

import java.util.Collections;
import java.util.Iterator;

public class CuboidTank extends Tank{
    private final double width, height, depth;

    public CuboidTank(double width, double height, double depth) {
        this.width  = width;
        this.height = height;
        this.depth  = depth;
    }

    @Override
    public double getVolume() {
        return width * height * depth;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * (width*height + height*depth + width*depth);
    }

    @Override
    public Iterator<Tank> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public CuboidTank clone() {
        // All fields are primitives → shallow copy suffices
        return new CuboidTank(width, height, depth);
    }

    @Override
    public String toString() {
        return String.format("Cuboid(%.2f×%.2f×%.2f)", width, height, depth);
    }
}
