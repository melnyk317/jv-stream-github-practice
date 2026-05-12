package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate>{

    @Override
    public boolean test(Candidate c) {
        if (c.getAge() < 35) { 
            return false; 
        }
        if (!c.isAllowedToVote()) {
            return false;
        }
        if (!c.getNationality().equals("Ukrainian")) {
            return false;
        }
        String[] years = c.getPeriodsInUkr().split("-");
        if (Integer.parseInt(years[1]) - Integer.parseInt(years[0]) < 10) {
            return false;
        }
        return true;
    }
}
