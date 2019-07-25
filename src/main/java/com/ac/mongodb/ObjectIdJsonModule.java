package com.ac.mongodb;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Mongodb ObjectId Module for JsonHelper
 *
 */
@SuppressWarnings({"serial","deprecation"})
public class ObjectIdJsonModule extends SimpleModule {

	public ObjectIdJsonModule() {
		super("ObjectId", new Version(1, 0, 0, null));
		addSerializer(new ObjectIdJsonSerializer(ObjectId.class));
	}

	class ObjectIdJsonSerializer extends StdSerializer<ObjectId> {
		protected ObjectIdJsonSerializer(Class<ObjectId> t) {
			super(t);
		}

		public void serialize(ObjectId value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if (value == null) {
				jgen.writeNull();
			} else {
				jgen.writeString(value.toString());
			}
		}
	}
}
