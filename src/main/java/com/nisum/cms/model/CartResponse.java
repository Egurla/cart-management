package com.nisum.cms.model;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CartResponse {

	
	private long cardId;
	private UUID userId;
	/*
	 * public CartResponse(long cardId, UUID userId, UUID guestId,
	 * Collection<LineItem> items) { super(); this.cardId = cardId; this.userId =
	 * userId; this.guestId = guestId; this.items = items; }
	 */

		public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
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

		private UUID guestId;
	
	private Collection<LineItem> items;
}
