package it.apifirst.lab.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.openapi.quarkus.geo_service_yaml.api.DefaultApi;
import org.openapi.quarkus.geo_service_yaml.model.Country;
import org.openapi.quarkus.geo_service_yaml.model.InlineResponse200;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;


@Path("/geo/client")
public class GeoResource {

    @RestClient
    @Inject
    DefaultApi defaultApi;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GeoResult countriesInItalianLang() {
        var resp = defaultApi.getCountries("it", new BigDecimal(0), new BigDecimal(10));
        var list = resp.getData();
        return new GeoResult(list.size(), list.stream().map(Country::getName).toList());
    }
}
