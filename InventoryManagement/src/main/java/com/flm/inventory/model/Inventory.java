package com.flm.inventory.model;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "inventory")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long inventoryId;
	
	private long productId;
	
	private int availableQuantity;
	
	private int reserveQuantity;
	
	private String warehouse;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	private String createdBy;
	
	private String updatedBy;

	public Inventory(long productId, int availableQuantity, int reserveQuantity, String warehouse,
			LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
		super();
		this.productId = productId;
		this.availableQuantity = availableQuantity;
		this.reserveQuantity = reserveQuantity;
		this.warehouse = warehouse;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	
	
}
