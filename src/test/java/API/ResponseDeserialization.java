package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.bs.A;
import io.cucumber.java.it.Ma;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class ResponseDeserialization {

    @Test
    public void responseDeserialization() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        // https://petstore.swagger.io/v2/pet/789
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/789");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        // let server know that we expect result in JSON format
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = client.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200, statusCode);

        // Retrieving response body
        HttpEntity responseBody = response.getEntity();
        // System.out.println(EntityUtils.toString(responseBody));

        // ObjectMapper is used to map JSON object to Java Object
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialization: convert JSON to JAVA
        Map<String, Object> responseMap=objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});
        System.out.println("name: "+responseMap.get("name"));
        System.out.println("status: "+responseMap.get("status"));
        Assert.assertEquals(789, responseMap.get("id"));
    }
}
