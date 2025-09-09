public class Person {

    // Usuário válido:
    // - mínimo 8 caracteres
    // - apenas letras e números (sem caracteres especiais)
    public boolean checkUser(String user) {
        if (user == null) return false;
        return user.matches("^[A-Za-z0-9]{8,}$");
    }

    // Senha válida:
    // - mínimo 8 caracteres
    // - ao menos 1 maiúscula
    // - ao menos 1 número
    // - ao menos 1 caractere especial
    public boolean checkPassword(String password) {
        if (password == null) return false;
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }
}
