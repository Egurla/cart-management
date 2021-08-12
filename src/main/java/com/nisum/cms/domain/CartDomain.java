package com.nisum.cms.domain;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.cms.model.LineItem;

import lombok.Data;


@Data
@Document(collection = "cart")
public class CartDomain {
	@JsonProperty("_id")
	private String id;
	
	@Id
	@JsonProperty("cartId")
	@NonNull
	private long cartId;
	private UUID userId;
	private UUID guestId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * public CartDomain(String id, long cartId, UUID userId, UUID guestId,
	 * Collection<LineItem> items) { super(); this.id = id; this.cartId = cartId;
	 * this.userId = userId; this.guestId = guestId; this.items = items; }
	 */
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public UUID getGuestId() {
		return guestId;
	}
	public void setGuestId(UUID guestId) {
		this.guestId = guestId;
	}
	public Collection<LineItem> getItems() {
		return items;
	}
	public void setItems(Collection<LineItem> items) {
		this.items = items;
	}
	private Collection<LineItem> items;

	
}
