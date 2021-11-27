import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class RequestHandler {

    final static OkHttpClient okHttpClient = new OkHttpClient();
    final static ObjectMapper objectMapper = new ObjectMapper();
    final static String host = "dataservice.accuweather.com";


    public static String detectCityId(String cityName) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(host)
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", "tGySFf7S7xC7dlwZZtsDnHIDQTlvD3iI")
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(String.valueOf(httpUrl))
                .build();

        Response response = okHttpClient.newCall(request).execute();
                 String json = response.body().string();
                 String city = objectMapper.readTree(json).get(0).at("/LocalizedName").asText();
                 System.out.println(city);
                 String code = objectMapper.readTree(json).get(0).at("/Key").asText();
        return code;
    }

    public static String getForecast(String cityCode) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(host)
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityCode)
                .addQueryParameter("apikey", "tGySFf7S7xC7dlwZZtsDnHIDQTlvD3iI")
                .addQueryParameter("metric", String.valueOf(true))
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(String.valueOf(httpUrl))
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String forecastsJson= objectMapper.readTree(json).at("/DailyForecasts").toString();

        for (int i =0; i<5; i++){
            String dayForecast= objectMapper.readTree(forecastsJson).get(i).toString();
            String date= objectMapper.readTree(dayForecast).at("/Date").asText();
            System.out.println("В этом городе на " + " " + date);
            String maxTemp= objectMapper.readTree(dayForecast).at("/Temperature/Maximum/Value").asText();
            System.out.println("Максимальная температура:" + " "+maxTemp);
            String minTemp= objectMapper.readTree(dayForecast).at("/Temperature/Minimum/Value").asText();
            System.out.println("Минимальная температура:" + " "+minTemp);}
        return "Прогноз выполнен";
    }

}
