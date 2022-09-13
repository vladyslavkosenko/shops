package com.example.shops.service;

import com.example.shops.entity.Shop;
import com.example.shops.entity.ShopDto;
import com.example.shops.exception.ShopNotFoundException;
import com.example.shops.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final HashMap<Long, Shop> db = new HashMap<>();

    private Shop convertToEntity(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setCity(shopDto.getCity());
        shop.setStreet(shopDto.getStreet());
        shop.setName(shopDto.getName());
        shop.setWebsite(shopDto.getWebsite());
        return shop;
    }

    private ShopDto convertToDto(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setCity(shop.getCity());
        shopDto.setStreet(shop.getStreet());
        shopDto.setName(shop.getName());
        shopDto.setWebsite(shop.getWebsite());
        return shopDto;
    }

    public void getAllShop(PrintWriter writer) {
        db.entrySet()
                .forEach(e -> writer.println(e.getValue() + "[" + e.getKey() + "]"));
        writer.flush();
    }

    public ShopDto addShop(ShopDto shopDto) {
        Shop shop = convertToEntity(shopDto);
        shopRepository.save(shop);
        return shopDto;
    }


    public Shop addShop(Shop shop) {
        db.put(shop.getId(), shop);
        return shop;
    }

    public Shop getShopById(Long shopId) throws ShopNotFoundException {
        isFound(shopId);
        return db.get(shopId);
    }


    public HashMap<Long, Shop> getAllShops() {
        return db;
    }

    public Shop deleteShopById(Long shopId) throws ShopNotFoundException {
        isFound(shopId);
        return db.remove(shopId);
    }
    public Shop patchShop(Shop shop, Long id) {
        Shop shopRequestBody = db.get(id);
        shopRequestBody.setName(shop.getName());
        shopRequestBody.setCity(shop.getCity());
        shopRequestBody.setStreet(shop.getStreet());
        shopRequestBody.setEmployees(shop.getEmployees());
        shopRequestBody.setWebsite(shop.getWebsite());
        return shop;
    }

    public void putSop(Shop shop) {
        db.put(shop.getId(), shop);
    }

    public void isFound(Long shopId) throws ShopNotFoundException {
        if (!db.containsKey(shopId))
            throw new ShopNotFoundException(
                    "Shop with id: " + shopId + " not found");
    }
}
