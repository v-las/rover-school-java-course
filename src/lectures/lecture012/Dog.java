package lectures.lecture012;

public abstract class Dog {
    public final void eat() {
        System.out.println(getClass().getName() + " Eating");
    }

    public void voice() {
        System.out.println(getClass().getName() + " Barking");
    }
}
