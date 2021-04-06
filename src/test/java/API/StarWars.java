package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.corba.se.idl.StringGen;
import io.cucumber.java.bs.A;
import io.cucumber.java.it.Ma;
import org.apache.http.HttpEntity;
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

public class StarWars {

    @Test
    public void starWars() throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        for (int i = 1; i <= 9; i++) {
            //  http://swapi.dev/api/people?page=1
            uriBuilder.setScheme("http");
            uriBuilder.setHost("swapi.dev");
            uriBuilder.setPath("api/people");
            uriBuilder.setParameter("page", "" + i);

            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("Accept","application/json");

            HttpResponse response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            Assert.assertEquals(HttpStatus.SC_OK, statusCode);
            HttpEntity responseBody=response.getEntity();

            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> responseMap = mapper.readValue(response.getEntity().getContent(),
                    new TypeReference<Map<String, Object>>() {});

            List<Map<String, Object>> resultList = (List<Map<String, Object>>) responseMap.get("results");
            resultList.get(0).get("name");

            for (int j = 0; j < resultList.size(); j++) {
                System.out.println(resultList.get(j).get("name"));
            }
        }
    }
}