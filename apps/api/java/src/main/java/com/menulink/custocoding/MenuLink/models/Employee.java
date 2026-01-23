package com.menulink.custocoding.MenuLink.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public String firstname;

    @Column(nullable = false)
    public String lastname;


    @Column(nullable = false, unique = true)
    public String email;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Employee role;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    //@Column()
    //private LocalDateTime hired;


}
