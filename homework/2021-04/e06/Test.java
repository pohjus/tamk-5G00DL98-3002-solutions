/**
 * @author Viljami Pietarila
 */

class Test {
    public static void main(String [] args) {
        Bird b = new Bird();

        class Airplane implements Flyable {
            public void fly() {
                System.out.println("Airplane flies");
            }
        }
        Airplane a = new Airplane();

        fly(a);
        fly(b);

        fly(() -> System.out.println("lambda flies"));
    }
    public static void fly(Flyable f) {
        f.fly();
    }
}
