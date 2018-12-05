package com.minkov.superheroes.entities;

import javax.persistence.*;

@Entity(name = "superheroes")
@Table(name = "superheroes")
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Column(name = "secret_identity", nullable = false)
    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }
}
