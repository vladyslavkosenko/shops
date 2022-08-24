package com.example.shops;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {
    private ShopService shopService;

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
}
