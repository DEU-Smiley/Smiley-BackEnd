package com.smiley.smileybackend.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@ToString(exclude = {"user","hospital"})
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private OffsetDateTime reservDate;

    @Column(length = 500)
    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_booking_user"))
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumns({
            @JoinColumn(name = "hPid", foreignKey = @ForeignKey(name = "fk_booking_hospital")),
            @JoinColumn(name = "is_partner"),
    })
    private Hospital hospital;

    @Builder
    public Booking(Integer id, OffsetDateTime reservDate, String memo, User user, Hospital hospital) {
        this.id = id;
        this.reservDate = reservDate;
        this.memo = memo;
        this.user = user;
        this.hospital = hospital;
    }
}
