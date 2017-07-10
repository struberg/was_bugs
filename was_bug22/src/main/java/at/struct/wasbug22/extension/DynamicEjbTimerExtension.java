package at.struct.wasbug22.extension;

import at.struct.wasbug22.interceptor.DynamicBoundEjbTimer;
import org.apache.deltaspike.core.util.metadata.AnnotationInstanceProvider;
import org.apache.deltaspike.core.util.metadata.builder.AnnotatedTypeBuilder;

import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

public class DynamicEjbTimerExtension implements Extension {

    public <T> void wrapInterceptor(@Observes ProcessAnnotatedType<T> pat) {
        if (!pat.getAnnotatedType().isAnnotationPresent(Singleton.class)) {
            return;
        }

        for (AnnotatedMethod<? super T> method : pat.getAnnotatedType().getMethods()) {
            if (method.isAnnotationPresent(Timeout.class)) {

                AnnotatedTypeBuilder<T> annotatedTypeBuilder = new AnnotatedTypeBuilder<T>()
                        .readFromType(pat.getAnnotatedType())
                        .addToClass(AnnotationInstanceProvider.of(DynamicBoundEjbTimer.class));
                pat.setAnnotatedType(annotatedTypeBuilder.create());
                return;
            }
        }
    }
}
