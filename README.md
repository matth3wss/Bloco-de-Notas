# Projeto com SQLite e JCalendar

Este é um projeto simples que utiliza o SQLite e o JCalendar para criar um bloco de notas que permite ao usuário criar notas e lembretes com data.

## Requisitos de instalação

- NetBeans IDE
- Java SE Development Kit (JDK)
- Biblioteca SQLite JDBC (sqlite-jdbc-3.40.0.0.jar)
- Biblioteca JCalendar (jcalendar-1.4.jar)

## O que meu projeto é/faz

Este projeto é um bloco de notas simples que permite ao usuário criar notas e lembretes com data. O usuário pode inserir texto e definir uma data para uma nota ou lembrete. As notas e lembretes são armazenados em um banco de dados SQLite local.

## O que o projeto não faz

Este projeto não inclui notificações para os lembretes. Além disso, a interface do usuário não foi desenvolvida para ser muito bonita, mas tem uma funcionalidade básica.

## Nota do desenvolvedor

Eu passei muitas horas desenvolvendo o banco de dados para que ele funcionasse com a interface gráfica do Java Swing e, infelizmente, ignorei o quanto a aparência era importante para a nota. No entanto, apesar de a interface não ser muito bonita, eu acredito que o projeto está funcionando corretamente e sem erros.

## Instalação e execução

1. Clone o repositório ou baixe os arquivos em uma pasta local.
2. Abra o projeto no NetBeans.
3. Certifique-se de que as bibliotecas SQLite JDBC e JCalendar foram adicionadas ao projeto.
4. Compile e execute o projeto.

## Uso

- Para criar uma nova nota, selecione "Criar nota" e preencha os campos de texto e data.
- Para criar um novo lembrete, selecione "Criar lembrete" e preencha os campos de texto e data.
- As notas e lembretes serão armazenados no banco de dados e podem ser visualizados a qualquer momento.
- Você pode editar ou excluir uma nota ou lembrete selecionando-o na lista.

## Contribuição

Se você quiser contribuir para este projeto, siga estas etapas:

1. Faça um fork do repositório.
2. Crie um novo branch com suas alterações: `git checkout -b minha-nova-feature`
3. Commit suas alterações: `git commit -m 'Adicionei uma nova feature'`
4. Envie seu branch para o repositório forkado: `git push origin minha-nova-feature`
5. Abra uma solicitação de pull para o repositório original.

## Créditos

Este projeto utiliza as seguintes bibliotecas:

- SQLite JDBC: https://github.com/xerial/sqlite-jdbc
- JCalendar: https://toedter.com/jcalendar/

## Licença

Este projeto é licenciado sob a licença MIT - consulte o arquivo LICENSE para obter detalhes.
