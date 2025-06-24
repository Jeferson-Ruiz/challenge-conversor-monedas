import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import models.Moneda;

public class ConsultarApiMonedas {
    
    private String password = "de20b4e53a8019a13af0ba99";

    public Moneda convertirMoneda(String monedaOrigen, String monedaDestino, String contidad){
    
    URI uri = URI.create("https://v6.exchangerate-api.com/v6/"+password+"/pair/"+
                            monedaOrigen +"/"+
                            monedaDestino+"/"+
                            contidad);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

    try {
        HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la moneda.");
        }
    }
}