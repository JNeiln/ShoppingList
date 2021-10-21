package com.jneiln.projects.shoppinglist.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SHOPPING_LIST")
public class ShoppingList {

    @Id
    @Column
    @GeneratedValue
    private String id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    private Group group;

    public ShoppingList(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingList that = (ShoppingList) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
