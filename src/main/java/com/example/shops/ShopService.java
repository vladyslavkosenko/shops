package com.example.shops;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ShopService {
    private HashMap<String, Shop> db = new HashMap<>();

    public Shop addShop(Shop shop) {
        db.put(shop.getId(), shop);
        System.out.println("Shop with id " + shop.getId() + " added");
        return shop;
    }

    public Shop getShopById(String shopId) {
        Shop shop1 = db.get(shopId);
        if (shop1 != null) {
            System.out.println("shop with id " + shop1.getId() + " pojo");
            return shop1;
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
