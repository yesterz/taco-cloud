package com.yesterz.taco_cloud.data;

import com.yesterz.taco_cloud.TacoOrder;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
  // TacoOrder save(TacoOrder order); // abstract method
  List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
