package com.app.jdbc.smartrecruit.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String price;
    private String category;
    private LocalDate createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "createdBy", nullable = false) // Foreign key column
    private User createdBy;
    @OneToMany(mappedBy = "attachedOffer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> attachedEmployees;

    public Offer() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public User getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
    public void setAttachedEmployees(List<Employee> attachedUsers) {
        this.attachedEmployees = attachedUsers;
    }
    public List<Employee> getAttachedEmployees() {
        return attachedEmployees;
    }

}
