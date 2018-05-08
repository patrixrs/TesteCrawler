package Classes;
/**
 * @author patrixrs <patrix.pfr@gmail.com>
 */
public class Imoveis {
    private String bairro, rua, cidade, descricao, num;

    public Imoveis() {
    }    
    
    public Imoveis(String bairro, String rua, String num, String cidade, String descricao){
        this.bairro = bairro;
        this.rua = rua;
        this.num = num;
        this.cidade = cidade;
        this.descricao = descricao;        
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
        return "Imovel {" + "bairro=" + bairro + ", rua=" + rua + ", cidade=" + cidade + ", descricao=" + descricao + ", num=" + num + '}';
    }
    
}
