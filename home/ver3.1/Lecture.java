public class Lecture {
    private String day;
    private String period;
    private String info;

    public Lecture(String day, String period, String info) {
        this.day = day;
        this.period = period;
        this.info = info;
    }

    public String getDay() {
        return day;
    }

    public String getPeriod() {
        return period;
    }

    public String getInfo() {
        return info;
    }
}
