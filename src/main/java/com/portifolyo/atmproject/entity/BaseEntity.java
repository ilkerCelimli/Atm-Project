package com.portifolyo.atmproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseEntity {



    @Id
    @GenericGenerator(strategy = "uuid3",name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdDate;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedDate;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date deletedDate;

    private Boolean isDeleted;

}
