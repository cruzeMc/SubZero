package Model;

/**
 * Created by Cruze on 1/27/2017.
 */

public class Product {
    public String title;
    public String price;
    public int image;
    public String description;
    public boolean selected;

    public Product(String title, String price, int image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public Product(String title, String price, int image, String description, boolean selected) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.description = description;
        this.selected = selected;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
