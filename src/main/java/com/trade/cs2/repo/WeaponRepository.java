package com.trade.cs2.repo;

import com.trade.cs2.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository <Weapon, Long>{

}
