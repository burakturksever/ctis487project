package com.aytugburak.peopleperson.classes;

public class Contact {
    private String name;
    private String surname;
    private String birthDate;
    private String category;
    private boolean favorited;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCategory() {
        return category;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public Contact(String name, String surname, String birthDate, String category, boolean favorited) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.category = category;
        this.favorited = favorited;
    }

    // for debugging, getters and setters will be used mostly

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", category='" + category + '\'' +
                ", favorited=" + favorited +
                '}';
    }
}

