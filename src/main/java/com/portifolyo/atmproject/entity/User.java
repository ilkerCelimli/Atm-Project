package com.portifolyo.atmproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date birtday;
    @Column
    private String roles;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String secretQuestion;
    @Column
    private String secretAnswer;


}
