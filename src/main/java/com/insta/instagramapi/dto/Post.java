package com.insta.instagramapi.dto;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String caption;
    private String image;
    private String location;
    private LocalDateTime createdAt;
    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name="id",column=@Column(name="user_id")),
                    @AttributeOverride(name="email",column=@Column(name="user_email"))


            }
    )
    private UserDto user;
    @OneToMany
    private List<Comment> commments = new ArrayList<Comment>();

    @Embedded
    @ElementCollection
    @JoinTable(name="likedByUsers",joinColumns = @JoinColumn(name="user_id"))
    private HashSet<UserDto> likedByUsers = new HashSet<>();

    public Post(Integer id, String caption, String image, String location, LocalDateTime createdAt, UserDto user, List<Comment> commments, HashSet<UserDto> likedByUsers) {
        this.id = id;
        this.caption = caption;
        this.image = image;
        this.location = location;
        this.createdAt = createdAt;
        this.user = user;
        this.commments = commments;
        this.likedByUsers = likedByUsers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<Comment> getCommments() {
        return commments;
    }

    public void setCommments(List<Comment> commments) {
        this.commments = commments;
    }

    public HashSet<UserDto> getLikedByUsers() {
        return likedByUsers;
    }

    public void setLikedByUsers(HashSet<UserDto> likedByUsers) {
        this.likedByUsers = likedByUsers;
    }
}
