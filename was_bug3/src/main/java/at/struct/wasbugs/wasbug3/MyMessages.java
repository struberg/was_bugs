package at.struct.wasbugs.wasbug3;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageTemplate;

/**
 *
 */
@MessageBundle
public interface MyMessages {

    @MessageTemplate("hello {0}")
    String sayHelloTo(String name);
}
