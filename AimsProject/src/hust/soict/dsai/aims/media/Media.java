package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " Title: " + this.title + ", Category: " + this.category + ", Cost: " + this.cost;
    }

    @Override
    public boolean equals(Object obj) {
        // Check for null
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Media)) {
            return false;
        }

        Media otherMedia = (Media) obj;

        if (this.title == null) {
            return otherMedia.getTitle() == null;
        }

        return this.title.equalsIgnoreCase(otherMedia.getTitle());
    }
}
