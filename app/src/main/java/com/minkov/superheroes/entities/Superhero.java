package com.minkov.superheroes.entities;

public class Superhero {
    private Long id;
    private String name;
    private String secretIdentity;

    public Superhero() {
        // Empty constructor needed for ORM and model mappings
    }

    public Superhero(String name, String secretIdentity) {
        this(-1, name, secretIdentity);
    }

    public Superhero(long id, String name, String secretIdentity) {
        setId(id);
        setName(name);
        setSecretIdentity(secretIdentity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }
}
