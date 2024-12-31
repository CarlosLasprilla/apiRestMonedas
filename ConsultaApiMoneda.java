import com.google.gson.Gson;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApiMoneda {
    public Moneda convertirDivisa(String base_code, String target_code, double cantidadDivisa) {


        String url = String.format(
                "https://v6.exchangerate-api.com/v6/b1a90499df762ec22b40e8dd/pair/%s/%s/%s/",
                base_code, target_code, cantidadDivisa);

        URI direccion = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No fue posible realizar el cambio de divisa" + e);
        }
    }
}


