package services;

import connectionToDb.ToDB;
import entity.Customer;
import entity.Product;

import java.util.Scanner;

public class Service {

    public void takeProductInfo(Product product, Scanner scanner, ToDB toDB) {

        System.out.println("--------------VENDOR------------------");
        for (int a = 0; a < Shop.MAX_PRODUCT_ITEMS; a++) {
            System.out.println("Enter product name::");
            String name = scanner.next();
            product.setProductName(name);
            System.out.println("Enter category for the product::");
            String category = scanner.next();
            product.setProductCategory(category);
            System.out.println("Enter the price for the product::");
            double price = scanner.nextDouble();
            product.setProductPrice(price);
            System.out.println("Enter the brand of the product::");
            String brand = scanner.next();
            product.setProductBrand(brand);


            toDB.setProductInfo(product);
        }
    }

    public void takeCustomerInfo(Customer customer, Scanner scanner, ToDB toDB) {

        System.out.println("------------CUSTOMER-----------------");
        System.out.println("Enter Name::");
        String name = scanner.next();
        customer.setCustomerName(name);
        System.out.println("enter year of DOB::");
        int dob = scanner.nextInt();
        if (checkDOB(dob)) {
            customer.setCustomerDOBYear(dob);
        } else {
            System.err.println("terminating the programme");
            System.exit(0);
        }
        System.out.println("Enter Location::");
        String location = scanner.next();
        customer.setCustomerLocation(location);
        int count = 0;
        do {
            System.out.println("Enter mobile number::");
            long mobile = scanner.nextLong();
            if (validateMobile(mobile)) {
                customer.setCustomerMobile(mobile);
                break;
            } else {
                System.err.println("invalid, try again");
                count++;
            }
        } while (count < 3);
        System.out.println("Enter email address::");
        String email = scanner.next();
        customer.setCustomerEmail(email);


        //toDB.seCustomerInfo(customer);
    }

    public boolean checkDOB(int dob) {
        if (dob != 0 && dob < 2005) {
            return true;
        }
        return false;
    }

    public boolean validateMobile(long mob) {
        if (mob != 0 && String.valueOf(mob).length() == 10) {
            return true;
        }
        return false;
    }


    public void showOptionsTOChoose(ToDB toDB, Product[] productArr, Scanner scanner, Customer customer, Product product) {
        for (int i = 0; i < Shop.MAX_PRODUCT_ITEMS; i++) {
            productArr[i] = toDB.fetchProduct(i + 1);
        }
        for (Product arr : productArr) {
            System.out.println(" " + arr.getProductName() + " " + arr.getProductBrand() + " " + arr.getProductCategory() + " " + arr.getProductPrice());
        }
        System.out.println("Enter your choice as product name or brand::");
        String choice = scanner.next();
        for (int a = 0; a < Shop.MAX_PRODUCT_ITEMS; a++) {
            if (choice.equalsIgnoreCase(productArr[a].getProductName()) || choice.equalsIgnoreCase(productArr[a].getProductBrand())) {
                customer.setChoice(choice);
                Product selectedProduct = toDB.fetchProduct(a + 1);
                customer.setProduct(selectedProduct);
                break;
            }
        }
        toDB.seCustomerInfo(customer);

    }

}
