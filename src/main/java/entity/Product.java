package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "category")
    private String productCategory;
    @Column(name = "price")
    private double productPrice;
    @Column(name = "brand")
    private String productBrand;
}
