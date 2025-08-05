# 📦 pocSpring

> Primeiros contatos com o Spring Boot. Projeto simples com CRUD e autenticação JWT.

---

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL / SupaBase
- Swagger / OpenAPI (`springdoc-openapi`)

---

## 📚 Sobre o Projeto

Este projeto é uma API REST desenvolvida como prova de conceito (PoC) para estudo. Ele implementa um CRUD de produtos com autenticação baseada em JWT.

### Funcionalidades:

- Cadastro de produtos
- Listagem, edição e exclusão de produtos
- Autenticação de usuários
- Proteção de endpoints com JWT

---

## 🔐 Autenticação

A API utiliza autenticação JWT. Para acessar endpoints protegidos, é necessário:

1. Fazer login via:  
   `POST /auth/login`  
   Corpo da requisição:
   ```json
   {
     "username": "seuUsuario",
     "password": "suaSenha"
   }

## Swagger

    http://localhost:8080/swagger-ui/index.htm

<img width="1695" height="909" alt="image" src="https://github.com/user-attachments/assets/c7e28136-9587-42cf-9eac-f36455c06c8f" />


   
