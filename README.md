# JavaWebExample

Aplicação de testes em Java para Web utilizando as seguintes tecnologias:

- Struts 2.2.1.1
- Hibernate 3.6.2
- Hibernate Validator 4.1.0
- Tiles 2.2.2
- HTML Compressor 1.1 + Closure Compiler + YUICompressor 2.4.2
- PostgreSQL 8.4

Desenvolvido com NetBeans 6.9.1 e implantado em servidor Apache Tomcat 6.0.26.

## Criando o banco de dados:

     CREATE TABLE ordem(
      codigo Serial NOT NULL,
      cliente Character varying(80) NOT NULL,
      endereco Character varying(100) NOT NULL,
      descricao Text NOT NULL,
      valormaoobra Double precision NOT NULL,
      valormaterial Double precision NOT NULL,
      total Double precision NOT NULL
     )
     WITH (OIDS=FALSE)
     ;
     
     ALTER TABLE ordem ADD CONSTRAINT pk_ordem PRIMARY KEY (codigo)
     ;

## Arquivos de Configuração

- `/web/WEB-INF/web.xml`: arquivo principal de uma aplicação web java, nele são decalarados os FilterDispatchers, Servlet Filters, e outras configurações da aplicação como tablibs e listeners.
- `/web/WEB-INF/tiles.xml`: armazena as definições de templates do Tiles.
- `/src/java/struts.xml`: neste arquivo ficam as configurações específicas do framework Struts. Nele são declaradas várias configurações do framework, detre estas a declaração das actions da aplicação, estas podendo estar em outros arquivos e incluídas neste.
- `/src/java/hibernate.cfg.xml`: arquivo de configuração do ORM Hibernate. Define propriedades do framework e aspectos específicos do banco de dados utilizado, como usuário e senha, além dos arquivos de mapeamento de entidades.
- `/src/java/log4j.properties`: arquivo de configuração do log4j.

## Outros Arquivos

- `/src/java/global.properties`: arquivo global de configurações, pode ser acessado por qualquer action ou página `.jsp`.
- `/src/java/ValidationMessages.properties`: arquivo com as mensagens dos constraints do Hibernate Validator.
- `/src/java/com/app/controller/NomeDoController.properties`: nesse arquivo podem ser armazenadas mensagens ou qualquer outra informação que poderá ser usada pelas actions deste controlador ou pelas páginas JSP relacionadas.
- `/src/java/com/app/controller/NomeDoController.xml`: declaração das actions contidas em um controlador, este arquivo precisa ser incluído no `struts.xml`.

## Bibliotecas necessárias

    Persistence:
    ejb3-persistence.jar
    commons-fileupload-1.2.1.jar
    
    Struts2-2.2.1.1-Basic:
    commons-fileupload-1.2.1.jar
    commons-io-1.3.2.jar
    commons-logging-1.0.4.jar
    freemarker-2.3.16.jar
    ognl-3.0.jar
    struts2-core-2.2.1.1.jar
    xwork-core-2.2.1.1.jar
    
    Hibernate-3.6.2:
    antlr-2.7.6.jar
    c3p0-0.9.1.jar
    cglib-2.2.jar
    commons-collections-3.1.jar
    dom4j-1.6.1.jar
    ehcache-1.5.0.jar
    hibernate-jpa-2.0-api-1.0.0.Final.jar
    hibernate3.jar
    infinispan-core-4.2.1.CR1.jar
    javaassist-3.12.0.GA.jar
    jbosscache-core-3.2.1.GA.jar
    jta-1.1.jar
    oscache-2.1.jar
    slf4j-api-1.6.1.jar
    swarmcache-1.0RC2.jar
    
    HibernateValidator-4.1.0:
    hibernate-jpa-2.0-api-1.0.0.Final.jar
    hibernate-validator-4.1.0.Final.jar
    log4j-1.2.14.jar
    slf4j-api-1.5.6.jar
    slf4j-log4j12-1.5.6.jar
    validation-api-1.0.0.GA.jar
    
    HTMLCompressor-1.1:
    htmlcompressor-1.1.jar
    
    PostgreSQL-8.4.702:
    postgresql-8.4-702.jdbc3.jar
    
    Struts2-jQuery-Plugin:
    struts2-jquery-plugin-2.5.3.jar
    
    Tiles-2.2.2:
    commons-beanutils-1.8.0.jar
    commons-digester-2.0.jar
    jcl-over-slf4j-1.5.8.jar
    slf4j-api-1.5.8.jar
    struts2-tiles-plugin-2.2.1.1.jar
    tiles-api-2.2.2.jar
    tiles-compat-2.2.2.jar
    tiles-core-2.2.2.jar
    tiles-jsp-2.2.2.jar
    tiles-servlet-2.2.2.jar
    tiles-template-2.2.2.jar
    
    ClosureCompiler:
    compiler.jar
    
    YUICompressor-2.4.2:
    jargs-1.0.jar
    rhino-1.6R7.jar
    yuicompressor-2.4.2.jar
    
### Onde econtrá-las:
* [Struts](http://struts.apache.org/)
* [Hibernate](http://www.hibernate.org/)
* [HTML Compressor](http://code.google.com/p/htmlcompressor/)
* [Closure Compiler](http://code.google.com/p/closure-compiler/)
* [YUI Compressor](http://developer.yahoo.com/yui/compressor/)
* [PostgreSQL JDBC](http://jdbc.postgresql.org/)
* [Struts2 jQuery Plugin](http://code.google.com/p/struts2-jquery/)
* [Tiles](http://tiles.apache.org/)
