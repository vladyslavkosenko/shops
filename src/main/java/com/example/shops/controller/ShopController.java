package com.example.shops.controller;

import com.example.shops.entity.Shop;
import com.example.shops.entity.ShopDto;
import com.example.shops.exception.ShopNotFoundException;
import com.example.shops.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.stream.Collectors;


@RestController
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @SneakyThrows
    @PostMapping
    public Shop addShop(HttpServletRequest reg, HttpServletResponse response) {
        BufferedReader reader = reg.getReader();
        String shopJson = reader.lines().collect(Collectors.joining());
        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop = objectMapper.readValue(shopJson, Shop.class);
        shopService.putSop(shop);
        return shop;
    }

    @SneakyThrows
    @GetMapping("/shops")
    public void getAllShop(HttpServletRequest reg, HttpServletResponse response) {
        PrintWriter writer = response.getWriter();
        shopService.getAllShop(writer);
    }

    @PostMapping(value = "/shop",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ShopDto shopDto(@RequestBody ShopDto shopDto) {
        return shopService.addShop(shopDto);
    }

    @PostMapping(value = "/shops",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop createShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    @GetMapping("/shops/{shopId}")
    public Shop getShopById(@PathVariable("shopId") Long shopId) throws ShopNotFoundException {
        return shopService.getShopById(shopId);
    }

    @GetMapping("/shops/oll")
    public HashMap<Long, Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @DeleteMapping("/delete")
    public Shop deleteShopById(@RequestParam(value = "shopId") Long shopId) throws ShopNotFoundException {
        return shopService.deleteShopById(shopId);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop update(@RequestBody Shop shop, @PathVariable Long id) {
        return shopService.patchShop(shop, id);
    }

}
