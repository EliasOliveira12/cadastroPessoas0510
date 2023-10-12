import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();
        PessoaFisica metodosPf = new PessoaFisica();
        PessoaJuridica metodosPj = new PessoaJuridica();
        System.out.println("Bem vindo ao sistema de cadastro de pessoa Fisica e Juridica");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opcao:1- Pessoa Fisica/2- Pessoa Juridica/0-Sair");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    int opcaopf;
                    do{
                        System.out.println("Escolha uma opcao: 1 - Cadastrar Pessoa Fisica/2-Lista Pessoa Fisica/0-Voltar ao menu anterior");
                        opcaopf = scanner.nextInt();

                        switch (opcaopf){
                            case 1:
                                PessoaFisica novapf = new PessoaFisica();
                                Endereco novoEndpfP = new Endereco();


                                System.out.println("Digite o nome da pessoa fisica");
                                novapf.nome = scanner.next();
                                scanner.nextLine();

                                System.out.println("Digite o CPF");
                                novapf.cpf= scanner.next();
                                System.out.println("Digite o rendimento mensal (Digite somente numero):");
                                novapf.rendimento = scanner.nextInt();
                                System.out.println("Digite a data do Nascimento (dd/MM/aaaa):");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                Period periodo = Period.between(date,LocalDate.now());

                                novapf.dataNascimento = date;

                                if (periodo.getYears()>=18){
                                    System.out.println("A pessoa tem maiks de 18 anos");

                                }else {
                                    System.out.println("A pessoa tem menos de 18 anos. Retornando menu...");
                                    break;
                                }


                                System.out.println("Digite o logradouro:");
                                novoEndpfP.logradouro = scanner.next();
                                scanner.nextLine();
                                System.out.println("Digite o numero");
                                novoEndpfP.numero = scanner.next();
                                System.out.println("Esse endereco e comercial? s/n: ");
                                String endCom;
                                endCom = scanner.next();
                            if (endCom.equalsIgnoreCase("S")){
                                novoEndpfP.enderecoComercial = true;

                            }else{
                                novoEndpfP.enderecoComercial = false;

                            }
                             novapf.endereco = novoEndpfP;

                            listaPf.add(novapf);
                            System.out.println("Cadastro realizado com sucesso");

                                break;
                            case 2:

                                if(listaPf.size()>0){

                                    for(PessoaFisica cadaPf : listaPf){
                                        System.out.println();

                                        System.out.println("nome: " + cadaPf.nome);
                                        System.out.println("CPF" + cadaPf.cpf);
                                        System.out.println("Endereco: " + cadaPf.endereco.logradouro + ", " + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento"+ cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago"+ metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();


                                    }
                                    opcaopf = scanner.nextInt();
                                }else {
                                    System.out.println("Lista vazia");
                                }
                                break;
                            case 0:
                                System.out.println("Voltando ao menu Anterior");
                            break;
                            default:
                                System.out.println("Opcao invalido,por favor digite uma opcao valida");

                                break;
                        }


                    }while (opcaopf != 0);

                    break;
                case 2:











                  int opcaopj;
                    do{
                        System.out.println("Escolha uma opcao: 1 - Cadastrar Pessoa Juridica/2-Lista Pessoa Juridica/0-Voltar ao menu anterior");
                        opcaopj = scanner.nextInt();

                        switch (opcaopj){
                            case 1:
                                PessoaJuridica novapj = new PessoaJuridica();
                                Endereco novoEndpjP = new Endereco();


                                System.out.println("Digite o nome da pessoa juridica");
                                novapj.nome = scanner.next();

                                System.out.println("Digite o CNPJ");
                                novapj.CNPJ= scanner.next();
                                System.out.println("Digite o rendimento mensal (Digite somente numero):");
                                novapj.rendimento = scanner.nextInt();
                                System.out.println("Digitar razao social");
                                novapj.RazaoSocial = scanner.next();


                                System.out.println("Digite o logradouro:");

                                novoEndpjP.logradouro = scanner.next();
                                System.out.println("Digite o numero");
                                novoEndpjP.numero = scanner.next();
                                System.out.println("Esse endereco e comercial? s/n: ");
                                String endCom;
                                endCom = scanner.next();
                                if (endCom.equalsIgnoreCase("S")){
                                    novoEndpjP.enderecoComercial = true;

                                }else{
                                    novoEndpjP.enderecoComercial = false;

                                }
                                novapj.endereco = novoEndpjP;

                                listaPj.add(novapj);
                                System.out.println("Cadastro realizado com sucesso");

                                break;
                            case 2:

                                if(listaPj.size()>0){

                                    for(PessoaJuridica cadaPj : listaPj){
                                        System.out.println();

                                        System.out.println("nome: " + cadaPj.nome);
                                        System.out.println("CNPJ: " + cadaPj.CNPJ);
                                        System.out.println("Razao Social:" + cadaPj.RazaoSocial);
                                        System.out.println("Endereco: "+ cadaPj.endereco.logradouro +","+cadaPj.endereco.numero);
//                                        System.out.println("Data de Nascimento"+ cadaPj.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: "+ metodosPj.CalcularImposto(cadaPj.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();


                                    }
                                    opcaopf = scanner.nextInt();
                                }else {
                                    System.out.println("Lista vazia");
                                }
                                break;
                            case 0:
                                System.out.println("Voltando ao menu Anterior");
                                break;
                            default:
                                System.out.println("Opcao invalido,por favor digite uma opcao valida");

                                break;
                        }


                    }while (opcaopj != 0);






















                        break;
                case 0:
                    System.out.println("Obrigado por utilizar o nosso sistema! Forte abraco!");
                        break;
                default:
                    System.out.println("Opcao invalido,por favor digite uma opcao valida");
                    break;
            }


        } while (opcao !=0);

    }}