package com.liqiang.pumpkin.boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private Long id;

  @Column
  private String username;

  @Column
  private String name;

  @Column
  private Integer age;

  @Column
  private BigDecimal balance;

}
