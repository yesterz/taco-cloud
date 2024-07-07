package com.yesterz.taco_cloud.data;

import com.yesterz.taco_cloud.TacoOrder;

public interface OrderRepository {
  TacoOrder save(TacoOrder order); // abstract method
}
