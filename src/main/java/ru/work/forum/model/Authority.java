package ru.work.forum.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    public Authority() {
    }

    public static Authority of(String authority) {
        Authority authorityNew = new Authority();
        authorityNew.setAuthority(authority);
        return authorityNew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Authority authorityNew = (Authority) o;
        return authority == authorityNew.authority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority);
    }


}
