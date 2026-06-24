package com.luizeduardo.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");//isso e feito pra decodificar textos, ao ionves de pegar em forma da prorpia escrita 
			//cada texte tem um codigo proprio pra busca no banco de dados
		}catch(UnsupportedEncodingException e) {
			return "";
		}
	}
	public static Date convertDate(String textDate,Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textDate);
		}catch(ParseException e) {
			return defaultValue;
		}
	}
	
}
