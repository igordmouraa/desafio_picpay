package br.com.igordmoura.desafio_picpay.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.igordmoura.desafio_picpay.Repository.WalletTypeRepository;
import br.com.igordmoura.desafio_picpay.entity.WalletType;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WalletTypeRepository walletTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Salva os valores do enum no repositório
        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
