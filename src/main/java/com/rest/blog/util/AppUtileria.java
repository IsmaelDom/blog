package com.rest.blog.util;

import java.io.IOException;

import lombok.extern.log4j.Log4j2;
import net.iharder.Base64;

@Log4j2
public class AppUtileria {
	
	public static String codificar(String value) {
		if (value != null) {
			return Base64.encodeBytes(value.getBytes());
		}
		return value;
	}

	public static String decodificar(String base64) {
		try {
			if (base64 != null) {
				byte[] value = Base64.decode(base64);
				return new String(value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64;
	}

}
