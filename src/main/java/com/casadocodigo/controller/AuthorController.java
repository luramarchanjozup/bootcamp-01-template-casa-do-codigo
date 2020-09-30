package com.casadocodigo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

	@GetMapping("/")
	String getAuthor() {
		return "rest its ok!";
	}
}
