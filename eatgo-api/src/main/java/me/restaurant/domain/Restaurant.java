package me.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String information;

    @Transient // 임시로 사용하는 것이라는 것을명시해주는것
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant() {

    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.information = name + " in " + address;
    }

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.information = name + " in " + address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String information() {
        return name + " in " + address;
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItem(List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            this.menuItems.add(menuItem);
        }
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
