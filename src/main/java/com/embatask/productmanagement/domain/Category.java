package com.embatask.productmanagement.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID")
    private int categoryID;
    @Column(name = "categoryName")
    private String categoryName;
//    @Column(name = "parentCategoryID")
//    private int parentCategoryID;
@ToString.Exclude
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentCategoryID", referencedColumnName = "categoryID")
    private Category parentCategoryID;
    @ToString.Exclude
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "parentCategoryID")
    private List<Category> categories;
    @ToString.Exclude
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> productList;

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
