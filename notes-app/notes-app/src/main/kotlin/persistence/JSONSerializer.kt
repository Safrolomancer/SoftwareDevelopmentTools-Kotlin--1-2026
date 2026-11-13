
package persistence

import tools.jackson.module.kotlin.jacksonObjectMapper
import java.io.File

class JSONSerializer(private val file: File) : Serializer {

    private val mapper = jacksonObjectMapper()

    override fun write(obj: Any?) {
        mapper.writerWithDefaultPrettyPrinter()
            .writeValue(file, obj)
    }

    override fun <T> read(classType: Class<T>): T {
        return mapper.readValue(file, classType)
    }
}

