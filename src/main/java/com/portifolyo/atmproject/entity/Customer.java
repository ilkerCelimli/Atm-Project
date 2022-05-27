package com.portifolyo.atmproject.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Customer extends BaseEntity {


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private BigDecimal balance;

    @OneToMany(mappedBy = "customer")
    Set<Transactions> transactionsSet = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
}
