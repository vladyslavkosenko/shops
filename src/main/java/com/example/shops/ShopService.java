package com.example.shops;

import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class ShopService {
    private HashMap<String, Shop> db = new HashMap<>();

    public Shop addShop(Shop shop){
        db.put(shop.getId(), shop);
        System.out.println("Shop with id " + shop.getId() + " added");
        return shop;
    }
    public Shop getShopById(String shopId){
        Shop shop1 = db.get(shopId);
        if(shop1 != null){
            System.out.println("shop with id " + shop1.getId() + " pojo");
            return shop1;
        }
        return  null;
    }
}
