package dev.zevolution.pocquarkusjob.internal.entities;

import java.util.Objects;

public class Author {

    private String userName;
    private String name;
    private String avatarUrl;

    public Author() {

    }

    public Author(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Author setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Author setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(userName, author.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

}
