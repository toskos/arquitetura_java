package br.edu.infnet.appvenda;

import br.edu.infnet.appvenda.model.domain.Moto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.io.BufferedReader;
import java.io.FileReader;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

@Order(2)
@Component
public class MotoLoader implements ApplicationRunner {

    @Autowired
    MotoService motoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/moto.txt");
        BufferedReader leitura = new BufferedReader(file);
        String[] campos = null;
        String linha = leitura.readLine();

        while (linha != null){
            campos = linha.split(";");

            Moto moto = new Moto();
            moto.setCodigo(campos[0]);
            moto.setNome(campos[1]);
            moto.setPreco(parseFloat(campos[2]));
            moto.setEstoque(Boolean.parseBoolean(campos[3]));
            moto.setMarca(campos[4]);
            moto.setVelocidadeMaxima(parseInt(campos[5]));

            Vendedor vendedor = new Vendedor();
            vendedor.setId(Integer.valueOf(campos[6]));

            moto.setVendedor(vendedor);

            try {
                motoService.incluir(moto);
            } catch (ConstraintViolationException e) {
                FileLogger.logException("[MOTO] " + moto + " - " + e.getMessage());
            }

            linha = leitura.readLine();
        }
        leitura.close();

        for (Moto moto: motoService.obterLista()) {
            System.out.println("Moto: " + moto);
        }
    }
}
