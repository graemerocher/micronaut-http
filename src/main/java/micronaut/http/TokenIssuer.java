package micronaut.http;

import io.micronaut.context.annotation.Property;
import io.reactivex.Single;

import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class TokenIssuer {

    private final Provider<AuthClient> authClient;
    private final String clientId;

    public TokenIssuer(
            Provider<AuthClient> authClient,
            @Property(name = "client.id") String clientId
    ) {
        this.authClient = authClient;
        this.clientId = clientId;
    }

    public Single<Token> retrieveToken() {
        return authClient.get().retrieveToken(new AuthRequest(clientId));
    }
}
