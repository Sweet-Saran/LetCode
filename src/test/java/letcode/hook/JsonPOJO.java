package letcode.hook;

import java.util.List;

public class JsonPOJO {
    public String orderId;
    public Customer customer;
    public List<Item> items;
    public String orderDate;
    public boolean isShipped;

    public static class Customer {
        public String name;
        public Contact contact;
        public List<Address> addresses;
    }

    public static class Contact {
        public String email;
        public String phone;
    }

    public static class Address {
        public String type;
        public String street;
        public String city;
        public String state;
        public String zip;
    }

    public static class Item {
        public String productId;
        public String productName;
        public int quantity;
        public double price;
        public Specifications specifications;
    }

    public static class Specifications {
        public String ram;
        public String storage;
        public String color;
        public String size;
        public String resolution;
    }
}
