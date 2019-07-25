package com.ac.mongodb;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.mongodb.client.FindIterable;

/**
 * Mongodb ObjectId Module for JsonHelper
 *
 */
@SuppressWarnings({ "serial", "rawtypes", "deprecation", "unchecked"})
public class FindIterableJsonModule extends SimpleModule {

	public FindIterableJsonModule() {
		super("ObjectId", new Version(1, 0, 0, null));
		
		addSerializer(new FindIterableJsonSerializer(FindIterable.class));
	}

	class FindIterableJsonSerializer extends StdSerializer<FindIterable> {
		protected FindIterableJsonSerializer(Class<FindIterable> t) {
			super(t);
		}

		public void serialize(FindIterable value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if (value == null) {
				jgen.writeNull();
			} else {
				jgen.writeObject(value.into(new ArrayList<>()));
			}
		}
	}
}
