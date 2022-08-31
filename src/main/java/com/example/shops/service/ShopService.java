package com.example.shops.service;

import com.example.shops.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ShopService {
    private HashMap<String, Shop> db = new HashMap<>();

    public Shop addShop(Shop shop) {
        db.put(shop.getId(), shop);
        return shop;
    }

    public Shop getShopById(String shopId) {
        Shop shop = db.get(shopId);
        if (shop != null) {
            return shop;
        }
        return null;
    }

    public HashMap<String, Shop> getShopOll() {
        return db;
    }

    public Shop deleteShopById(String shopId) {
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
}
