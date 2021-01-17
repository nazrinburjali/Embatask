package com.embatask.productmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.annotation.Target;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageID")
    private int imageID;
    @Column(name = "imageName")
    private String imageName;
    @Column(name = "localUrl")
    private String localUrl;

    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Product product;
}
