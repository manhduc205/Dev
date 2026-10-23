package book;

public class Book {
    private int id;
    private String name;
    private String category;
    private String author;
    private double prize; // Tôi để double cho giá tiền

    public Book() {
    }

    public Book(int id, String name, String category, String author, double prize) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.prize = prize;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrize() { return prize; }
    public void setPrize(double prize) { this.prize = prize; }
}