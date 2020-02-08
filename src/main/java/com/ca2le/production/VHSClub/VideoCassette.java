package com.ca2le.production.VHSClub;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity

public class VideoCassette {

    private @Id @GeneratedValue Long id;
    private String title;

    public VideoCassette(){}

    VideoCassette(String title) {
        this.title = title;
    }
}
