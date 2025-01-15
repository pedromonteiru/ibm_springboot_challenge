Como testar a aplicação TechManager:

# **Pré-requisitos**:
- MySQL
- Java 21
- Insomnia

# **Configurar MySQL**
- Abrir o arquivo application.properties
- Colar a seguinte configuração:

```Application Properties
spring.application.name=ibm.challenge

#Data Source Config
spring.datasource.url=jdbc:mysql://localhost:3306/{NOME_DO_BANCO}
spring.datasource.username=root
spring.datasource.password={SENHA_DO_BANCO}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#JPA CONFIG
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.default_schema=MYSQL

#Port
server.port=8080
```
>**Atenção**: É necessário criar o banco de dados com o nome caso não possua, e adicionar na linha {NOME_DO_BANCO}, e sua senha no campo {SENHA_DO_BANCO}
#  **Compilar o programa**
- Ir no arquivo `/src/main/java/br/com/sprinmgboot/ibm/challenge/Application.java`.
- Compilar o programa.

# **Testar a aplicação**
- Copiar os endpoints e utilizar a função do Insomnia *IMPORT FROM CURL*


   1)   ### **Endpoint Adicionar Usuário:**
        ```
        curl --request POST \
           --url http://localhost:8080/api/users 
            --header 'Content-Type: application/json' 
            --header 'User-Agent: insomnia/10.1.1' 
            --data '{
            "fullName": "Nome Padrão ",
            "email": "teste@gmail.com",
            "phone": "+55 14 99999-9999",
            "birthDate": "12-01-2025",
            "userType": "EDITOR"
            }
        ```
        #### **Padrão dos campos:**
  
        *fullName*: Sem padrões

        *email*: xxxx@email.com
  
        *phone*: +DDI DDD NNNNN-NNNN
   
        *birthDate*: DD - MM - AAAA

        *userType*: EDITOR / ADMIN / VIEWER
        >**Observação**: DDD e DDI são numéricos de 2 dígitos.
        
        >**Observação2**: DD = Dia(2) // MM = Mês(2) // AAAA = Ano(4)



  2)   ### **Endpoint Atualizar Usuário pelo ID:**
       ```
       curl --request PUT \
       --url http://localhost:8080/api/users/{USER_ID} \
       --header 'Content-Type: application/json' \
       --header 'User-Agent: insomnia/10.1.1' \
       --data '{
       "fullName": "Nome ATT",
       "email": "testeAtt@gmail.com",
       "phone": "+55 14 98888-9999",
       "birthDate": "27-03-1999",
       "userType": "viewer"
       }
       ```
       #### **Argumento do Endpoint:**

       *Passar o Id so usuário como argumento*.

       #### **Padrão dos campos:**

       *fullName*: Sem padrões

       *email*: xxxx@email.com

       *phone*: +DDI DDD NNNNN-NNNN

       *birthDate*: xxxx@email.com

       *userType*: EDITOR / ADMIN / VIEWER
       >**Observação**: DDD e DDI são numéricos de 2 dígitos.
       
       >**Observação2**: DD = Dia(2) // MM = Mês(2) // AAAA = Ano(4)


  3)   ### **Ver todos usuários:**
       ```
       curl --request GET \
       --url http://localhost:8080/api/users \
       --header 'Content-Type: application/json' \
       --header 'User-Agent: insomnia/10.1.1'
       ```
       

  4)   ### **Ver usuário pelo ID:**
       ```
       curl --request GET \
       --url http://localhost:8080/api/users/{USER_ID}} \
       --header 'Content-Type: application/json' \
       --header 'User-Agent: insomnia/10.1.1'
       ```
       #### **Argumento do Endpoint:**

       *Passar o Id do usuário como argumento*.


5)   ### **Deletar usuário pelo ID:**
     ```
     curl --request DELETE \
     --url http://localhost:8080/api/users/{USER_ID} \
     --header 'Content-Type: application/json' \
     --header 'User-Agent: insomnia/10.1.1'
     ```

     #### **Argumento do Endpoint:**
     *Passar o Id do usuário como argumento*.