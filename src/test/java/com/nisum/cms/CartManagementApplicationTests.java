package com.nisum.cms;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.cms.controller.CartManagementController;
import com.nisum.cms.domain.CartDomain;
import com.nisum.cms.model.CartRequest;
import com.nisum.cms.model.LineItem;
import com.nisum.cms.repository.CartRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootConfiguration
class CartManagementApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	
	/*private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	@Before
	private void setUp() {
		
	}*/

	private MockMvc mockMov;

	@MockBean
	CartRepository  cartRepository;
	
	
	@InjectMocks
	private CartManagementController cartManagementController;
	
	@Autowired
    ObjectMapper mapper;
	//ObjectMapper om= new ObjectMapper();

	@Before
	public void setUp() throws Exception {

		mockMov = MockMvcBuilders.standaloneSetup(cartManagementController).build();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCreateCart() throws Exception {
	
		LineItem lineItem=new LineItem();
		lineItem.setId(23423432l);
		lineItem.setLine_amount(24454343d);
		lineItem.setProductId(23423432l);
		lineItem.setQuantity(1);
		
		List<LineItem> list=new ArrayList<LineItem>();
		CartDomain cartdomain=new CartDomain();
		cartdomain.setCartId(12423432);
		cartdomain.setGuestId(UUID.randomUUID());
		cartdomain.setUserId(UUID.randomUUID());
		cartdomain.setItems(list);

		//Mockito.when(cartRepository.save(cartRequest))

	    Mockito.when(cartRepository.save(cartdomain)).thenReturn(cartdomain);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/carts/addCarts")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(cartdomain));
		
		  mockMov.perform(mockRequest) .andExpect(status().isOk())
		  .andExpect(jsonPath("$", notNullValue())) .andExpect(jsonPath("$.cartId",
		  is(6875393))); 
	
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetAllCarts() throws Exception {
		// assertThat(cartManagementController).isNotNull();
		MvcResult results = mockMov
				.perform(MockMvcRequestBuilders.get("/carts/getcarts").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String resultsContext=results.getResponse().getContentAsString();
		CartDomain domain=this.mapper.readValue(resultsContext, CartDomain.class);
		
		Assert.assertEquals(domain.getId(), Matchers.anyString());
		
		Assert.assertEquals(domain.getCartId(),Matchers.anyLong());
		Assert.assertEquals(domain.getGuestId(),Matchers.any());
		//Assert.assertEquals(domain.getUserId(),Matchers.any());
		//Assert.assertEquals(domain.getItems(),Matchers.anyList());
		
		

		/*
		 * andExpect(jsonPath(domain.getId(), Matchers.anyString())) .andExpect(
		 * (ResultMatcher) jsonPath("$.cartId", Matchers.anyLong()))
		 * .andExpect((ResultMatcher) jsonPath("$.userId", Matchers.any().toString()))
		 * .andExpect((ResultMatcher) ((ResultActions) jsonPath("$.guestId",
		 * Matchers.any().toString())) .andExpect((ResultMatcher) jsonPath("$.items",
		 * Matchers.anyList())));
		 */
	}
	@Test
	public void TesDelete() throws Exception {
		
		CartDomain cartdomain=new CartDomain();
		Mockito.when(cartRepository.findById(cartdomain.getCartId())).thenReturn(Optional.of(cartdomain));

	    mockMov.perform(MockMvcRequestBuilders
	            .delete("/carts/45533432")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	}
	