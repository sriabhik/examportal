package com.exam.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    private String title;
    @Column(length = 1000)
    private String description;
//fetch = FetchType.EAGER, this is replace in belwo code because of mapping issue
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz> set = new LinkedHashSet<>();

    public Category() {
    }

    public Category(Long cid, String title, String description, Set<Quiz> set) {
        this.cid = cid;
        this.title = title;
        this.description = description;
        this.set = set;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Quiz> getSet() {
        return set;
    }

    public void setSet(Set<Quiz> set) {
        this.set = set;
    }
}
