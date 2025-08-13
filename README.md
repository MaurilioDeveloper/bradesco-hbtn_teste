# bradesco-hbtn_teste

Exercícios de testes com **JUnit**.

## 0x01/email
- `src/Pessoa.java`: método estático `emailValid(String)` que:
  - deve conter `@`
  - deve ter no **máximo 50 caracteres**
- `src/TesteEmail.java`: testes JUnit
  - `testar_email_com_arroba` → `assertTrue`
  - `testar_email_sem_arroba` → `assertFalse`
  - `testar_email_mais_50_caracteres` → `assertEquals(false, ...)`

## Dependências (Maven)
```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.2.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
Como rodar os testes
IDE: execute TesteEmail

Maven:

bash
Copiar
Editar
mvn -q test
