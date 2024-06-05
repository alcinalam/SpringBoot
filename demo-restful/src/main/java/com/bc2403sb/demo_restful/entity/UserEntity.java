package com.bc2403sb.demo_restful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// JPA will generate the DDL (create Table) by the defination in Entity Class
@Entity
@Table(name = "Users")
@Getter
public class UserEntity {
  
  @Id // Table Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
  private Long id; // must be Wrapper class
  private String name;
  @Column(name = "user_name")
  private String username;
  @Setter
  private String email;
  private String phone;
  private String website;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "company_catch_phrase")
  private String companyCatchPhrase;
  @Column(name = "company_bs")
  private String companyBS;
  @Column(name = "addr_street")
  private String addrStreet;
  @Column(name = "addr_suite")
  private String addrSuite;
  @Column(name = "addr_city")
  private String addrCity;
  @Column(name = "addr_zipcode")
  private String addrZipcode;
  @Column(name = "addr_latitude")
  private String addrLatitude;
  @Column(name = "addr_longtitude")
  private String addrLongitude;


}
