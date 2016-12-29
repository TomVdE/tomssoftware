package be.tvde.innerclasses.static_member_class;

/**
 * Created by tomvde on 27/12/2016.
 */
public class ComputerAccessory {

    public static class Monitor {
        private int size;

        public Monitor(int size) {
            this.size = size;
        }

        public String toString() {
            return "Monitor - Size: " + this.size + " inch";
        }
    }

    public static class Keyboard {
        private int keys;

        public Keyboard(int keys) {
            this.keys = keys;
        }

        public String toString() {
            return "Keyboard - Keys:" + this.keys;
        }
    }
}
