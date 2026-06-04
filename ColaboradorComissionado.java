public class ColaboradorComissionado extends Colaborador{
    
    private double totalVendas;
    private double percentualComissao;

    public ColaboradorComissionado(int numRegistro, String nomeComp, double totalVendas, double percentualComissao){

        super(numRegistro, nomeComp);
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcSalarioF(){

        double comissao = (totalVendas * percentualComissao) / 100;
        return SAL_BASE + comissao;

    }


    
}