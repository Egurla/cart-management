package com.nisum.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nisum.cms.domain.CartDomain;
import com.nisum.cms.exception.CartManagementException;
import com.nisum.cms.model.CartRequest;
import com.nisum.cms.model.CartResponse;
import com.nisum.cms.service.dto.CartRequestDto;

@Service
public interface CartService {

	// List<Cart> getAllCart();

	CartResponse createCart(CartRequestDto cartRequestDto);

	CartResponse updateCart(CartRequestDto cartRequestDto);

	// CartDomaine getCartById(long id) throws CartNotFoundException;

	CartDomain getCartById(Long id) throws CartManagementException;

	List<CartDomain> getAll();

	void deleteById(Long cartId);

//		Cart updateCart(long id, Cart cartRequest) throws CartNotFoundException;
}
