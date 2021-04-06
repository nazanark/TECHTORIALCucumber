package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.bs.A;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class IllinoisAssertion {

    @Test
    public void test() throws URISyntaxException, IOException {
        // https://corona.lmao.ninja/v2/states/Illinois
        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/states/Illinois");

        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader("Accept", "application/json");
        HttpResponse response=client.execute(get);
        int statusCode=response.getStatusLine().getStatusCode();
        Assert.assertEquals(HttpStatus.SC_OK,statusCode);

        ObjectMapper mapper=new ObjectMapper();
        // actual deserialization:
        // parsing response body to JAVA Map <String, Object>
        Map<String, Object> responseMap=mapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});

        Assert.assertEquals("Illinois", responseMap.get("state"));
       // Assert.assertEquals(12671821, responseMap.get("population"));
        // Parse population to INTEGER
        Assert.assertTrue(12671821==(int)responseMap.get("population"));
    }
}
