package visao;

import java.util.ArrayList;

import dominio.Curso;
import servico.CursoServico;

public class CursoMenu extends BaseMenu {
    private CursoServico srv;

    public CursoMenu(){
        super();
        this.srv = new CursoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while(opcao != 9){
            Util.LimparConsole();
            System.out.println("Cadastro de Cursos");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Selecione uma opção: ");            
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("LISTA DE CURSOS: ");
    
        ArrayList<Curso> lista = this.srv.Browse();
        for (Curso cs: lista){
            this.Imprimir(cs);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }
    

    @Override
    public void Localizar() {
        Util.LimparConsole();
        System.out.println("LOCALIZAÇÃO DE CURSO");
        System.out.print("Informe o código do curso: ");
        int cod = this.scanner.nextInt();
        
        Curso cs = this.srv.Read(cod);
        if (cs != null){
            this.Imprimir(cs);
        }
        else{
            System.out.println("Erro - Curso não encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("ADIÇÃO DE CURSO");
        //nome, descrição e carga horária
        System.out.print("Informe o nome do curso: ");
        String nome = this.scanner.next();
        Curso cs = new Curso();
        cs.setNome(nome);
        System.out.print("Informe a descrição do curso: ");
        String descricao = this.scanner.next();
        cs.setDescricao(descricao);
        System.out.print("Informe o nome do curso: ");
        int cargaHoraria = this.scanner.nextInt();
        cs.setCargaHoraria(cargaHoraria);

        if (this.srv.Add(cs) != null){
            System.out.println("Sucesso - Curso adicionado com sucesso");
        }
        else{
            System.out.println("Erro - Erro ao adicionar o curso");
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        System.out.println("ATUALIZAÇÃO DE CURSO: ");

        System.out.print("Informe o código do curso a ser alterado: ");
        int cod = this.scanner.nextInt();
        Curso cs = this.srv.Read(cod);
        if (cs != null){
            int opcao = 0;
            while (opcao != 9){
                Util.LimparConsole();
                System.out.println("Menu de Alteração: ");
                System.out.println("1 - Nome");
                System.out.println("2 - Descrição");
                System.out.println("3 - Carga Horária");
                System.out.print("Selecione o que deseja alterar: ");
                opcao = this.scanner.nextInt();

                switch (opcao){
                    case 1:
                        System.out.println("Informe o novo nome: ");
                        String nome = this.scanner.next();
                        cs.setNome(nome);
                        if (this.srv.Edit(cs) != null){
                            System.out.println("Alteração realizada com sucesso");
                        }
                        else{
                            System.out.println("Problema - alteração não foi realizada");
                        }
                        opcao = 9;
                        break;
                    case 2:
                        System.out.println("Informe a nova descrição: ");
                        String desc = this.scanner.next();
                        cs.setDescricao(desc);
                        if (this.srv.Edit(cs) != null){
                            System.out.println("Alteração realizada com sucesso");
                        }
                        else{
                            System.out.println("Problema - alteração não foi realizada");
                        }
                        opcao = 9;
                        break;
                    case 3:
                        System.out.println("Informe a nova carga horária: ");
                        int cargaHoraria = this.scanner.nextInt();
                        cs.setCargaHoraria(cargaHoraria);
                        if (this.srv.Edit(cs) != null){
                            System.out.println("Alteração realizada com sucesso");
                        }
                        else{
                            System.out.println("Problema - alteração não foi realizada");
                        }
                        opcao = 9;
                        break;
                    default:
                        System.out.println("ERRO - OPÇÃO INVÁLIDA");
                        opcao = 9;
                        break;
                }
            }
        }
        else{
            System.out.println("Erro - Curso não encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();
        System.out.println("REMOÇÃO DE CURSO");
        System.out.print("Informe o código do curso a ser removido: ");
        int cod = this.scanner.nextInt();
        Curso cs = this.srv.Read(cod);

        if (cs != null){
            if (this.srv.Delete(cod) != null){
                System.out.println("Curso excluído com sucesso");
            }
            else {
                System.out.println("Erro - Curso não foi excluído");
            }
        }
        else{
            System.out.println("Erro - Curso não encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void Imprimir(Curso cs){
        System.out.println("Curso: ");
        System.out.println("Código: " + cs.getCodigo());
        System.out.println("Nome: " + cs.getNome());
        System.out.println("Descrição: " + cs.getDescricao());
        System.out.println("Carga Horária: " + cs.getCargaHoraria());
        System.out.println("--------------------------------------------------------");
    }
    
}
