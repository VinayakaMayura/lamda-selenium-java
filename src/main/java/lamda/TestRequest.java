package lamda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runners.model.FrameworkMethod;

@Getter
@Setter
@ToString
public class TestRequest {

    private String testClass;
    private String frameworkMethod;

    public TestRequest() {}

    public TestRequest(Class<?> clazz, FrameworkMethod method) {
        testClass = clazz.getCanonicalName();
        String frameworkMethodName = method.getMethod().getName();
    }

    public TestRequest(Description description) {
        testClass = description.getClassName();
        String frameworkMethod = description.getMethodName();
    }


}
