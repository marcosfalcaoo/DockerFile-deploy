package br.com.dompizzaiolopizzas.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificadores
 * public
 * private
 * protected
 */

/**
 * String (texto)
 * Integer (int) números inteiros
 * Double (double) números decimais com vírgula 0,0000
 * Float (float)números de caracteres que terão 0,000
 * char carcteres
 * Date (data)
 * void ( quando não tem nenhum retorno do método)
 */

/**
 * Body ( dentro do corpo da requisição)
 * 
 */

// lombok é Uma biblioteca que facilita a criação de getters e setters no Java,
// entre outros métodos.

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserRepository userRepository;
  // private so pode ser acessado pela própria classe

  @PostMapping("/")
  // request body : Indica que os dados da requisição estarão no corpo da mensagem
  // e serão convertidos para o objeto especificado no parâmetro do método.
  public ResponseEntity create(@RequestBody UserModel userModel) {
    var user = this.userRepository.findByUsername(userModel.getUsername());

    if (user != null) {
      // precisamos retornar mensagem de erro
      // status code ( api dog)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
    }

    var passwordHashred = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword().toCharArray());

    userModel.setPassword(passwordHashred);

    var userCreated = this.userRepository.save(userModel);
    return ResponseEntity.status(HttpStatus.OK).body(userCreated);

  }
}
