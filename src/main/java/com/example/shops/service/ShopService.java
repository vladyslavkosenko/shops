package com.example.shops.service;

import com.example.shops.entity.Shop;
import com.example.shops.exception.ShopNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ShopService {
    private final HashMap<String, Shop> db = new HashMap<>();

    public Shop addShop(Shop shop) {
        db.put(shop.getId(), shop);
        return shop;
    }

    public Shop getShopById(String shopId) throws ShopNotFoundException {
        isFound(shopId);
        return db.get(shopId);
    }


    public HashMap<String, Shop> getAllShops() {
        return db;
    }

    public Shop deleteShopById(String shopId) throws ShopNotFoundException {
        isFound(shopId);
        return db.remove(shopId);
    }

    public Shop patchShop(Shop shop, String id) {
        Shop shopRequestBody = db.get(id);
        shopRequestBody.setName(shop.getName());
        shopRequestBody.setCity(shop.getCity());
        shopRequestBody.setStreet(shop.getStreet());
        shopRequestBody.setEmployees(shop.getEmployees());
        shopRequestBody.setWebsite(shop.getWebsite());
        return shop;
    }
    public void isFound(String shopId) throws ShopNotFoundException {
        if(!db.containsKey(shopId))
            throw new ShopNotFoundException(
                    "Shop with id: " + shopId + " not found");
    }
}
