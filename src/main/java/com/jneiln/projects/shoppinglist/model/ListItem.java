package com.jneiln.projects.shoppinglist.model;

import com.jneiln.projects.shoppinglist.model.key.ListItemKey;

import javax.persistence.*;
import java.util.Objects;

public class ListItem {

    @EmbeddedId
    private ListItemKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "LIST_ID")
    private ShoppingList shoppingList;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Column
    private int quantity;

    public ListItem(ShoppingList shoppingList, Item item, int quantity) {
        this.shoppingList = shoppingList;
        this.item = item;
        this.quantity = quantity;
        this.id = new ListItemKey(shoppingList.getId(), item.getId());
    }

    public ListItemKey getId() {
        return id;
    }

    public void setId(ListItemKey id) {
        this.id = id;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListItem listItem = (ListItem) o;
        return id.equals(listItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
