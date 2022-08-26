package com.example.shops;

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
    public Shop patchShop(String shopId, String name) {
        Shop shop = db.get(shopId);
        shop.setName(name);
        return shop;
    }
}
