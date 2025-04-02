package usantatecla.movies.vAdrianAlonso;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    private static final double CHARGE = 2.0;
    private static final double EXTRA_CHARGE = 1.5;
    private static final int DAYS_RENTED_THRESHOLD = 2;

    @Override
    public double getCharge(int daysRented) {
        double result = RegularMovie.CHARGE;
        if (daysRented > RegularMovie.DAYS_RENTED_THRESHOLD) {
            result += (daysRented - RegularMovie.DAYS_RENTED_THRESHOLD) * RegularMovie.EXTRA_CHARGE;
        }
        return result;
    }
}
