package com.example.e2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9]{1,799}$",message = "không được phép quá 800 kí tự và chứa các kí tự đặc biệt như @,;=.-")
    private String name;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9]{1,299}$",message = "không được phép quá 300 kí tự và chứa các kí tự đặc biệt như @,;=.-")
    private String artist;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9,]{1,999}$",message = "không được phép quá 1000 kí tự và chỉ chứa kí tự đặc biệt là dấu,")
    private String category;

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
