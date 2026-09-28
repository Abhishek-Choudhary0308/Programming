import java.io.*;
import java.lang.reflect.Constructor;

public class Problem05_ThreadSafeSingleton {
    public static final class Singleton implements Serializable, Cloneable {
        private static final long serialVersionUID = 1L;
        private static volatile Singleton instance;

        private Singleton() {
            if (instance != null) {
                throw new IllegalStateException("Use getInstance()");
            }
        }

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Singleton instance is working.");
        }

        private Object readResolve() throws ObjectStreamException {
            return getInstance();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Cloning is not allowed");
        }
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Same instance: " + (s1 == s2));
        s1.showMessage();
    }
}