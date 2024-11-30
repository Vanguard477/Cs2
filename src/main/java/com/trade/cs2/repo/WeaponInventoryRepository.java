package com.trade.cs2.repo;

import com.trade.cs2.models.WeaponInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponInventoryRepository extends JpaRepository<WeaponInventory, Long> {
}
