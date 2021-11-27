import org.sqlite.JDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DbHandler {
    public final String PATH_DB = "jdbc:sqlite:C:\\Users\\Lenny\\IdeaProjects\\JavaCore2\\src\\main\\resources\\Weather.db";

    Connection connection;
    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        connection = DriverManager.getConnection(PATH_DB);
    }
    public void addWeather(Weather weather) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Weather('Date','Max','Min')" + "VALUES(?,?,?)")) {
            statement.setObject(1, weather.Date);
            statement.setObject(2, weather.Max);
            statement.setObject(3, weather.Min);
            statement.execute();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }


    public List<Weather> findAllWeather() throws SQLException {
        List<Weather>weathers = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Weather");
            while (resultSet.next()){
                Weather weather = new Weather();
                weather.Date = resultSet.getString("Date");
                weather.Max = resultSet.getInt("Max");
                weather.Min = resultSet.getInt("Min");
                weathers.add(weather);
            }
        }catch (Exception ignored){}
        return weathers;
    }

    public void deleteWeather(String Date) throws SQLException {
        try(PreparedStatement statement=connection.prepareStatement(
                "DELETE FROM  Weather WHERE Date=?")) {
            statement.setObject(1,Date);
            statement.execute();

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

}
