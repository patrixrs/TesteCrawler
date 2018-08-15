package Classes;
/**
 * @author patrixrs <patrix.pfr@gmail.com>
 */
public class Imoveis {
    private String preco, bairro, rua, cidade, descricao, num, quartos, vagas, tamanho;    

    public Imoveis() {
    }    
    
    public Imoveis(String preco, String quartos, String vagas, String tamanho, String bairro, String rua, String num, String cidade, String descricao){
        this.preco = preco;
        this.quartos = quartos;
        this.vagas = vagas;
        this.tamanho = tamanho;
        this.bairro = bairro;
        this.rua = rua;
        this.num = num;
        this.cidade = cidade;
        this.descricao = descricao;        
    }

    public String getQuartos() {
        return quartos;
    }

    public void setQuartos(String quartos) {
        this.quartos = quartos;
    }

    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Imoveis{" + "preco=" + preco + ", bairro=" + bairro + ", rua=" + rua + ", cidade=" + cidade + ", descricao=" + descricao + ", num=" + num + ", quartos=" + quartos + ", vagas=" + vagas + ", tamanho=" + tamanho + '}';
    }   
    
}
