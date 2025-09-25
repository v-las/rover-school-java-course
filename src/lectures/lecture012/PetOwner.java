package lectures.lecture012;

public class PetOwner {
    public void feed(Dog dog) {
        System.out.println("getting regular food");
        dog.eat();
    }

    public void feed(Chihuahua chihuahua) {
        System.out.println("getting expensive food");
        chihuahua.eat();
    }
}
