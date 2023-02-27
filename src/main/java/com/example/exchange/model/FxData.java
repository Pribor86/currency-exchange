package com.example.exchange.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fx_data")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FxData {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type_name;
    private String curr_date;
    private String currency;
    private BigDecimal amount;
}
