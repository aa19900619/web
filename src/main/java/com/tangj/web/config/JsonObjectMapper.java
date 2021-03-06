package com.tangj.web.config;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
public class JsonObjectMapper extends ObjectMapper  {  
      
	   private static final long serialVersionUID = 1L;
	 
		public JsonObjectMapper() {
			super();
		    this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			// 空值处理为空串
			this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
				@Override
				public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)throws IOException, JsonProcessingException {
					gen.writeString("");
				}
			});
		}
   }


