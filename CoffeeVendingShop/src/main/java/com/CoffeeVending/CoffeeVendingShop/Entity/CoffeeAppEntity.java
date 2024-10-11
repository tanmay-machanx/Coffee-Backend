package com.CoffeeVending.CoffeeVendingShop.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class CoffeeAppEntity {

    @Id
    private String id;
    private String Title;
    private String Description;
    private int Priority; //Low Priority (-1), Medium (0),
    private int Amount;
    private int Status; //Pending(0), Completed(1), Cancelled (2), Rejected(3)
    private String CreateDate;
    private String CreateTime;
    public int getStatus() {
        return Status;
    }
    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public void setStatus(int status) {
        Status = status;
    }



    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
