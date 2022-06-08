# Cadastro-api

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf_JdK6frnyA7H32vTW1WN_StbS8UetUPZTtWTnSoBOrg0IZORRM36vsFol5MMIp2G0kM&usqp=CAU" alt="exemplo imagem">

>Projeto com objetivo de praticar o uso de mensageria.
>A api [cadastro-api](https://github.com/LuizGGoncalves/cadastro-api) é responsavel pelo cadastro de novos usuarios
> e envio de uma mensagem para uma fila que é comsumida pela outra aplicaçao [compliance-service](https://github.com/LuizGGoncalves/compliance-service)
> que simula um compliance que libera ou nao o cadastro do usuario enviando uma mensagem para a outra fila que por sua vez é checada pela cadastro-api
> realizando as alteraçoes no banco de dados


### Criado Utilizando
* SpringBoot
* jackson
* RabbitMq

## Fluxo de Funcionamento

### Verificar Fila de Cadastro.
+ Verificar a fila de Cadastro.
+ Verificar informaçoes do usuario cadastrado.
+ Validar ou nao o cadastro
+ Enviar mensagem da situaçao do Cadastro para api-Cadastro
