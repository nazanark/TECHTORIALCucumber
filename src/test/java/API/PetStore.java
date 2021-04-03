package API;

import io.cucumber.java.bs.A;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class PetStore {

    @Test
    public void test1() throws URISyntaxException, IOException {

        // https://petstore.swagger.io/v2/pet/789

        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/789");
        HttpGet get=new HttpGet(uriBuilder.build());
        HttpResponse response=client.execute(get);
        int statusCode=response.getStatusLine().getStatusCode();
        Assert.assertFalse(statusCode==400);
        Assert.assertEquals(statusCode,200);
    }


}
