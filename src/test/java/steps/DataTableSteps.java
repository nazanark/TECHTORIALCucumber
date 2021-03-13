package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataTableSteps {

    @Given("the user prints products title")
    public void the_user_prints_products_title(DataTable dataTable) {
        List<String > productInfo=dataTable.asList();
        for (String info : productInfo){
            System.out.println(info);
        }
    }


    @Then("user prints credentials")
    public void user_prints_credentials(DataTable dataTable) {
        Map<String, String> credentials=dataTable.asMap(String.class, String.class);
        Set<String> keys=credentials.keySet();

        for (String key: keys) {
            System.out.println("Key: "+key+ "Value: "+credentials.get(key));
        }

    }


    @Then("the user print product info")
    public void the_user_print_product_info(List<List<String>> products) {
        for(List<String> row : products){

            for (String details: row) {

                System.out.print(" | "+details + " | ");
            }
            System.out.println();
        }

    }

    @Then("the user print product details")
    public void the_user_print_product_details(DataTable dataTable) {
        List<Map<String, String>> details=dataTable.asMaps();

        for (Map <String, String> detail: details) {

            for (String key : detail.keySet()) {

                System.out.println("Key: "+key+ " Value: "+detail.get(key));
            }

            System.out.println("****************************");
        }
    }
}
