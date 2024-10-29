package servico;

import java.util.ArrayList;

import dominio.Curso;
import repositorio.CursoRepo;



public class CursoServico extends BaseServico<Curso>{
    private CursoRepo repo;

    public CursoServico(){
        this.repo = new CursoRepo();
    }

    @Override
    public ArrayList<Curso> Browse(){
        return this.repo.Browse();
    }

    @Override
    public Curso Read(int chave){
        return this.repo.Read(chave);
    }

    @Override
    public Curso Edit(Curso cursoAlt){
        return this.repo.Edit(cursoAlt);
    }

    @Override
    public Curso Add(Curso obj){
        return this.repo.Add(obj);
    }

    @Override
    public Curso Delete(int chave){
        return this.repo.Delete(chave);
    }
    
}
