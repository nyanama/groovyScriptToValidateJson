package com.validate

import groovy.json.JsonSlurper

class ValidateJson {
	static void main(String... args) {

		def schemaLocation = 'classpath:///schema.json'
		println "Schema Location:: $schemaLocation"
		
		def jsonLocation = 'classpath:///jsonC.json'
		println "JSON Location:: $jsonLocation"

		
		def json = JsonSchemaResolver.resolveSchema(jsonLocation)

		//create json schema
		//def jsonSchema = new JsonSlurper().parseText('{"properties":{"a":{"type":"number"}}}')

		use(JsonSchema) {
			json.schema = schemaLocation
			if ( json.conformsSchema() )
				println "Given JSON is Valid"
			else 
				println "Given JSON is Not Valid"
		}
	}
}
