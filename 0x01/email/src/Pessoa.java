public class Pessoa {
    /**
     * Valida e-mail: deve conter '@' e ter no máximo 50 caracteres.
     */
    public static boolean emailValid(String email) {
        if (email == null) return false;
        if (email.length() > 50) return false;
        return email.contains("@");
    }
}
