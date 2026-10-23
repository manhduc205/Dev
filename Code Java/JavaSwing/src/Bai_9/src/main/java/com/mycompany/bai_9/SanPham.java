package com.mycompany.bai_9;

import java.io.Serializable;

public class SanPham implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productId;
    private String productName;
    private float unitPrice;
    private int quantity;
    private String description;
    private int categoryId;
    private String categoryName;

    public SanPham() {}

    public SanPham(String productId, String productName, float unitPrice, int quantity,
                   String description, int categoryId, String categoryName) {

        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.description = description;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getUnitPrice() { return unitPrice; }
    public void setUnitPrice(float unitPrice) { this.unitPrice = unitPrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    @Override
    public String toString() {
        return productId + " - " + productName;
    }
}
