package br.com.dompizzaiolopizzas.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {

  UserModel findByUsername(String username);

  // interface : modelo ou contrato que temos dentro da aplicação, na interface
  // temos os nosso metodos mas não temos a implementação dos metodos, so podemos
  // definir.
}
