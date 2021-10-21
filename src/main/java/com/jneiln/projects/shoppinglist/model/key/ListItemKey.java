package com.jneiln.projects.shoppinglist.model.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListItemKey implements Serializable {

    @Column(name = "LIST_ID")
    private String listId;

    @Column(name = "ITEM_ID")
    private String itemId;

    public ListItemKey(String listId, String itemId) {
        this.listId = listId;
        this.itemId = itemId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListItemKey that = (ListItemKey) o;
        return listId.equals(that.listId) && itemId.equals(that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId, itemId);
    }
}
