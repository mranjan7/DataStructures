package Week4;

import java.util.Date;

/**
 * Created by mranjan on 11/10/17.
 */
public abstract class Document {

    private String title;
    private String author;
    private Date date;
    private PublishingLocation publishingLocation;

    public Document(String title, String author, Date date, PublishingLocation publishingLocation) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.publishingLocation = publishingLocation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PublishingLocation getPublishingLocation() {
        return publishingLocation;
    }

    public void setPublishingLocation(PublishingLocation publishingLocation) {
        this.publishingLocation = publishingLocation;
    }
    public String getCity() {
        return publishingLocation.getCity();
    }

    public String getState() {
        return publishingLocation.getState();
    }

    public String getPostCode() {
        return publishingLocation.getPostCode();
    }

    public int compareWithGeneralDate(Date date){
        return this.date.compareTo(date);
    }

    public boolean sameAuthor(Document document){
        return this.author.equals(document.author);
    }

    public int compareDates(Document document){
        return this.date.compareTo(document.date);
    }
}
