package com.demo_jpa_c04.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 0, message = "Giá phải >= 0")
    private int price;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^T\\d+$", message = "sai dinh dang")
    @Size(min = 5, message = "Tên phải lớn hơn 5 ký tự")
    private String name;

    private String img;
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(int id, int price, String name, String img, Category category) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.img = img;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
