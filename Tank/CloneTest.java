package EGE.prog2.Tank;

import java.util.Iterator;

public class CloneTest {
    public static void main(String[] args) {
            // 1) Build a composite with at least two simple parts
            CompositeTank original = new CompositeTank();
            Tank cube   = new CuboidTank(2, 2, 2);
            Tank sphere = new SphericalTank(1.5);
            original.add(cube);
            original.add(sphere);

            System.out.println("Original before clone:\n" + original);

            // 2) Clone the system
            CompositeTank copy = original.clone();
            System.out.println("\nCloned copy:\n" + copy);

            // 3) Remove 'sphere' from original via iterator
            Iterator<Tank> it = original.iterator();
            while (it.hasNext()) {
                Tank t = it.next();
                if (t instanceof SphericalTank) {
                    it.remove();  // remove from original
                }
            }

            System.out.println("\nOriginal after removal:\n" + original);
            System.out.println("\nCopy after original mutated (should still contain sphere):\n" + copy);
        }
    }

