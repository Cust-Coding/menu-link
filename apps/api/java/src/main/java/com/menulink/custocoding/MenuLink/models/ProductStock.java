package com.menulink.custocoding.MenuLink.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<Products> products;

    //@Column()
    //private LocalDateTime updated;

}
