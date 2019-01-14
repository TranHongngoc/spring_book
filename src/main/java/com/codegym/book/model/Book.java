package com.codegym.book.model;

import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @NotEmpty
    @Size(min = 10,max = 10)
    private String booksCode;


    @Min(0)
    private Double price;

    @Min(1)
    @Max(3)
    private int status;


    @Min(0)
    private Double discount;

    private String company;


    @Min(0)
    private Double number;

    private String description;

    public Book() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getBooksCode() {
        return booksCode;
    }

    public void setBooksCode(String booksCode) {
        this.booksCode = booksCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book(@NotEmpty @Size(min = 10, max = 10) String booksCode, @Min(0) Double price, @Min(1) @Max(3) int status, @Min(0) Double discount, String company, @Min(0) Double number, String description, Category category) {
        this.booksCode = booksCode;
        this.price = price;
        this.status = status;
        this.discount = discount;
        this.company = company;
        this.number = number;
        this.description = description;
        this.category = category;
    }

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_ID")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
