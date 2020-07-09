package micronaut.http;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("${service.url}")
public interface ServiceClient {

    @Get("/details/{id}")
    @Consumes
    Single<HttpResponse<?>> getDetails(String id);
}
