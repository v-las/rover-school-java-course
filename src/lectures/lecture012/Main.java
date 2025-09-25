package lectures.lecture012;

public class Main {
    public static void main(String[] args) {
//        Dog rex = new GermanShepherd();
//        rex.eat();
//        rex.voice();
//        rex.protect();

//        GermanShepherd rex2 = rex;
//        rex.protect();


        System.out.println();

        GermanShepherd rex = new GermanShepherd();
        Chihuahua chiChi = new Chihuahua();
        Husky husky = new Husky();

//        feedDogs(new Dog[] {rex, chiChi, husky});

        PetOwner me = new PetOwner();

        me.feed(rex);
        me.feed(chiChi);
        me.feed(husky);
        me.feed(new Husky());
    }

    public static void feedDogs(Dog[] dogs) {
        for (Dog dog : dogs) {
            dog.eat();
        }
    }
}
