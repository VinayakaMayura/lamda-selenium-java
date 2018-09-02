package lamda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestResult {
    private int runCount;
    private int failureCount;
    private long runTime;
}