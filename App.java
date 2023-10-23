/**
 * @author Lucas Balmant
 * 
 * Esse projeto foi baseado no projeto do professo Enoque da Universidade federal do Oeste do Par�
 * 
 * Nas primeiras vers�es estava com problemas nas chamadas(acesso a dados do reposit�rio), alguns dos erros acredito que
 * foram causados por conta de alguma incopatiblidade do java com vs code, ou  pode   ser
 * por conta de algum erro na pr�pria linguagem que eu desconhe�o, fiz algumas altera��es para
 * resolver isso, criei um novo projeto no vs code vazio e quando se faz isso, algumas   
 * algumas pastas s�o criadas autom�ticamente elas s�o:
 * .vs code
 * bin
 * lib
 * src
 * -
 * Deppois copiei, todo o projeto para dentro da pasta src, isso � claro no novo projeto
 * e at� o momento todas as minhas chamadas est�o funcionando perfeitamente.
 * **/

//TODOS OS IMPORT'S DEVEM SER FEITOS AQUI.
import java.util.List;
import java.util.Scanner;
//import java.io.FileInputStream;

import model.aluno.*;
import model.emprestimo.Emprestimo;

import repository.RepositoryException;
import repository.exemplar.ExemplarNaoCadastradoException;
import repository.livro.LivroNaoCadastradoException;
//import do exemplar
import model.exemplar.*;
import model.livro.*;
//import repository.exemplar.*;

//"fachada"
import facade.BibliotecaUniversidade;
import facade.BibliotecaException;


class App {
        //chamada de biblioteca
    private static BibliotecaUniversidade facade;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            System.out.println("Carregando o sistema...");

        //essa chamada aqui estava fazendo meu programa quebrar haha
        
        //Essa linha logo a baixo: 
        /* 
         * Atribui � uma vari�vel, uma int�ncia da classe 'Biblioteca universidade' 
         * por meio do m�todo est�tico 'getIntance'
         * 
         * A classe implementa o padr�o de designer 'Sigleton', que garante que exista
         * apenas uma int�ncia dessa classe em todo o programa, o m�todo 'getInstance'
         * � respons�vel por retornar essa �nica instancia existente ou cria--l� caso
         * ainda n�o tenha sido criada.
         * */
        
            facade = BibliotecaUniversidade.getInstance();

            cria_dados_testes();//o m�todo que cria dados testes est� no final.

            int opcao;
            do{
                limpaTela();
                System.out.println("    MENU PRINCIPAL");
                System.out.println("========================");
                System.out.println("<1> Cadastrar Aluno");
                System.out.println("<2> Cadastrar Livros");
                System.out.println("<3> Cadastrar Exemplar");
                System.out.println("<4> Emprestimos");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opc�o:");

                try {

                    opcao = Integer.valueOf(scanner.nextLine());

                } catch (Exception e) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 0: 
                        limpaTela();
                        break;
                    case 1:
                        cadastro_de_alunos();
                        break;
                    case 2:
                        cadastro_de_livro();
                        break;
                    case 3: 
                        cadastro_de_exemplar();
                        break;
                    case 4: 
                        cadastrar_emprestimos(); 
                        break;
                
                    default:
                        break;
                }
                
            }while(opcao != 0);

           //esse chamada de sa�da, faz com que o programa saia e salve os dados
           facade.exit();
            
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados");
            e.printStackTrace();
        }
        System.out.println("Programa terminado");
    }

    //Esse m�todo n�o limpa a tela, ele somente  imprime v�rios espa�os na tela.
    private static void limpaTela(){ 
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


  

    //fim das linhas

     

    //parte destinada para dados de teste
    //Est� adicionando apenas Usu�rio
    

    private static void cria_dados_testes(){

        try {
            facade.inserir_aluno(new Aluno("Lucas Balmant", "111.111.111-11", "20230708", "Rua Bom Jardim", "99999999999"));
            facade.inserir_aluno(new Aluno("Peter Parker", "2", "20230709", "Nova York", "22222222222"));

            //dados de acesso r�pido
            facade.inserir_aluno(new Aluno("Minato ", "1", "2","mundo", "4"));

            facade.inserir_livro(new Livro("Berserk", "Kentaro","fantasy"));
            facade.inserir_livro(new Livro("A arte", "Minato","aventura"));
            facade.inserir_livro(new Livro("Olho de Vidro", "Tales", "Horror"));
            facade.inserir_livro(new Livro("Vingadores","Marvel","comedia"));


            //inserir as informa��es de livro
            Livro livro = facade.buscar_Livro("1");
            Livro livro2 = facade.buscar_Livro("2");
            Livro livro3 = facade.buscar_Livro("3");
            Livro livro4 = facade.buscar_Livro("4");

            
            facade.inserir_exemplar(new Exemplar(livro, true, true));

            facade.inserir_exemplar(new Exemplar(livro2, true, false));

            facade.inserir_exemplar(new Exemplar(livro3, true,false));

            facade.inserir_exemplar(new Exemplar(livro4, true, false));

            Aluno aluno = facade.buscar_Aluno("111.111.111-11");

            Aluno aluno2 = facade.buscar_Aluno("2");

            Exemplar exemplar1 = facade.buscar_Exemplar("1");

            Exemplar exemplar2 = facade.buscar_Exemplar("2");


            facade.inserir_novo_emprestimo(new Emprestimo(aluno, exemplar1 ));

            facade.inserir_novo_emprestimo(new Emprestimo(aluno2, exemplar2));

            //dados de teste  de exemplar2
            
            // biblioteca.inserir_exemplar(new Exemplar("macacos voadores", "Jhony bravo", "Fantasia", 02, true, null));
            //biblioteca.inserir_exemplar(new Exemplar("Pantera ", "Michael Rusber", "Terror", 03, true, null));
        } catch (RepositoryException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
