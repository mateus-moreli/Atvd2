package visao;
import java.util.ArrayList;

import dominio.Curso;
import servico.CursoServico;


public class CursoVisao {
    private CursoServico srv;

    public CursoVisao(){
        this.srv = new CursoServico();
    }

    public void Exibir(){
        ArrayList<Curso> lista = this.srv.Browse();
        System.out.println("===========================================================");
        for (Curso cs : lista) {
            this.Imprimir(cs);
        }
    }

    public void Imprimir(Curso cs){
        System.out.println("Curso: ");
        System.out.println("Código: " + cs.getCodigo());
        System.out.println("Nome: " + cs.getNome());
        System.out.println("Descrição: " + cs.getDescricao());
        System.out.println("Carga Horária: " + cs.getCargaHoraria());
        System.out.println("--------------------------------------------------------");
    }

    public void Criar(Curso novo){
        this.srv.Add(novo);
    }

    public void Editar(int chave, Curso alterado){
        Curso cs = this.srv.Read(chave);
        if (cs != null){
            cs.setNome(alterado.getNome());
            cs.setDescricao(alterado.getDescricao());
            cs.setCargaHoraria(alterado.getCargaHoraria());
        }
    }

    public void Remover(int chave){
        Curso cs = this.srv.Read(chave);
        if (cs != null){
            this.srv.Delete(chave);
            cs = this.srv.Read(chave);
            if (cs == null){
                System.out.println("Sucesso - Item removido com sucesso");
            }
            else{
                System.out.println("Erro - Falha ao remover item");
            }
        }
        else{
            System.out.println("Item não localizado");
        }
    }
}
