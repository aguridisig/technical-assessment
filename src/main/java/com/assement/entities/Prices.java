package com.assement.entities;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Prices
{
    @Id
    private int id;
    private int branchId;
    private int productId;
    private int priority;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;
    private String curr;
}
