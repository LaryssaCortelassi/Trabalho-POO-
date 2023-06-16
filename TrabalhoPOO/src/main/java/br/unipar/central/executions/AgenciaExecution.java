package br.unipar.central.executions;

import br.unipar.central.models.Agencia;
import br.unipar.central.models.Banco;
import br.unipar.central.services.AgenciaService;
import java.util.Scanner;

/**
 *
 * @author Laly
 */
public class AgenciaExecution {
    
     public String Insert() {
        try {
            Agencia agencia = new Agencia();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de agencia: ");
            agencia.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o código da agencia: ");
            agencia.setCodigo(scanner.nextLine());
            System.out.println("Informe o dígito de agencia: ");
            agencia.setDigito(scanner.nextLine());
            System.out.println("Informe a razão social da agencia: ");
            agencia.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o cnpj da agencia: ");
            agencia.setCnpj(scanner.nextLine());
            System.out.println("Informe o ra de agencia: ");
            agencia.setRa(scanner.nextLine());
            System.out.println("Informe o id do banco: ");
            Banco bancoPOJO = new Banco();
            bancoPOJO.setId(scanner.nextInt());
            agencia.setBanco(bancoPOJO);
            AgenciaService agenciaService = new AgenciaService();
            agenciaService.insert(agencia);
            String msg = "Inserido com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao inserir " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }
}
