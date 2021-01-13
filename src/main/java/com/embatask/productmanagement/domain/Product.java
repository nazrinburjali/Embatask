package com.embatask.productmanagement.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private int productID;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productDescription")
    private String productDescription;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName=" + productName +
                ", productDescription=" + productDescription +
                '}';
    }
}
