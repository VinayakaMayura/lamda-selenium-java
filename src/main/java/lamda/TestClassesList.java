package lamda;

import lombok.Getter;
import lombok.Setter;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
public class TestClassesList {
    private String testClass;
    private String frameworkMethod;

    public static List<Class> getTestClasses(String folderName) {
        Reflections reflections = new Reflections(folderName);
        Set<Class<? extends Event>> allClasses;
        allClasses = reflections.getSubTypesOf(Event.class);
        List<Class> classes = new ArrayList<>();
        classes.addAll(allClasses);
        return classes;
    }
}



