package com.example.core.utils;

import java.util.UUID;

public class IdGenerator {
	public static final String generateId() {
		return UUID.randomUUID().toString();
	}
}
