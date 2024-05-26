package com.nominatim.model;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.License;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@OpenAPIDefinition(
    info = @Info(
        title = "Nominatim API",
        version = "1.0.0",
        contact = @Contact(
            name = "Aydin Rzayev",
            email = "rzayevaydin01@gmail.com"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "http://www.apache.org/licenses/LICENSE-2.0.html"
        )
    )
)
public class OpenApiConfig extends Application {
}

