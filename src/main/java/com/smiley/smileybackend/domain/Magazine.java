package com.smiley.smileybackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smiley.smileybackend.dto.user.ContentLinkJsonDto;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
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

    @Column(columnDefinition = "json")
    @Type(type = "json")
    @JsonIgnore
    private List<ContentLinkJsonDto> mainContent;

    @Builder
    public Magazine(Integer id, String title, String subTitle, String author, String thumbnail, Integer likes, Integer viewCount, List<ContentLinkJsonDto> mainContent) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.thumbnail = thumbnail;
        this.likes = likes;
        this.viewCount = viewCount;
        this.mainContent = mainContent;
    }
}
