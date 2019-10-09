package com.example.catalog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Size(min=5, max=100)
    private String productName;

    @Size(min=5, max=10)
    private String usoc;

    private String regionCode;

    @Size(min=2, max=2)
    private String stateCode;

    @Size (min=1,max=1)
    private String available ;
}






