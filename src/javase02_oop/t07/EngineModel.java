package javase02_oop.t07;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface EngineModel {
    String engineModel();
}
