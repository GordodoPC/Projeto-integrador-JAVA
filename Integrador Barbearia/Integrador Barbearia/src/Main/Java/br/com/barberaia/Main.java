package br.com.barbearia;

import br.com.barbearia.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("Conexão com o banco realizada com sucesso!");
        em.close();
    }
}
