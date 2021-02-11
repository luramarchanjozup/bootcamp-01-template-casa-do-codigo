package com.casaDoCodigo.Nicolle.Shared;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.casaDoCodigo.Nicolle.Carrinho.Carrinho;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Cookies {
	
	/* @param kew chave que será gerada para cookie
	 * @param carrinho de compra para serialização
	 * @param response
	 */
	public void writesAsJson(String key, Carrinho carrinho, HttpServletResponse response) {
		Cookie cookie;
		try {
			cookie = new Cookie(key, new ObjectMapper().writeValueAsString(carrinho));
			cookie.setHttpOnly(true);
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		
	}

}
