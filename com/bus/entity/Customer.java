package com.bus.entity;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@Data
@ToString
public class Customer {
   private Integer id;
   private String cusName;
   private String Address;
   private String contact;
   private String tel;
   private String email;
   private User user;

   private String empoleename;
   private Integer empoleeid;

   private HashMap<String ,Integer> map;

   public Customer() {
   }

   public Customer(Integer id) {
      this.id = id;
   }

   public Customer(String cusName, String address, String contact, String tel, String email) {
      this.cusName = cusName;
      Address = address;
      this.contact = contact;
      this.tel = tel;
      this.email = email;
   }

   public Customer(Integer id, String cusName, String address, String contact, String tel, String email) {
      this.id = id;
      this.cusName = cusName;
      Address = address;
      this.contact = contact;
      this.tel = tel;
      this.email = email;
   }
}
