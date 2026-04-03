package EGE.prog2.Tank;

import java.util.Iterator;

    public abstract class Tank implements Iterable<Tank> {
        public abstract double getVolume();

        public abstract double getSurfaceArea();

        public abstract Tank clone();
    }

