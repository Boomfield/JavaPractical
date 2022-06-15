package asserts;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import java.util.ArrayList;

public class AssertContainsToLowerCase extends TypeSafeDiagnosingMatcher <ArrayList<String>> {
    private final String value;

    public AssertContainsToLowerCase(String value) {
        this.value = value;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("");
    }

    @Override
    protected boolean matchesSafely(ArrayList<String> list, Description description) {
       return list.stream().allMatch(x->x.toLowerCase().contains(value));
    }

    public static AssertContainsToLowerCase allMatchIgnoreCase (String value) {
        return new AssertContainsToLowerCase(value);
    }
}
