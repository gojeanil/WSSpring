package com.mkyong.common.model;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.stereotype.Component;

@Component
public class JsonDateSerializer extends JsonSerializer<Date>{

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
	throws IOException, JsonProcessingException {
		System.out.println("called JsonDateSerializer ***************** ");
	String formattedDate = dateFormat.format(date);
	 
	gen.writeString(formattedDate);
	}
	
	 

}
