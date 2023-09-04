public class Porta {
    boolean aberta;
    String cor;
    double dimensaoX, dimensaoY, dimensaoZ;

    void abre(){
        this.aberta = true;
    }

    void fecha(){
        this.aberta = false;
    }

    void pinta(String cor){
        this.cor = cor;
    }

    boolean estaAberta(){
        return this.aberta;
    }
}
