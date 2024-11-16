package br.com.igordmoura.desafio_picpay.service;

import br.com.igordmoura.desafio_picpay.client.AuthorizationClient;
import br.com.igordmoura.desafio_picpay.controller.dto.TransferDto;
import br.com.igordmoura.desafio_picpay.exception.PicPayException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer) {
        var response = authorizationClient.isAuthorized();

        if(response.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return response.getBody().authorized();
    }
}
