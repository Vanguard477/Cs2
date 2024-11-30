package com.trade.cs2.service;

import com.trade.cs2.models.Post;
import com.trade.cs2.models.Weapon;
import com.trade.cs2.models.WeaponInventory;
import com.trade.cs2.repo.PostRepository;
import com.trade.cs2.repo.WeaponInventoryRepository;
import com.trade.cs2.repo.WeaponRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeaponService {
    private final WeaponInventoryRepository weaponInventoryRepository;
    @Autowired
    private WeaponRepository weaponRepository;


    public WeaponInventory getWeaponInventoryRemove(Long id) {
        WeaponInventory weaponInventory = weaponInventoryRepository.findById(id).orElseThrow();
        weaponInventoryRepository.delete(weaponInventory);
        return weaponInventory;
    }


    public WeaponInventory getWeaponInventoryAdd(String name,  String quality, String image) {
        WeaponInventory weaponInventory = new WeaponInventory(name, quality, image);
        return weaponInventoryRepository.save(weaponInventory);
    }

    public Weapon getWeaponShopDetailInfo(Long id) {
        Optional<Weapon> weapon = weaponRepository.findById(id);
        return weapon.orElseThrow(() -> new EntityNotFoundException("Weapon not found"));
    }
    public WeaponInventory getWeaponDetailInfo(Long id) {
        Optional<WeaponInventory> weaponInventory = weaponInventoryRepository.findById(id);
        return weaponInventory.orElseThrow(() -> new EntityNotFoundException("WeaponInventory not found"));
    }

    public WeaponInventory getWeaponTradeUpdate(Long id, String name, String quality, String image) {
        WeaponInventory weaponInventory = weaponInventoryRepository.findById(id).orElseThrow();
        weaponInventory.setName(name);
        weaponInventory.setQuality(quality);
        weaponInventory.setImage(image);
        return weaponInventoryRepository.save(weaponInventory);
    }

}
