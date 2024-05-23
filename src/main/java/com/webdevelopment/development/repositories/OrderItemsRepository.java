package com.webdevelopment.development.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.webdevelopment.development.entity.OrderItems;
import com.webdevelopment.development.entity.pk.OrderItemPK;

public interface OrderItemsRepository extends JpaRepository<OrderItems, OrderItemPK> {
}
