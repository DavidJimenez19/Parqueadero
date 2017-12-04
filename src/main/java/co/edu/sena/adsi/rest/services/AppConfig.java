package co.edu.sena.adsi.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author david
 */
@ApplicationPath("api")
public class AppConfig extends ResourceConfig{

    public AppConfig() {
        packages("co.edu.sena.adsi.rest.services;co.edu.sena.adsi.rest.auth");
        register(RolesAllowedDynamicFeature.class);
        register(MultiPartFeature.class);
    }
}
