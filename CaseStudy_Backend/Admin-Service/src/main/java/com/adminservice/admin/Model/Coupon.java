package com.adminservice.admin.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Coupons")
public class Coupon {

	@Transient
	public static final String SEQUENCE_NAME = "coupon_sequence";
	
    @Id
    private int id;
    private String provider;
    private String code;
    private String category;
    private String description;
    private String expiryDate;

    public Coupon() {
    }

    public Coupon(int id, String provider, String code, String category, String description, String expiryDate) {
        super();
        this.id = id;
        this.provider = provider;
        this.code = code;
        this.category = category;
        this.description = description;
        this.expiryDate = expiryDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int i) {
        this.id = i;
    }
    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
