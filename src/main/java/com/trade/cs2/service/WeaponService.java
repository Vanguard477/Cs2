package com.trade.cs2.service;


import com.trade.cs2.models.Weapon;
import com.trade.cs2.repo.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeaponService {
    private final WeaponRepository weaponRepository;

    public Weapon getWeaponInventory(String name, String quality, String image) {
        Weapon weapon = new Weapon("1", "1", "1");
        return weaponRepository.save(weapon);
    }

}
