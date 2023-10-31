package br.edu.infnet.appvenda;

import br.edu.infnet.appvenda.model.domain.Carro;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

@Order(3)
@Component
public class CarroLoader implements ApplicationRunner {

    @Autowired
    CarroService carroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/carro.txt");
        BufferedReader leitura = new BufferedReader(file);
        String[] campos = null;
        String linha = leitura.readLine();

        while (linha != null){
            campos = linha.split(";");

            Carro carro = new Carro();
            carro.setCodigo(parseInt(campos[0]));
            carro.setNome(campos[1]);
            carro.setPreco(parseFloat(campos[2]));
            carro.setEstoque(Boolean.parseBoolean(campos[3]));
            carro.setNumPassageiros(parseInt(campos[4]));
            carro.setModelo(campos[5]);

            Vendedor vendedor = new Vendedor();
            vendedor.setId(Integer.valueOf(campos[6]));

            carro.setVendedor(vendedor);

            carroService.incluir(carro);

            linha = leitura.readLine();
        }
        leitura.close();

        for (Carro carro: carroService.obterLista()) {
            System.out.println("Carro: " + carro);
        }
    }
}
