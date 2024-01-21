package com.eperfections.inventory.product;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private double price;
    private LocalDate arrivalDate;
    private String manufacturer;
    private int quantity;

    public Product() {
    }

    public Product(long productId,
                   String productName,
                   double price,
                   LocalDate arrivalDate,
                   String manufacturer,
                   int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    public Product(String productName,
                   double price,
                   LocalDate arrivalDate,
                   String manufacturer,
                   int quantity) {
        this.productName = productName;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
