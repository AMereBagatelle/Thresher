package amerebagatelle.github.io.thresher.util;

import java.util.ArrayList;

public class ThresherException extends Exception {
    public ArrayList<String[]> reasons;

    public ThresherException(ArrayList<String[]> reasons) {
        super();
        this.reasons = reasons;
    }
}
