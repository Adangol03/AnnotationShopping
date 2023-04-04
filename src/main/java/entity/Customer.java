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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name="cust_name")
    private String customerName;
    @Column(name = "cust_dob")
    private int customerDOBYear;
    @Column(name = "cust_location")
    private  String customerLocation;
    @Column(name = "cust_mobile")
    private long customerMobile;
    @Column(name = "cust_email")
    private String customerEmail;
    @Column
    private String choice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id")
    private Product product;

}
