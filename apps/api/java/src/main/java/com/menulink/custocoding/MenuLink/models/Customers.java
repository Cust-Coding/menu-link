package com.menulink.custocoding.MenuLink.models;


import com.menulink.custocoding.MenuLink.enums.CustomerGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_customer")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String phonenumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerGender gender;

    //@Column()
    //private LocalDateTime registered;


}
