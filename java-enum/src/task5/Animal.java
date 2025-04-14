package task5;

public enum Animal {

    DOG("Woof", 998) {
        @Override
        public void showFunFact() {
            System.out.println("Dogs are loyal!");
        }
    },
    CAT("Meow", 997) {
        @Override
        public void showFunFact() {
            System.out.println("Cats are jerks!");
        }
    };

    private int lifespan = 999;
    private String voice = "ABC";

    Animal(String voice, int lifespan) {
        this.voice = voice;
        this.lifespan = lifespan;
    }

    public void makeVoice() {
        System.out.println(this.voice);
    }

    public void showFunFact() {
        System.out.println("Animals are cute!");
    }

}
