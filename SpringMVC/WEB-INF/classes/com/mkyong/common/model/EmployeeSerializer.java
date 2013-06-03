package com.mkyong.common.model;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.stereotype.Component;


@Component
public class EmployeeSerializer extends JsonSerializer<List<Employee>> {

	@Override
	public void serialize(List<Employee> arg0, JsonGenerator jgen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		// TODO Auto-generated method stub
		System.out.println("called employeeSerialiser ***************** ");
		if (arg0.size () > 5)
			jgen.writeObject (arg0.subList (0, 5));
        else
            jgen.writeObject (arg0);
		
		
	}

}
