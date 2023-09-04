public class Casa {
    String cor;
    Porta[] portas;

    void pinta(String cor){
        this.cor = cor;
    }

    int quantasPortasEstaoAbertas(){
        
        int count = 0;
        
        for(int i = 0; i < portas.length; i++){
            if(portas[i].estaAberta()) count++;
        }

        return count;
    }
}
