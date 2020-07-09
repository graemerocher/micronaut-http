package micronaut.http;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Requires(property = "service.url")
public class RequestValidator {

    private final ServiceClient serviceClient;

    @Inject
    public RequestValidator(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public Single<Boolean> isValid(final String id) {
        return serviceClient.getDetails(id).map(httpResponse -> httpResponse.getStatus().equals(HttpStatus.OK));
    }

}