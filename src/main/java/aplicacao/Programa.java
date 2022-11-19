package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // Cadastro de pessoas:
        /*
        System.out.println();
        System.out.println("=== CADASTRO DE PESSOAS ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.nextLine();
        Pessoa pessoa = new Pessoa(null, nome, email);

        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
        System.out.println("Cadastro realizado com sucesso!");
        System.out.println();
        */

        // Filtro por ID:
        /*
        System.out.println();
        System.out.println("=== FILTRO DE PESSOAS POR ID ===");
        System.out.print("ID: ");
        Pessoa pessoa = em.find(Pessoa.class, sc.nextInt());
        System.out.println(pessoa);
        System.out.println();
        */

        // Exluindo cadastro:
        System.out.println();
        System.out.println("=== EXCLUINDO CADASTRO DE PESSOAS ===");
        System.out.print("ID: ");
        em.getTransaction().begin();
        Pessoa pessoa = em.find(Pessoa.class, sc.nextInt());
        em.remove(pessoa);
        em.getTransaction().commit();
        System.out.println("Cadastro excluído com sucesso!");

        em.close();
        emf.close();
        sc.close();

    }
}