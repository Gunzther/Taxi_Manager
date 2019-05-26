public class TimeCalculator {

    public static double changeToHr(String time) {
        double Hr = Double.parseDouble(time.substring(0, 2));
        double Min = Double.parseDouble(time.substring(3, 5));
        double Sec = Double.parseDouble(time.substring(6, 8));
        return Hr+(Min/60)+(Sec/3600);
    }

    public static double timeCount(String timeStart ,String timeStop) {
        double start = changeToHr(timeStart);
        double stop = changeToHr(timeStop);
        return stop-start;
    }
}
