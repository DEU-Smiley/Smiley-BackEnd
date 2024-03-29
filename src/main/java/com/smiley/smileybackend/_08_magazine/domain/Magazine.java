package com.smiley.smileybackend._08_magazine.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class Magazine  implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;

    @Column(length = 200)
    private String subTitle;

    @Column(length = 20)
    private String author;

    @Column(length = 200)
    private String thumbnail;

    @Column
    private Integer likes;

    @Column
    private Integer viewCount;

    @Column
    private String urlLink;

    @Builder
    public Magazine(Integer id, String title, String subTitle, String author, String thumbnail, Integer likes, Integer viewCount, String urlLink) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.thumbnail = thumbnail;
        this.likes = likes;
        this.viewCount = viewCount;
        this.urlLink = urlLink;
    }
}
