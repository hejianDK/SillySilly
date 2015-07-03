package com.marlabs.trainee.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rico on 6/29/15.
 */
@Entity
@Table(name = "test")
public class Claim implements Serializable {

    @Id
    @Column(name = "CLAIM_ID")
    @GeneratedValue
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public Claim(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public long getId (){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
