# MICROSERVICE NOTIFICATION

# Visão Geral
Um microserviço de notificação para visualização de eventos do usuário é um componente de software dedicado a gerenciar e fornecer informações sobre eventos relevantes ou atualizações associadas a um usuário específico em um sistema distribuído.

 
## Requisitos
 
- Java 17 
- Banco de dados MySQL
- Spring Boot
- RabbitMQ
- Docker
- JWT
 
## Configuração

1. Clone o repositório:
 
```bash
[https://github.com/Jeffleyg/MS-USER.git](https://github.com/Jeffleyg/MS-Notification.git)
 
2. Configure o banco de dados no arquivo `application.properties`.
 
3. Execute a aplicação:
 
```bash
mvn spring-boot:run
```
2. RabbitMQ

   ```bash
https://localhost:15762
 
 
O MS Notification tem a responsabilidade de receber e armazenar notificações de alteração de cadastro de usuário e login através de mensagens recebidas.
 
**Exemplo de resposta:**
```json
{
  "email": "maria@email.com",
  "event": "LOGIN",
  "date": "ISO-8601 DATE"
}

```

### Importante

```json
{
  
"Ele armazena os eventos do usuario no banco MongoDB tem que configurar o seu banco antes que ele seja foncional"
"percebi que o update_password está passando mal no consumer"
}
```

Este README serve como um guia para utilizar do MS Notificação, fornecendo informações sobre como configurar, usar e entender como ele se funciona.





