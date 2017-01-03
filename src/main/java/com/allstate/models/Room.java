package com.allstate.models;

import org.springframework.data.annotation.Id;

/**
 * Created by localadmin on 03/01/17.
 */
public class Room {
    @Id
    private String id;

    private String name;
    private int capacity;
    private boolean havingVc;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHavingVc() {
        return havingVc;
    }

    public void setHavingVc(boolean havingVc) {
        this.havingVc = havingVc;
    }


}
