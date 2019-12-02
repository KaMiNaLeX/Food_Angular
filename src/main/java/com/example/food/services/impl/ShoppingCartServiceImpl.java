package com.example.food.services.impl;

import com.example.food.dto.adminDto.ShoppingCartDto;
import com.example.food.dto.clientDto.ShoppingCartDishDto;
import com.example.food.models.ShoppingCart;
import com.example.food.repositories.ShoppingCartRepository;
import com.example.food.services.ModelMapperService;
import com.example.food.services.ShoppingCartService;
import com.example.food.services.helpers.DbFieldsParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService, ModelMapperService {
    private final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        map(shoppingCartDto, shoppingCart);
        map(shoppingCartRepository.save(shoppingCart), shoppingCartDto);
        LOGGER.info("Shopping_cart create");
        return shoppingCartDto;
    }

    @Override
    public List findAllShoppingCart(int page, int size) throws IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageDishes = shoppingCartRepository.findAllShoppingCart(pageable);
        List<Map<String, Object>> list = pageDishes.getContent();
        List<ShoppingCartDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = null;

                try {
                    if (DbFieldsParser.getDtoFieldFromDb(entry.getKey()) == null) {
                        field = ShoppingCartDto.class.
                                getDeclaredField(entry.getKey());
                    } else {
                        field = ShoppingCartDto.class.
                                getDeclaredField(DbFieldsParser.getDtoFieldFromDb(entry.getKey()));
                    }

                } catch (NoSuchFieldException e) {
                    continue;
                }
                field.setAccessible(true);
                field.set(shoppingCartDto, entry.getValue());
            }
            resultList.add(shoppingCartDto);

        }
        return resultList;
    }


    @Override
    public List getByClientLogin(String login) {
        List<ShoppingCartDishDto> shoppingCartDishDtoList = new ArrayList<>();
        map(shoppingCartRepository.getByClientLogin(login), shoppingCartDishDtoList);
        return shoppingCartDishDtoList;
    }

    @Override
    public void deleteShoppingCartDish(Long id) {
        shoppingCartRepository.deleteById(id);

    }

}
