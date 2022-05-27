package com.portifolyo.atmproject.entity;

import com.portifolyo.atmproject.enums.TransactionTypes;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Transactions extends BaseEntity {



    @Column
    @Enumerated(value = EnumType.STRING)
    private TransactionTypes transactionTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    public Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    public Customer targetAccount;



}
