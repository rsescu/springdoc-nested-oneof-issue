package ro.consutsescu.springdocnestedoneofissues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringdocNestedOneofIssuesApplicationTests {

    @Autowired
    private CustomOpenApiResource resource;


    @Test
    void contextLoads() throws IOException {
        JsonNode topNode = new ObjectMapper().readTree(resource.getOpenApiJson());

        JsonNode components = topNode.get("components");


        // Expected type for child
        JsonNode paths = topNode.get("paths");
        JsonNode correctOneOfSchema = paths.get("/child")
                .get("post").get("requestBody").get("content").get("application/json")
                .get("schema").get("oneOf");
        assertTrue(correctOneOfSchema.isArray());
        ArrayNode correctOneOfSchemaArray = (ArrayNode) correctOneOfSchema;
        correctOneOfSchemaArray.forEach(node -> {
            String typeRef = node.get("$ref").textValue();
            assertTrue(typeRef.contains("ChildType1") || typeRef.contains("ChildType2"));
        });
        JsonNode schemas = components.get("schemas");


        // P gets built as ref instead of expected type as described above
        JsonNode badDefinition = schemas.get("Response").get("properties").get("abstractChild").get("oneOf");
        assertNotNull(badDefinition);
        // would expect badDefinition.get("oneOf")
        assertEquals(2, badDefinition.size());

//              "schema": {
//                "oneOf": [
//                  {
//                    "$ref": "#/components/schemas/ChildType1"
//                  },
//                  {
//                    "$ref": "#/components/schemas/ChildType2"
//                  }
//                ]
//              }

    }
}
