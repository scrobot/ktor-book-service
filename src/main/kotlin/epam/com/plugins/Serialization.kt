package epam.com.plugins

import com.fasterxml.jackson.annotation.JsonInclude
import io.ktor.jackson.*
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.ktor.features.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureSerialization() {
  install(ContentNegotiation) {
    jackson {
      enable(SerializationFeature.INDENT_OUTPUT)
      setSerializationInclusion(JsonInclude.Include.NON_NULL)
      enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
      configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
      configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, true)
      configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
      propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
      registerModule(KotlinModule())
    }
  }
}
