package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity(name = "order")
@Table(name = "order")
public class OrderEntity {
    private String id;
    private Integer netTotal;
    // Many-to-one relationship
    @ManyToOne
    @JoinColumn(name = "customer_id") //  foreign key column
    private CustomerEntity customer;
}
