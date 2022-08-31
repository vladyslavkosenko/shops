package com.example.shops.controller;

import com.example.shops.entity.Shop;
import com.example.shops.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ShopController {
    private ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/shops",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop createShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);

    }

    @GetMapping("/shops/{shopId}")
    public Shop getShopById(@PathVariable("shopId") String shopId) {
        return shopService.getShopById(shopId);

    }

    @GetMapping("/shops/oll")
    public HashMap<String, Shop> getShopOll() {
        return shopService.getShopOll();

    }

    @DeleteMapping("/delete") //http://localhost:8080/delete?shopId=1
    public Shop deleteShopById(@RequestParam(value = "shopId") String shopId) {
        return shopService.deleteShopById(shopId);

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop update(@RequestBody Shop shop, @PathVariable String id) {

        return shopService.patchShop(shop, id);
    }
}
