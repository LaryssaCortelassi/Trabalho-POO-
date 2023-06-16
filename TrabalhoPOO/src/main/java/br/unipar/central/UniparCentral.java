package br.unipar.central;

import br.unipar.central.models.Agencia;
import br.unipar.central.models.Banco;
import br.unipar.central.models.Cidade;
import br.unipar.central.models.Conta;
import br.unipar.central.models.Endereco;
import br.unipar.central.models.Pessoa;
import br.unipar.central.models.PessoaFisica;
import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.models.Telefone;
import br.unipar.central.models.Pais;
import br.unipar.central.models.Estado;
import br.unipar.central.models.Transacao;
import br.unipar.central.dao.PaisDAO;
import br.unipar.central.models.AgenciaDAO;
import br.unipar.central.models.BancoDAO;
import br.unipar.central.models.CidadeDAO;
import br.unipar.central.models.ContaDAO;
import br.unipar.central.models.EnderecoDAO;
import br.unipar.central.models.PessoaDAO;
import br.unipar.central.models.PessoaFisicaDAO;
import br.unipar.central.models.PessoaJuridicaDAO;
import br.unipar.central.models.TelefoneDAO;
import br.unipar.central.models.EstadoDAO;
import br.unipar.central.models.TransacaoDAO;
import javax.swing.JOptionPane;

import java.util.List;
/**
 *  Houve um probleminha e n vamos usar o menu :/
 * 
 */
public class UniparCentral {
    
