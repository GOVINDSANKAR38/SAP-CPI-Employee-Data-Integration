import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def Message processData(Message message) {

    def reader = message.getBody(java.io.Reader)
    def json = new JsonSlurper().parse(reader)

    def result = [:]

    if (json instanceof List) {
        result.records = [ record: json ]
    } else {
        result.records = [ record: [json] ]
    }

    message.setBody(JsonOutput.toJson(result))
    return message
}