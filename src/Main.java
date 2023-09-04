import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite a quantidade de casas: ");
        int num = leitor.nextInt();

        Casa[] casas = new Casa[num];

        for(int i = 0; i < casas.length; i ++){

            casas[i] = new Casa();
            casas[i].portas = new Porta[3];

            for(int j = 0; j < casas[i].portas.length; j++){
                casas[i].portas[j] = new Porta();
            }
        }

        cadastroDeCasas(casas, leitor);

        int option = - 1;

        do{

            mainMenu();

            option = leitor.nextInt();

            switch(option){

                case 1:
                    listarCores(casas);
                    break;

                case 2:
                    listarCoresPortas(casas);
                    break;
                
                case 3:
                    listarDimensoes(casas);
                    break;
                
                case 4:
                    listarPortasAbertas(casas);
                    break;
                
                case 5:
                    consultarPortaAberta(casas, leitor);
                    break;

                default:
                    System.out.println("Opcao Invalida...");
                    break;
            }

        }while(option != 0);

        leitor.close();

    }

    public static void cadastroDeCasas(Casa[] casa, Scanner leitor){

        for(int i = 0; i < casa.length; i++){

            clearConsole();

            System.out.println("Digite a cor da casa " + (i + 1));
            casa[i].pinta(leitor.next());

            for(int j = 0; j < casa[i].portas.length; j++){

                System.out.println("Digite a cor da porta " + (j + 1) + " da casa " + (i + 1));
                casa[i].portas[j].pinta(leitor.next());

                System.out.println("Digite a dimensao X da porta " + (j + 1) + " da casa " + (i + 1));
                casa[i].portas[j].dimensaoX = leitor.nextDouble();

                System.out.println("Digite a dimensao Y da porta " + (j + 1) + " da casa " + (i + 1));
                casa[i].portas[j].dimensaoY = leitor.nextDouble(); 
                
                System.out.println("Digite a dimensao Z da porta " + (j + 1) + " da casa " + (i + 1));
                casa[i].portas[j].dimensaoZ = leitor.nextDouble();      
                
                System.out.println("A porta " + (j + 1) + " esta aberta?");
                System.out.println("1.  Sim\n0.  Nao");

                int isOpen = leitor.nextInt();

                if(isOpen == 1){

                    casa[i].portas[j].abre();
                }else if(isOpen == 0){

                    casa[i].portas[j].fecha();
                }else{

                    System.out.println("Valor Invalido...A porta vai ficar fechada.\n");
                    casa[i].portas[j].fecha();
                }
            }
        }        
    }

    public static void mainMenu(){

        clearConsole();

        System.out.println(
            "1.\tListar cores das casas\n"
            + "2.\tListar cores das portas\n"
            + "3.\tListar dimensoes das portas\n"
            + "4.\tListar quantas portas estao abertas\n"
            + "5.\tConsultar se uma porta esta aberta\n"

        );
    }

    public static void listarCores(Casa[] casa){

        clearConsole();

        for(int i = 0; i < casa.length; i++){
            System.out.println("Casa " + (i + 1) + ": " + casa[i].cor);
        }

    }

    public static void listarCoresPortas(Casa[] casa){

        clearConsole();

        for(int i = 0; i < casa.length; i++){

            System.out.print("Casa " + (i + 1) + " | ");
            for(int j = 0; j < casa[i].portas.length; j++){

                System.out.print("Porta " + (j + 1) + " Cor: " + casa[i].portas[j].cor + " |");
            }

            System.out.println();
        }
    }

    public static void listarDimensoes(Casa[] casa){

        clearConsole();
        
        for(int i = 0; i < casa.length; i++){

            System.out.print("Casa " + (i + 1) + " | ");
            for(int j = 0; j < casa[i].portas.length; j++){

                System.out.print(
                    "Porta " + (j + 1) 
                    + " Dimensoes: " + casa[i].portas[j].dimensaoX
                    + "x" + casa[i].portas[j].dimensaoY
                    + "x" + casa[i].portas[j].dimensaoZ
                    + " | "
                );
            }

            System.out.println();
        }
    }

    public static void listarPortasAbertas(Casa[] casa){

        clearConsole();
        
        for(int i = 0; i < casa.length; i++){

            System.out.print("Casa " + (i + 1) + " | ");
            for(int j = 0; j < casa[i].portas.length; j++){

                System.out.print(
                    "Porta " + (j + 1) 
                    + (casa[i].portas[j].estaAberta() ? "Aberta" : "Fechada")
                );
            }

            System.out.println();
        }
    }

    public static void consultarPortaAberta(Casa[] casa, Scanner leitor){

        clearConsole();

        System.out.println("Digite o numero da casa: ");
        int numCasa = leitor.nextInt() - 1;

        if(numCasa > casa.length - 1){

            System.out.println("Essa casa nao existe...");
            return;
        }else{

            System.out.println("Digite o numero da porta: ");
            int numPorta = leitor.nextInt();
            
            if(numPorta > casa[numCasa].portas.length){

                System.out.println("Essa porta nao existe...");
                return;
            }else{
                System.out.println("Esta porta esta " + (casa[numCasa].portas[numPorta].estaAberta() ? "aberta" : "fechada"));
            }
        }
    }

    public static void clearConsole() {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder = new ProcessBuilder();

            if (osName.contains("win")) {
                processBuilder.command("cmd", "/c", "cls");
            } else {
                processBuilder.command("clear");
            }

            Process process = processBuilder.inheritIO().start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
