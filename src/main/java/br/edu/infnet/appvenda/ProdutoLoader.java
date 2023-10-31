package br.edu.infnet.appvenda;

import br.edu.infnet.appvenda.model.domain.Carro;
import br.edu.infnet.appvenda.model.domain.Moto;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

@Order(4)
@Component
public class ProdutoLoader implements ApplicationRunner {

    @Autowired
    ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/produtos.txt");
        BufferedReader leitura = new BufferedReader(file);
        String[] campos = null;
        String linha = leitura.readLine();

        while (linha != null){
            campos = linha.split(";");
            Vendedor vendedor = new Vendedor();

            switch (campos[6]){
                case "M":
                    Moto moto = new Moto();
                    moto.setCodigo(parseInt(campos[0]));
                    moto.setNome(campos[1]);
                    moto.setPreco(parseFloat(campos[2]));
                    moto.setEstoque(Boolean.parseBoolean(campos[3]));
                    moto.setMarca(campos[4]);
                    moto.setVelocidadeMaxima(parseInt(campos[5]));

                    vendedor.setId(Integer.valueOf(campos[7]));

                    moto.setVendedor(vendedor);

                    produtoService.incluir(moto);
                    break;
                case "C":
                    Carro carro = new Carro();
                    carro.setCodigo(parseInt(campos[0]));
                    carro.setNome(campos[1]);
                    carro.setPreco(parseFloat(campos[2]));
                    carro.setEstoque(Boolean.parseBoolean(campos[3]));
                    carro.setNumPassageiros(parseInt(campos[4]));
                    carro.setModelo(campos[5]);

                    vendedor.setId(Integer.valueOf(campos[7]));

                    carro.setVendedor(vendedor);

                    produtoService.incluir(carro);
                    break;
            }

            linha = leitura.readLine();
        }
        leitura.close();

        for (Produto produto: produtoService.obterLista()) {
            System.out.println("Produto: " + produto);
        }
    }
}
