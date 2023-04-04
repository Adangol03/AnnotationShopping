package main;

import connectionToDb.ToDB;
import entity.Customer;
import entity.Product;
import services.Service;
import services.Shop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        Customer customer = new Customer();
        Service service = new Service();
        ToDB toDB = new ToDB();

        Product productArr[]=new Product[Shop.MAX_PRODUCT_ITEMS];

        service.takeProductInfo(product, scanner, toDB);
        service.takeCustomerInfo(customer, scanner, toDB);
        service.showOptionsTOChoose(toDB,productArr,scanner,customer,product);

        scanner.close();
    }
}