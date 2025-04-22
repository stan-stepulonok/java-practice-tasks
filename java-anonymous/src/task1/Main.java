package task1;

/*
Task: Media Management System with Anonymous Classes

You are developing a media management system that handles various types of content like books, music tracks, and movies.
The system will utilize anonymous classes to customize the behavior of media objects dynamically.

Goals of the Task
- Understand how to create and use anonymous classes with interfaces.
- Learn how to extend abstract classes anonymously.
- Practice combining interface implementation and class extension in one anonymous class.
- Use anonymous classes as arguments in method calls.
- Explore default methods in interfaces within anonymous classes.

System Components
An interface representing media that can be "played" (e.g., music, videos).
An abstract class representing general media, with a title and an abstract method to show media information.

In your main method, you'll:
Create a book using an anonymous subclass of the abstract class.
Create a music player using an anonymous class that implements the interface.
Create a movie object using a single anonymous class that both extends the abstract class and implements the interface.
Create a method that accepts an object implementing the interface, and call this method with both previously created and newly defined anonymous classes.
Optionally, use default methods from the interface within your anonymous classes.

Expected Outcome
By the end of this task, you'll be comfortable with:
Creating anonymous classes from both abstract classes and interfaces.
Embedding logic directly where objects are needed, without creating separate class files.
Passing anonymous class objects into methods.
Recognizing when anonymous classes are useful for quick, single-use behaviors.
 */

public class Main {

    public static void main(String[] args) {

        // Create a book using an anonymous subclass of the abstract class.
        Media book = new Media("Book", "Regular paper book") {
        @Override
        public void interactWithMedia() {
                System.out.println("You can read it.");
            }
        };

        // Create a music player using an anonymous class that implements the interface.
        Playable music = new Playable() {
            @Override
            public void play() {
                System.out.println("The music is on!");
            }
            @Override
            public void stop() {
                System.out.println("The music was stopped!!");
            }
            @Override
            public void pause() {
                System.out.println("The music was stopped!!");
            }
        };

        // Create a movie object using a single anonymous class that both extends the abstract class and implements the interface.
        Media movie = new Media("Movie", "4k Movie") {
            @Override
            public void interactWithMedia() {
                System.out.println("You can watch it.");
            }
        };
        Playable movieImplementation = new Playable() {
            @Override
            public void play() {
                System.out.println("The movie is on!");
            }
            @Override
            public void stop() {
                System.out.println("The movie was stopped!!");
            }
            @Override
            public void pause() {
                System.out.println("The movie was stopped!!");
            }
        };
        movie.setAnonImplementation(movieImplementation);

        // Methods
        Main.useAbstractInstance(book);
        System.out.println();
        Main.useInterfaceInstance(music);
        System.out.println();
        Main.useCompositeInstance(movie);
        System.out.println();

    }

    // Create a method that accepts an object implementing the interface, and call this method with both previously created and newly defined anonymous classes.
    public static void useInterfaceInstance(Playable instance) {
        instance.play();
        instance.stop();
        instance.pause();
        instance.mute();
    }
    public static void useAbstractInstance(Media instance) {
        instance.showMediaDescription();
        instance.interactWithMedia();
    }
    public static void useCompositeInstance(Media instance) {
        instance.getAnonImplementation().play();
        instance.getAnonImplementation().stop();
        instance.getAnonImplementation().pause();
        instance.getAnonImplementation().mute();
        instance.showMediaDescription();
        instance.interactWithMedia();
    }

}
