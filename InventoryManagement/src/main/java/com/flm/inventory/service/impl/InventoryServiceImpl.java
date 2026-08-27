package com.flm.inventory.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.inventory.builder.InventoryBuilder;
import com.flm.inventory.dao.InventoryRepository;
import com.flm.inventory.dto.request.InventoryCreateRequest;
import com.flm.inventory.dto.request.InventoryUpdateRequest;
import com.flm.inventory.dto.response.InventoryResponse;
import com.flm.inventory.model.Inventory;
import com.flm.inventory.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Override
	public InventoryResponse save(InventoryCreateRequest inventoryCreateRequest) {

		Inventory inventory = InventoryBuilder.buildInventoryFromInventoryCreateRequest(inventoryCreateRequest);
		
		Inventory savedInventory = inventoryRepository.save(inventory);
		
		return InventoryBuilder.buildInventoryResponseFromInventory(savedInventory);
	}

	@Override
	public List<InventoryResponse> getAllInventories() {

		return inventoryRepository
				.findAll()
				.stream()
				.map(InventoryBuilder::buildInventoryResponseFromInventory)
				.toList();
		
	}

	@Override
	public InventoryResponse getInventoryById(long inventoryId) {

		Inventory inventory = inventoryRepository.findById(inventoryId)
							.orElseThrow(() -> new RuntimeException("Inventory is not found by ID: " + inventoryId));
		
		return InventoryBuilder.buildInventoryResponseFromInventory(inventory);
	}

	@Override
	public InventoryResponse update(long inventoryId, InventoryUpdateRequest inventoryUpdateRequest) {

		Inventory existingInventory = inventoryRepository.findById(inventoryId)
								.orElseThrow(() -> new RuntimeException("Inventory is not found with ID: " + inventoryId));
		
		Inventory inventory = InventoryBuilder.buildInventoryFromInventoryUpdateRequest(existingInventory, inventoryUpdateRequest);
		
		Inventory savedInventory = inventoryRepository.save(inventory);
		
		return InventoryBuilder.buildInventoryResponseFromInventory(savedInventory);
	}

	@Override
	public void delete(long inventoryId) {

		if(!inventoryRepository.existsById(inventoryId)) {
			throw new RuntimeException("Inventory not found with ID: " + inventoryId);
		}
		
		inventoryRepository.deleteById(inventoryId);
	}
	
}
