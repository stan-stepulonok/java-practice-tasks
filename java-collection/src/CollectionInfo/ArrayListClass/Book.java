package CollectionInfo.ArrayListClass;

public class Book {

    private String name;
    private String author;

    Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return String.format("Name: %s; Author: %s", name, author);
    }

}
