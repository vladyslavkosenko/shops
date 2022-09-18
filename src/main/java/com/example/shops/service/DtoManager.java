package com.example.shops.service;

import com.example.shops.entity.Shop;
import com.example.shops.entity.ShopDto;

public class DtoManager {
    public ShopDto convertToDto(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setCity(shop.getCity());
        shopDto.setStreet(shop.getStreet());
        shopDto.setName(shop.getName());
        shopDto.setWebsite(shop.getWebsite());
        return shopDto;
    }

    public Shop convertToEntity(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setCity(shopDto.getCity());
        shop.setStreet(shopDto.getStreet());
        shop.setName(shopDto.getName());
        shop.setWebsite(shopDto.getWebsite());
        return shop;
    }
}