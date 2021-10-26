package com.jneiln.projects.shoppinglist.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "USER_GROUP")
public class Group {

    @Id
    @Column
    @GeneratedValue
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<ShoppingList> shoppingLists;

    @ManyToMany
    @JoinTable(
            name = "GROUP_MEMBER",
            joinColumns = @JoinColumn(name = "GROUP_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    Set<User> groupUsers;

    public Group(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(Set<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }

    public Set<User> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(Set<User> groupUsers) {
        this.groupUsers = groupUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id.equals(group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
