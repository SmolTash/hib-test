package com.sample.persistence;

import javax.persistence.*;

@Entity
@Table(name = "SAMPLE")
public class Sample {

    @Id
    //@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITLE")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}