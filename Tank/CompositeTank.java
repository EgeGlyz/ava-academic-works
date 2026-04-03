package EGE.prog2.Tank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeTank extends Tank{
    private final List<Tank> parts = new ArrayList<>();

    /** Add a sub-tank */
    public void add(Tank t) {
        parts.add(t);
    }

    /** Remove a sub-tank */
    public boolean remove(Tank t) {
        return parts.remove(t);
    }

    @Override
    public double getVolume() {
        double sum = 0;
        for (Tank t : parts) sum += t.getVolume();
        return sum;
    }

    @Override
    public double getSurfaceArea() {
        double sum = 0;
        for (Tank t : parts) sum += t.getSurfaceArea();
        return sum;
    }

    @Override
    public Iterator<Tank> iterator() {
        return parts.iterator();
    }

    @Override
    public CompositeTank clone() {
        CompositeTank copy = new CompositeTank();
        for (Tank t : parts) {
            copy.add(t.clone());  // deep copy each part
        }
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CompositeTank {\n");
        for (Tank t : parts) {
            sb.append("  ").append(t).append("\n");
        }
        sb.append(String.format("} TotalVol=%.2f m³, TotalSA=%.2f m²",
                getVolume(), getSurfaceArea()));
        return sb.toString();
    }
}
