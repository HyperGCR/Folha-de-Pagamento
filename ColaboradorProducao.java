public class ColaboradorProducao extends Colaborador{
    
private double valorPeça;
private int quantidadeProduzida;

public ColaboradorProducao(int numRegistro, String nomeComp, double valorPeça, int quantidadeProduzida){
    super(numRegistro, nomeComp);
    this.valorPeça = valorPeça;
    this.quantidadeProduzida = quantidadeProduzida;


}

@Override

public double calcSalarioF(){
    double bonusProdutividade = valorPeça * quantidadeProduzida;
    return SAL_BASE + bonusProdutividade;
}


}