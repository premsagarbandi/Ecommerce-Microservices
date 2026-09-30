package com.flm.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.delivery.builder.DeliveryBuilder;
import com.flm.delivery.client.OrderClient;
import com.flm.delivery.dao.DeliveryRepository;
import com.flm.delivery.dto.request.DeliveryCreateRequest;
import com.flm.delivery.dto.request.DeliveryUpdateRequest;
import com.flm.delivery.dto.response.DeliveryResponse;
import com.flm.delivery.dto.response.OrderResponse;
import com.flm.delivery.model.Delivery;
import com.flm.delivery.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	OrderClient orderClient;
	
	@Override
	public DeliveryResponse assignDelivery(DeliveryCreateRequest deliveryCreateRequest) {

		Delivery delivery = DeliveryBuilder.buildDeliveryFromDeliveryCreateRequest(deliveryCreateRequest);
		
		Delivery savedDelivery = deliveryRepository.save(delivery);
		
		return DeliveryBuilder.buildDeliveryResponseFromDelivery(savedDelivery);
	}

	@Override
	public List<DeliveryResponse> getAllDeliveries() {

		return deliveryRepository
							.findAll()
							.stream()
							.map(DeliveryBuilder::buildDeliveryResponseFromDelivery)
							.toList();
	}

	@Override
	public DeliveryResponse getDeliveryById(long deliveryId) {

		Delivery delivery = deliveryRepository.findById(deliveryId)
							.orElseThrow(()-> new RuntimeException("Delivery not found with ID: " + deliveryId));
		
		DeliveryResponse deliveryResponseFromDTO = DeliveryBuilder.buildDeliveryResponseFromDelivery(delivery);
		
		OrderResponse orderResponse = orderClient.getOrderById(deliveryResponseFromDTO.getOrderId());
		deliveryResponseFromDTO.setOrderPrice(orderResponse.getTotalPrice());
		
		return deliveryResponseFromDTO;
	}

	@Override
	public DeliveryResponse updateDelivery(long deliveryId, DeliveryUpdateRequest deliveryUpdateRequest) {

		Delivery exisitingDelivery = deliveryRepository.findById(deliveryId)
							.orElseThrow(()-> new RuntimeException("Delivery not found with ID: " + deliveryId));
		
		Delivery delivery = DeliveryBuilder.buildDeliveryFromDeliveryUpdateRequest(exisitingDelivery, deliveryUpdateRequest);
		
		Delivery savedDelivery = deliveryRepository.save(delivery);
		
		return DeliveryBuilder.buildDeliveryResponseFromDelivery(savedDelivery);
	}

	@Override
	public void deleteDelivery(long deliveryId) {

		if(!deliveryRepository.existsById(deliveryId)) {
			throw new RuntimeException("Delivery not found with ID: " + deliveryId);
		}
		
		deliveryRepository.deleteById(deliveryId);
	}
	
}
