package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        if (c.getAge() < MIN_AGE) { 
            return false; 
        }
        if (!c.isAllowedToVote()) {
            return false;
        }
        if (!c.getNationality().equals(UKRAINIAN_NATIONALITY)) {
            return false;
        }
        String[] years = c.getPeriodsInUkr().split("-");
        if (Integer.parseInt(years[1]) - Integer.parseInt(years[0]) < MIN_YEARS_IN_UKRAINE) {
            return false;
        }
        return true;
    }
}
