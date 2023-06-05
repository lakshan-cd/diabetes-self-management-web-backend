package com.technocrats.knowladgesharing.backend.service;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CategoryCount {
    //to hold the count of posts
    private String catergory;
    private int count;

//    public CategoryCount(String catergory, int count) {
//        this.catergory = catergory;
//        this.count = count;
//    }
}
