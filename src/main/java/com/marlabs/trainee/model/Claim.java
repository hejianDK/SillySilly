package com.marlabs.trainee.model;

import javax.persistence.*;

/**
 * Created by Rico on 6/29/15.
 */
@Entity
@Table (name = "test1")
public class Claim {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String title;

    public Claim(long id, String name){
        this.id = id;
        this.title = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
