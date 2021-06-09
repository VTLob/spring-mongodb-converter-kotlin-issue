package de.vtlob.spring.mongodb.converter.kotlin.issue

import org.bson.types.Decimal128
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.convert.converter.Converter
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import java.math.BigDecimal


@SpringBootApplication
class ExampleApplication {

    @Bean
    fun mongoCustomConversions(): MongoCustomConversions {
        return MongoCustomConversions(listOf(
            Converter<Decimal128, BigDecimal> { source -> BigDecimal(source.toString()) }
        ))
    }
}

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
}
