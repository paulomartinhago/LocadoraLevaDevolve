package persistencia;

import java.util.ArrayList;
import java.util.Date;
import mapeamentos.CategoriaLivro;
import mapeamentos.Cliente;
import mapeamentos.Emprestimo;
import mapeamentos.EmprestimoItem;
import mapeamentos.EmprestimoItemPk;
import mapeamentos.Funcionario;
import mapeamentos.Livro;

public class TesteDePersistencia 
{
    public void testar()
    {
        DAO dao = new DAO();
        
        funcionarios(dao);
        clientes(dao);
        categoriasLivro(dao);
        livros(dao);
        emprestimos(dao);
        emprestimosItens(dao);
    }
    
    public void funcionarios(DAO dao)
    {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Juca");
        funcionario.setLogin("juca");
        funcionario.setSenha("juca123");
        funcionario.setPermissao("gerente");
        
        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("Angelo");
        funcionario2.setLogin("angelo");
        funcionario2.setSenha("angelo456");
        funcionario2.setPermissao("locador");
        
        dao.salvar(funcionario);
        dao.salvar(funcionario2);
        
        ArrayList <Funcionario> lista;
        lista = (ArrayList <Funcionario>) dao.consultar(Funcionario.class);
        
        System.out.println("\n\n### FUNCIONÁRIOS ###\n");
        
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getNome());
        }
    }
    
    public void clientes(DAO dao)
    {
        Cliente cliente = new Cliente();
        cliente.setNome("Antonio");
        cliente.setTelefone("11 22223333");
        
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria");
        cliente2.setTelefone("44 55556666");
        
        Cliente cliente3 = new Cliente();
        cliente3.setNome("Matheus");
        cliente3.setTelefone("22 66667777");
        
        dao.salvar(cliente);
        dao.salvar(cliente2);
        dao.salvar(cliente3);
        
        ArrayList <Cliente> lista;
        lista = (ArrayList <Cliente>) dao.consultar(Cliente.class);
        
        System.out.println("\n\n### CLIENTES ###\n");
        
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getNome());
        }
    }
    
    public void categoriasLivro(DAO dao)
    {
        CategoriaLivro categoria = new CategoriaLivro();
        categoria.setNome("Novo");
        categoria.setDescricao("Donec sollicitudin molestie malesuada.");
        categoria.setPreco(45.90);
        
        CategoriaLivro categoria2 = new CategoriaLivro();
        categoria2.setNome("Importado");
        categoria2.setDescricao("Donec sollicitudin molestie malesuada.");
        categoria2.setPreco(29.80);
        
        CategoriaLivro categoria3 = new CategoriaLivro();
        categoria3.setNome("Raro");
        categoria3.setDescricao("Donec sollicitudin molestie malesuada.");
        categoria3.setPreco(120.90);
        
        dao.salvar(categoria);
        dao.salvar(categoria2);
        dao.salvar(categoria3);
        
        ArrayList <CategoriaLivro> lista;
        lista = (ArrayList <CategoriaLivro>) dao.consultar(CategoriaLivro.class);
        
        System.out.println("\n\n### CATEGORIAS DE LIVRO ###\n");
        
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getNome());
        }
    }
    
    public void livros(DAO dao)
    {
        // Livro 1
        CategoriaLivro categoriaNovo = (CategoriaLivro) dao.consultar(CategoriaLivro.class).get(0);
        
        Livro livro = new Livro();
        livro.setNome("O Hobbit");
        livro.setCategoria(categoriaNovo);
        
        categoriaNovo.setLivros(new ArrayList());
        categoriaNovo.getLivros().add(livro);
        
        // Livro 2
        CategoriaLivro categoriaImportado = (CategoriaLivro) dao.consultar(CategoriaLivro.class).get(1);
        
        Livro livro2 = new Livro();
        livro2.setNome("A Cabana");
        livro2.setCategoria(categoriaImportado);
        
        categoriaImportado.setLivros(new ArrayList());
        categoriaImportado.getLivros().add(livro2);
        
        // Livro 3
        CategoriaLivro categoriaRaro = (CategoriaLivro) dao.consultar(CategoriaLivro.class).get(2);
        Livro livro3 = new Livro();
        livro3.setNome("Dom Casmurro");
        livro3.setCategoria(categoriaRaro);
        
        categoriaRaro.setLivros(new ArrayList());
        categoriaRaro.getLivros().add(livro3);
        
        // Livro 4
        Livro livro4 = new Livro();
        livro4.setNome("A Moreninha");
        livro4.setCategoria(categoriaRaro);
        
        categoriaRaro.getLivros().add(livro4);
        
        dao.salvar(livro);
        dao.salvar(livro2);
        dao.salvar(livro3);
        dao.salvar(livro4);
        
        ArrayList <Livro> lista;
        lista = (ArrayList <Livro>) dao.consultar(Livro.class);
        
        System.out.println("\n\n### LIVROS ###\n");
        
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getNome() + " - " + lista.get(i).getCategoria().getNome());
        }
    }
    
    public void emprestimos(DAO dao)
    {
        Date data = new Date();
        
        // Emprestimo 1
        Cliente cliente = (Cliente) dao.consultar(Cliente.class).get(0);
        
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setData_emprestimo(data);
        emprestimo.setStatus("em andamento");
        emprestimo.setCliente(cliente);
        
        cliente.setEmprestimos(new ArrayList());
        cliente.getEmprestimos().add(emprestimo);
        
        dao.salvar(emprestimo);
    }
    
    public void emprestimosItens(DAO dao)
    {
        Livro livro = (Livro) dao.consultar(Livro.class).get(0);
        Livro livro2 = (Livro) dao.consultar(Livro.class).get(1);
        
        Emprestimo emprestimo = (Emprestimo) dao.consultar(Emprestimo.class).get(0);
        
        EmprestimoItem emprestimoItem = new EmprestimoItem();
        EmprestimoItem emprestimoItem2 = new EmprestimoItem();
        
        emprestimoItem.setChaveComposta(new EmprestimoItemPk());
        emprestimoItem2.setChaveComposta(new EmprestimoItemPk());
        
        emprestimoItem.getChaveComposta().setLivro(livro);
        emprestimoItem2.getChaveComposta().setLivro(livro2);
        
        emprestimoItem.getChaveComposta().setEmprestimo(emprestimo);
        emprestimoItem2.getChaveComposta().setEmprestimo(emprestimo);
        
        emprestimoItem.setPreco_livro(livro.getCategoria().getPreco());
        emprestimoItem2.setPreco_livro(livro2.getCategoria().getPreco());
        
        dao.salvar(emprestimoItem);
        dao.salvar(emprestimoItem2);
        
        ArrayList <EmprestimoItem> lista;
        lista = (ArrayList <EmprestimoItem>) dao.consultar(EmprestimoItem.class);
        
        System.out.println("\n\n### EMPRÉSTIMOS ###\n");
        
        for (int i = 0; i < lista.size(); i++){
            System.out.println("Empréstimo para: " 
                + lista.get(i).getChaveComposta().getEmprestimo().getCliente().getNome());
            
            System.out.println("Livro: "
                + lista.get(i).getChaveComposta().getLivro().getNome());
            
            System.out.println("Preço: "
                + lista.get(i).getChaveComposta().getLivro().getCategoria().getPreco());
            
            System.out.println("Status: "
                + lista.get(i).getChaveComposta().getEmprestimo().getStatus());
            
            System.out.println("---------------------------------------");
        }
    }
}
