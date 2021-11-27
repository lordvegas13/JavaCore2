public class Weather {
    String Date;
    float Max;
    float Min;


    public Weather(){}

    public Weather(String date, float max, float min) {
        Date = date;
        Max = max;
        Min = min;
    }
    @Override
    public String toString() {
        return "["+ Date + "," + Max + ","+ Min + "]";

    }public float getMin() {
        return Min;
    }
    public void setMin(float min, float v) {
        Min = min;
    }

    public float getMax() {
        return Max;
    }

    public void setMax(float max, float v) {
        Max = max;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(int i, String date) {
        Date = date;
    }

}
