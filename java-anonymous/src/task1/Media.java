package task1;

public abstract class Media {

    private String mediaType;
    private String description;

    private Playable anonImplementation;

    public Media(String mediaType, String description) {
        this.mediaType = mediaType;
        this.description = description;
        this.anonImplementation = null;
    }

    public abstract void interactWithMedia();

    public void showMediaDescription() {
        System.out.println("Type: " + mediaType);
        System.out.println("Description: " + description);
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getDescription() {
        return description;
    }

    public Playable getAnonImplementation() {
        return anonImplementation;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAnonImplementation(Playable anonImplementation) {
        this.anonImplementation = anonImplementation;
    }
}
