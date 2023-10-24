package app;
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
//import java.util.Scanner;

//import facade.Projetokaiesi;



class App {
        //chamada de Projetokaise
        
    //private static Projetokaiesi facade;
     private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            //System.out.println("Carregando o sistema...");

        //essa chamada aqui estava fazendo meu programa quebrar haha
        
        //Essa linha logo a baixo: 
        /* 
         * Atribui � uma vari�vel, uma int�ncia da classe 'Projetokaise' 
         * por meio do m�todo est�tico 'getIntance'
         * 
         * A classe implementa o padr�o de designer 'Sigleton', que garante que exista
         * apenas uma int�ncia dessa classe em todo o programa, o m�todo 'getInstance'
         * � respons�vel por retornar essa �nica instancia existente ou cria--l� caso
         * ainda n�o tenha sido criada.
         * */
        
    
            //facade = Projetokaiesi.getInstance();
           // cria_dados_testes();//o m�todo que cria dados testes est� no final.

            int opcao;
            do{
                limpaTela();
                System.out.println("    project Kaiesi");
                System.out.println("========================");
                System.out.println("<1> Data path");
                System.out.println("<2> Microprogama memory");
                System.out.println("<3> Main memory");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opc�o:");

                try {

                    opcao = Integer.valueOf(scanner.nextLine());

                } catch (Exception e) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 0: limpaTela(); break;
                    case 1: data_path(); break;
                    //case 2: cadastro_de_livro(); break;
                    //case 3: cadastro_de_exemplar(); break;
                    default: break;
                }
                
            }while(opcao != 0);

           //esse chamada de sa�da, faz com que o programa saia e salve os dados
           //facade.exit();
            
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


    private static void data_path(){
        //Registrador registrador = facade.projetokaiesi();
        limpaTela();
        System.out.println("    Register Bank");
        System.out.println("========================");
        System.out.println("<2> Microprogama memory");
        System.out.println("<3> Main memory");
        System.out.println("<0> Sair");
        System.out.printf("Escolha uma opc�o:");

    }

  

}
