package test;

public class MammalFactory {

    public static Mammal createMammal(MammalType mammalType) {

        return switch (mammalType) {
//            case BAT -> new Bat();
//            case WHALE -> new Whale();
//            case DOG -> new Dog();
        };

    }

}
