/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Entity;

/**
 *
 * @author DAO
 */

import java.io.Serializable;
import java.util.Objects;

public class RequestCategoryKey implements Serializable {
    private int requestId;
    private int categoryId;

    public RequestCategoryKey() {}

    public RequestCategoryKey(Request request, Category category) {
        this.requestId = request.getRequestId();
        this.categoryId = category.getCategoryId();
    }

    // Override equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestCategoryKey that = (RequestCategoryKey) o;
        return requestId == that.requestId && categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, categoryId);
    }
}

