package com.luizeduardo.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");//isso e feito pra decodificar textos, ao ionves de pegar em forma da prorpia escrita 
			//cada texte tem um codigo proprio pra busca no banco de dados
		}catch(UnsupportedEncodingException e) {
			return "";
		}
	}
}
