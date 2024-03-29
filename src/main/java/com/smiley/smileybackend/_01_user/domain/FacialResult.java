package com.smiley.smileybackend._01_user.domain;

import com.smiley.smileybackend._01_user.domain.User;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.awt.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class FacialResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_number", foreignKey = @ForeignKey(name = "fk_facialresult_user"))
    private User user;

    @Column
    private OffsetDateTime date;

    @Column(length = 200)
    private String imageUrl;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<Point> faceContours;

    @Column
    private Double eyesDegree;

    @Column
    private Double lipsDegree;

}
