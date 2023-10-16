package br.com.dompizzaiolopizzas.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

// a função da annotaion @data lambok é para Facilitar a criação de getters e setters para todos os atributos de uma classe.
@Data
@Entity(name = "tb_users") // geralmente quando se fala de entity, está se falando de tabelas
public class UserModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(unique = true)
  private String username;
  private String name;
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;
  // void não retorna nada
  // getters: usados para recuperar valores de atributos de uma clase / setters :
  // usados para definir valores para esses atributos
  // ou
  // definir valor para atributo privado de uma classe

  // bcrypt serve para Criptografar as senhas antes de armazená-las no banco de
  // dados.
  // os filtros criados na aula servem para o usuario permitir cadastro de uma
  // tarefa
  // o do filter serve para Permitir que a requisição continue seu fluxo normal de
  // processamento.
  // o header http : Um header HTTP é uma parte da requisição ou resposta HTTP que
  // contém informações sobre a requisição ou resposta.
}
