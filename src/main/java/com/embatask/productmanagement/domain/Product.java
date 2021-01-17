package com.embatask.productmanagement.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Image> imageList;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
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
