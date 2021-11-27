import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        String cityCode = RequestHandler.detectCityId("Moscow");
        String forecast= RequestHandler.getForecast(cityCode);
        System.out.println(forecast);



        DbHandler dbHandler = new DbHandler();
        Weather weather = new Weather();
        weather.Date = "2021-12-01T07:00:00+03:00";
        weather.Max= (float) 2.8;
        weather.Min= (float) 1.7;
        weather.Date= weather.getDate();

        dbHandler.addWeather(weather);
        System.out.println(dbHandler.findAllWeather());

        //dbHandler.deleteWeather("2021-11-27T07:00:00+03:00");
        //System.out.println(dbHandler.findAllWeather());

       // dbHandler.addWeather(weather);
       // System.out.println(dbHandler.findAllWeather());*/
    }
}
