package com.nisum.cms.controller;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.cms.domain.CartDomain;
import com.nisum.cms.exception.CartManagementException;

import com.nisum.cms.model.CartRequest;
import com.nisum.cms.model.CartResponse;
import com.nisum.cms.service.CartService;
import com.nisum.cms.service.dto.CartRequestDto;


@RestController
@RequestMapping("/carts")
public class CartManagementController {
	/*
	 * @GetMapping public String getCart() {
	 * 
	 * return "in cartma";
	 */

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CartService cartService;
	

	@GetMapping("/getcarts")
	public List<CartDomain> getAllCarts() throws CartManagementException {
		return cartService.getAll();
	}

	@GetMapping("/{cartId}")
	public CartDomain getById(@PathVariable Long cartId) throws CartManagementException {
		logger.debug("Getting cart data with cart cartid= {}.", cartId);
		return cartService.getCartById(cartId);
	}
	@PostMapping("/addCarts")
	public String createCart(@RequestBody CartRequest cartRequest) {
		logger.debug("saving the cart data");
		CartRequestDto cartRequestDto = CartDtoMapper.CartRequetToCartRequestDto(cartRequest);

		
		// Cart cart = cartService.createCart(cartRequest);
		// convert entity to DTO
		// CartDto cartResponse = modelMapper.EntityToDto(cart);
		CartResponse cartres = cartService.createCart(cartRequestDto);
		return "cart recoreds are saved" + cartres;
	}

	
	
	@PutMapping("/{cartId}")
    public String updateCart(@RequestBody CartRequest cartRequest, @PathVariable Long cartId) {
		CartRequestDto cartRequestDto = CartDtoMapper.CartRequetToCartRequestDto(cartRequest);
        cartService.createCart(cartRequestDto);
        logger.debug("Updating cart data with id= {}.", cartId);
        return "updated cartequest   ";
    }
	
	@DeleteMapping("/{cartId}")
    public String deleteCart(@PathVariable Long cartId) {
		cartService.deleteById(cartId);
		logger.debug("Deleting cart data with id= {}.", cartId);
        return "deleted cartID ";
    }
	
}
