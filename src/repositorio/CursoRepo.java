package repositorio;

import dominio.Curso;
import fakedb.CursoFakeDB;

public class CursoRepo extends BaseRepositorio<Curso>{   
    private CursoFakeDB db; //cria uma instância do banco de dados

    public CursoRepo(){
        this.db = new CursoFakeDB();
        this.dados = this.db.getTabela();
    }
    //BREAD - Browse Read Edit Add Delete


    public Curso Edit(Curso instancia){
        Curso cs = this.Read(instancia.getCodigo());
        if (cs != null){
            cs.setNome(instancia.getNome());
            cs.setDescricao(instancia.getDescricao());
            cs.setCargaHoraria(instancia.getCargaHoraria());
            return cs;
        }
        else{
            return null;
        }
    }

    public Curso Read(int chave){
        for (Curso cs: this.dados){
            if (cs.getCodigo() == chave){
                return cs; //se achar, devolve o objeto
            }
        }
        return null; //se não, devolve nulo
    }


    public Curso Add(Curso entidade){
        int posicao = this.dados.size() - 1;
        Curso cs = this.dados.get(posicao);
        int proxChave = cs.getCodigo() + 1;

        entidade.setCodigo(proxChave);
        this.dados.add(entidade);
        return entidade;
    }

    public Curso Delete(int chave){
        Curso cs = this.Read(chave); //acha quem é
        if (cs != null){ //se ele existir
            this.dados.remove(cs);
            return cs;
        }
        else{
            return null;
        }
    }

}
