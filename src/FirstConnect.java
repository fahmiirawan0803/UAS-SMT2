import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL
                ("https://dummyjson.com/products/search?q=Laptop");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);

        //decoding JSON
        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponModel> responseModel = new ArrayList<>();
        for (int i = 0; i < responseJSON.length(); i++){
            ResponModel resModel = new ResponModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setProducts(myJSONObject.getString("products"));
            resModel. setId(myJSONObject.getString("id"));
            resModel.setTitle(myJSONObject.getString("title"));
            resModel.setDescription(myJSONObject.getString("description"));
            responseModel.add(resModel);
        }

        System.out.println("Response are : ");
        for (int index = 0; index < responseModel.size(); index++){
            System.out.println("MESSAGE : " + responseModel.get(index).getProducts());
        }
    }
}
