package com.nisum.cms.controller;

import java.util.Optional;
import java.util.UUID;

import com.nisum.cms.domain.CartDomain;

import com.nisum.cms.model.CartRequest;
import com.nisum.cms.model.CartResponse;
import com.nisum.cms.service.dto.CartRequestDto;

public class CartDtoMapper {

	/*
	 * public static Cart DtoToEntity(CartRequest cartRequest) { Cart cart = new
	 * Cart(); // return new Cart().setCardId(userDto.getCardId())
	 * cart.setCardId(cartRequest.getCardId()); //
	 * cart.setGuestId(UUID.fromString("34234343")); //
	 * cart.setUserId(UUID.fromString("8876767"));
	 * 
	 * cart.setGuestId(UUID.randomUUID()); cart.setUserId(UUID.randomUUID());
	 * 
	 * return cart; }
	 */

	/*
	 * public static CartDto EntityToDto(Cart cart) { CartDto userDto = new
	 * CartDto(); userDto.setCardId(cart.getCardId());
	 * 
	 * userDto.setGuestId(cart.getGuestId()); userDto.setUserId(cart.getUserId());
	 * 
	 * return userDto;
	 * 
	 * }
	 */
	public static CartRequestDto CartRequetToCartRequestDto(CartRequest cartRequest) {

		CartRequestDto ctdto = new CartRequestDto();

		ctdto.setCardId(cartRequest.getCardId());
		//ctdto.setCardId(9098700);
		ctdto.setGuestId(UUID.randomUUID());
		ctdto.setUserId(UUID.randomUUID());
		// ctdto.setGuestId(cartRequest.getGuestId());
		// ctdto.setUserId(cartRequest.getUserId());
		//ctdto.setItems(cartRequest.getItems());
		ctdto.setItems(cartRequest.getItems());
		return ctdto;
	}

	public static CartDomain cartRequestDtoToDomain(CartRequestDto cart) {
		CartDomain cartDomaine = new CartDomain();

		cartDomaine.setCartId(cart.getCardId());
		cartDomaine.setGuestId(cart.getGuestId());
		cartDomaine.setItems(cart.getItems());
		cartDomaine.setUserId(cart.getUserId());
		return cartDomaine;
	}

	public static CartResponse DomaineToCartResponse(CartDomain cartDomaine) {
		CartResponse cartResponse = new CartResponse();
		cartResponse.setCardId(cartDomaine.getCartId());
		cartResponse.setGuestId(cartDomaine.getGuestId());
		cartResponse.setUserId(cartDomaine.getUserId());
		cartResponse.setItems(cartDomaine.getItems());
		return cartResponse;
	}

	public static void cartServiceToCart(CartResponse cart) {
		// TODO Auto-generated method stub
		
	}
}
