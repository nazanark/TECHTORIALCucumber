package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.it.Ma;
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
import java.util.List;
import java.util.Map;

public class HomeWork {
    // 1. GET https://corona.lmao.ninja/v2/countries
    //2. Print out all character names

    @Test
    public void test() throws URISyntaxException, IOException {
        HttpClient client=HttpClientBuilder.create().build();
        URIBuilder builder=new URIBuilder();
        builder.setScheme("https");
        builder.setHost("corona.lmao.ninja");
        builder.setPath("v2/countries");

        HttpGet get=new HttpGet(builder.build());
        get.setHeader("Accept","application/json");

        HttpResponse response=client.execute(get);
        int statusCode=response.getStatusLine().getStatusCode();
        Assert.assertEquals(HttpStatus.SC_OK,statusCode);

        ObjectMapper mapper=new ObjectMapper();
        List<Map<String, Object>> responseList=mapper.convertValue(response.getEntity().getContent(),
                new TypeReference<List<Map<String, Object>>>() {});

        for (int i = 0; i < responseList.size(); i++) {
            System.out.println(responseList.get(i));

        }
    }
}