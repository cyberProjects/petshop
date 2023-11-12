package com.scottapps.petshop.shared.dao.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private Long id;

    @Column(name = "app_id")
    private String appId;

    public Transaction() {}

    public Transaction(String appId) {
        this.appId = appId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", appId='" + appId + '\'' +
                '}';
    }
}
