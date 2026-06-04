public class Colaborador {

    private int numRegistro;
    private String nomeComp;

    protected static final double SAL_BASE = 2000.00;

    public Colaborador(int numRegistro, String nomeComp) {

        this.numRegistro = numRegistro;
        this.nomeComp = nomeComp;


    }

    public double calcSalarioF(){

        return SAL_BASE;

    }

    public String getNomeCompleto() {return nomeComp;}
    public int getNumeroRegistro() {return numRegistro;}



}