    public static void main(String[] args) {
    
    try {
        PaisDAO paisDAO = new PaisDAO();
        List<Pais> listaPais = paisDAO.findAll();
        System.out.println(listaPais.toString());
        
        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> listaEstados = estadoDAO.findAll();
        System.out.println(listaEstados.toString());

        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> listaCidade = cidadeDAO.findAll();
        System.out.println(listaCidade.toString());

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<Agencia> listaAgencia = agenciaDAO.findAll();
        System.out.println(listaAgencia.toString());

        BancoDAO bancoDAO = new BancoDAO();
        List<Banco> listaBanco = bancoDAO.findAll();
        System.out.println(listaBanco.toString());

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> listaEndereco = enderecoDAO.findAll();
        System.out.println(listaEndereco.toString());

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> listaPessoaFisica = pessoaFisicaDAO.findAll();
        System.out.println(listaPessoaFisica.toString());

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        List<PessoaJuridica> listaPessoaJuridica = pessoaJuridicaDAO.findAll();
        System.out.println(listaPessoaJuridica.toString());

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> listaTelefone = telefoneDAO.findAll();
        System.out.println(listaTelefone.toString());

        ContaDAO contaDAO = new ContaDAO();
        List<Conta> listaConta = contaDAO.findAll();
        System.out.println(listaConta.toString());

        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> listaPessoa = pessoaDAO.findAll();
        System.out.println(listaPessoa.toString());

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> listaTransacao = transacaoDAO.findAll();
        System.out.println(listaTransacao.toString());
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
  }     
}

    
/*======================================================================================================================================================== //  
    private static Scanner scanner;

    public static void main(String[] args) {
       
        boolean sair = false;
        boolean sair2 = false;

        scanner = new Scanner(System.in);
        
        

        while (!sair) {
            System.out.println("\n===========< SISTEMA BANCÁRIO >===========");
            System.out.println("1  - AGÊNCIA");
            System.out.println("2  - BANCO");
            System.out.println("3  - CIDADE");
            System.out.println("4  - CONTA");
            System.out.println("5  - ENDEREÇO");
            System.out.println("6  - ESTADO");
            System.out.println("7  - PAÍS");
            System.out.println("8  - PESSOA");
            System.out.println("9  - PESSOA FÍSICA");
            System.out.println("10 - PESSOA JURÍDICA");
            System.out.println("11 - TELEFONE");
            System.out.println("12 - TRANSAÇÃO");
            System.out.println("13 - FECHAR SISTEMA");

            int opcao = scanner.nextInt();
            sair2 = false;
            switch (opcao) {

                case 1:
                    while (!sair2) {
                        System.out.println("================< AGÊNCIA >================");
                        System.out.println("1 - INSERIR AGÊNCIA"); 
                        System.out.println("2 - CONSULTAR AGÊNCIA PELO ID");
                        System.out.println("3 - MOSTRAR TODAS AS AGÊNCIAS");
                        System.out.println("4 - ATUALIZAR AGÊNCIA PELO ID");
                        System.out.println("5 - DELETAR AGÊNCIA PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR AGÊNCIA >============");
                                AgenciaService.
                                //agenciaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR AGÊNCIA PELO ID >============");
                                //agenciaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODAS AS AGÊNCIAS >============");
                                //agenciaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR AGÊNCIA PELO ID >============");
                                //agenciaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR AGÊNCIA PELO ID >============");
                                //agenciaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 2:
                    while (!sair2) {
                        System.out.println("================< BANCO >================");
                        System.out.println("1 - INSERIR BANCO"); 
                        System.out.println("2 - CONSULTAR BANCO PELO ID");
                        System.out.println("3 - MOSTRAR TODOS OS BANCOS");
                        System.out.println("4 - ATUALIZAR BANCO PELO ID");
                        System.out.println("5 - DELETAR BANCO PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR BANCO >============");
                                //bancoExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR BANCO PELO ID >============");
                                //bancoExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODOS OS BANCOS >============");
                                //bancoExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR BANCO PELO ID >============");
                                //bancoExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR BANCO PELO ID >============");
                                //bancoExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 3:
                    while (!sair2) {
                        System.out.println("================< CIDADE >================");
                        System.out.println("1 - INSERIR CIDADE"); 
                        System.out.println("2 - CONSULTAR CIDADE PELO ID");
                        System.out.println("3 - MOSTRAR TODAS AS CIDADES");
                        System.out.println("4 - ATUALIZAR CIDADE PELO ID");
                        System.out.println("5 - DELETAR CIDADE PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR CIDADE >============");
                                //cidadeExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR CIDADE PELO ID >============");
                                //cidadeExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODAS AS CIDADES >============");
                                //cidadeExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR CIDADE PELO ID >============");
                                //cidadeExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR CIDADE PELO ID >============");
                                //cidadeExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 4:
                    while (!sair2) {
                        System.out.println("================< CONTA >================");
                        System.out.println("1 - INSERIR CONTA"); 
                        System.out.println("2 - CONSULTAR CONTA PELO ID");
                        System.out.println("3 - MOSTRAR TODAS AS CONTAS");
                        System.out.println("4 - ATUALIZAR CONTA PELO ID");
                        System.out.println("5 - DELETAR CONTA PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR CONTA >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR CONTA PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODAS AS CONTAS >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR CONTA PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR CONTA PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 5:
                    while (!sair2) {
                        System.out.println("================< ENDEREÇO >================");
                        System.out.println("1 - INSERIR ENDERECO"); 
                        System.out.println("2 - CONSULTAR ENDEREÇO PELO ID");
                        System.out.println("3 - MOSTRAR TODOS OS ENDEREÇOS");
                        System.out.println("4 - ATUALIZAR ENDEREÇO PELO ID");
                        System.out.println("5 - DELETAR ENDEREÇO PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR ENDEREÇO >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR ENDEREÇO PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODOS OS ENDEREÇOS >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR ENDEREÇO PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR ENDEREÇO PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 6:
                    while (!sair2) {
                        System.out.println("================< ESTADO >================");
                        System.out.println("1 - INSERIR ESTADO"); 
                        System.out.println("2 - CONSULTAR ESTADO PELO ID");
                        System.out.println("3 - MOSTRAR TODOS OS ESTADOS");
                        System.out.println("4 - ATUALIZAR ESTADO PELO ID");
                        System.out.println("5 - DELETAR ESTADO PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR ESTADO >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR ESTADO PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODOS OS ESTADOS >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR ESTADO PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR ESTADO PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 7:
                    while (!sair2) {
                        System.out.println("================< PAÍS >================");
                        System.out.println("1 - INSERIR PAIS"); 
                        System.out.println("2 - CONSULTAR PAIS PELO ID");
                        System.out.println("3 - MOSTRAR TODOS OS PAÍSES");
                        System.out.println("4 - ATUALIZAR PAÍS PELO ID");
                        System.out.println("5 - DELETAR PAÍS PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR PAÍS >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR PAÍS PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODOS OS PAÍSES >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR PAÍS PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR PAÍS PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 8:
                    while (!sair2) {
                        System.out.println("================< PESSOA >================");
                        System.out.println("1 - INSERIR PESSOA"); 
                        System.out.println("2 - CONSULTAR PESSOA PELO ID");
                        System.out.println("3 - MOSTRAR TODAS AS PESSOAS");
                        System.out.println("4 - ATUALIZAR PESSOA PELO ID");
                        System.out.println("5 - DELETAR PESSOA PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR PESSOA >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR PESSOA PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODAS AS PESSOAS >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR PESSOA PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR PESSOA PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 9:
                    while (!sair2) {
                        System.out.println("================< PESSOA FÍSICA >================");
                        System.out.println("1 - INSERIR PESSOA FÍSICA"); 
                        System.out.println("2 - CONSULTAR PESSOA FÍSICA PELO ID");
                        System.out.println("3 - MOSTRAR TODAS AS PESSOAS FÍSICAS");
                        System.out.println("4 - ATUALIZAR PESSOA FÍSICA PELO ID");
                        System.out.println("5 - DELETAR PESSOA FÍSICA PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR PESSOA FÍSICA >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR PESSOA FÍSICA PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODAS AS PESSOAS FÍSICAS >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR PESSOA FÍSICA PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR PESSOA FÍSICA PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 10:
                    while (!sair2) {
                        System.out.println("================< PESSOA JURÍDICA >================");
                        System.out.println("1 - INSERIR PESSOA JURÍDICA"); 
                        System.out.println("2 - CONSULTAR PESSOA JURÍDICA PELO ID");
                        System.out.println("3 - MOSTRAR TODAS AS PESSOAS JURÍDICAS");
                        System.out.println("4 - ATUALIZAR PESSOA JURÍDICA PELO ID");
                        System.out.println("5 - DELETAR PESSOA JURÍDICA PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR PESSOA JURÍDICA >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR PESSOA JURÍDICA PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODAS AS PESSOAS JURÍDICAS >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR PESSOA JURÍDICA PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR PESSOA JURÍDICA PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 11:
                    while (!sair2) {
                        System.out.println("================< TELEFONE >================");
                        System.out.println("1 - INSERIR TELEFONE"); 
                        System.out.println("2 - CONSULTAR TELEFONE PELO ID");
                        System.out.println("3 - MOSTRAR TODOS OS TELEFONES");
                        System.out.println("4 - ATUALIZAR TELEFONE PELO ID");
                        System.out.println("5 - DELETAR TELEFONE PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR TELEFONE >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR TELEFONE PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODOS OS TELEFONES >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR TELEFONE PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR TELEFONE PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                
                case 12:
                    while (!sair2) {
                        System.out.println("================< TRANSAÇÃO >================");
                        System.out.println("1 - INSERIR TRANSAÇÃO"); 
                        System.out.println("2 - CONSULTAR TRANSAÇÃO PELO ID");
                        System.out.println("3 - MOSTRAR TODAS AS TRANSAÇÕES");
                        System.out.println("4 - ATUALIZAR TRANSAÇÃO PELO ID");
                        System.out.println("5 - DELETAR TRANSAÇÃO PELO ID");
                        System.out.println("6 - VOLTAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("============< INSERIR TRANSAÇÃO >============");
                                //contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("============< CONSULTAR TRANSAÇÃO PELO ID >============");
                                //contaExecution.FindById();
                                break;
                            case 3:
                                System.out.println("============< MOSTRAR TODAS AS TRANSAÇÕES >============");
                                //contaExecution.FindAll();
                                break;
                            case 4:
                                System.out.println("============< ATUALIZAR TRANSAÇÃO PELO ID >============");
                                //contaExecution.Update();
                                break;
                            case 5:
                                System.out.println("============< DELETAR TRANSAÇÃO PELO ID >============");
                                //contaExecution.DeleteById();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("\nNão seja burro, essa opção não existe!!!");
                        } 
                    }
                break;
                case 13:
                    sair = true;
                    break;
                default:
                    System.out.println("\nNão seja burro, essa opção não existe!!!");
            }
        } System.out.println("Goodbye");
    }
}
//=======================================================================================================================================================================
