package org.example.steamgameservice.entity;

import lombok.Data;

@Data
public class Review {
    private String userId;
    private String comment;
    private int rating;
}
