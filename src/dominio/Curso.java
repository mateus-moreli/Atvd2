package dominio;

public class Curso {
    
    private int codigo, cargaHoraria;
    private String nome, descricao;
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso() {

    }
    public Curso(int codigo, int cargaHoraria, String nome, String descricao) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.nome = nome;
        this.descricao = descricao;
    }
    

}
