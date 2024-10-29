package fakedb;

import java.util.ArrayList;

import dominio.Curso;

public class CursoFakeDB extends BaseFakeDB<Curso>{
    public CursoFakeDB() {
        super();
    }

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<Curso>();
        this.tabela.add(new Curso(1, 60, "Programação Orientada a Objetos", "Curso de Programação Orientada a Objetos"));
        this.tabela.add(new Curso(2, 60, "Algoritmos e Estrutura de Dados Avançado", "Estudo de estruturas de dados como árvores binárias"));
        this.tabela.add(new Curso(3, 50, "Métodos Matemáticos", "Estudo de técnicas matemáticas aplicadas à resolução de problemas complexos"));
        this.tabela.add(new Curso(4, 40, "Engenharia de Software", "Estudo das metodologias de desenvolvimento de software e práticas de garantia da qualidade."));
        this.tabela.add(new Curso(5, 40, "Sistemas de Comunicação e Informação", "Estudo do panorama do TI"));

    }

}
