# JavaWebExample

Aplicação de testes em Java para Web utilizando as seguintes tecnologias:

- Struts 2.1.1.1
- Hibernate 3.6.2
- Hibernate Validator 4.1.0
- Tiles 2.2.2
- HTML Compressor + Closure Compiler + YUICompressor
- PostgreSQL 8.4

Desenvolvido com NetBeans 6.9.1 e implantado em servidor Apache Tomcat 6.0.26.

## Criando o banco de dados:

    $ CREATE TABLE ordem(
    $  codigo Serial NOT NULL,
    $  cliente Character varying(80) NOT NULL,
    $  endereco Character varying(100) NOT NULL,
    $  descricao Text NOT NULL,
    $  valorMaoObra Double precision NOT NULL,
    $  valorMaterial Double precision NOT NULL,
    $  total Double precision NOT NULL
    $ )
    $ WITH (OIDS=FALSE)
    $ ;
    $ 
    $ ALTER TABLE ordem ADD CONSTRAINT pk_ordem PRIMARY KEY (codigo)
    $ ;

## Bibliotecas necessárias

- Persistence:
	-ejb3-persistence.jar
	
- Struts2-2.2.1.1-Basic
	-commons-fileupload-1.2.1.jar
	-commons-io-1.3.2.jar
	-commons-logging-1.0.4.jar
	-freemarker-2.3.16.jar
	-ognl-3.0.jar
	-struts2-core-2.2.1.1.jar
	-xwork-core-2.2.1.1.jar
	
- Hibernate-3.6.2
	-antlr-2.7.6.jar
	-c3p0-0.9.1.jar
	-cglib-2.2.jar
	-commons-collections-3.1.jar
	-dom4j-1.6.1.jar
	-ehcache-1.5.0.jar
	-ehcache-1.5.0.jar
	-hibernate-jpa-2.0-api-1.0.0.Final.jar
	-hibernate3.jar
	-infinispan-core-4.2.1.CR1.jar
	-javaassist-3.12.0.GA.jar
	-jbosscache-core-3.2.1.GA.jar
	-jta-1.1.jar
	-oscache-2.1.jar
	-slf4j-api-1.6.1.jar
	-swarmcache-1.0RC2.jar
	
- HibernateValidator-4.1.0
	-hibernate-jpa-2.0-api-1.0.0.Final.jar
	-hibernate-validator-4.1.0.Final.jar
	-log4j-1.2.14.jar
	-slf4j-api-1.5.6.jar
	-slf4j-log4j12-1.5.6.jar
	-validation-api-1.0.0.GA.jar
	
- HTMLCompressor-1.1
	-htmlcompressor-1.1.jar
	
- PostgreSQL-8.4.702
	-postgresql-8.4-702.jdbc3.jar
	
- Struts2-jQuery-Plugin
	-struts2-jquery-plugin-2.5.3.jar
	
- Tiles-2.2.2
	-commons-beanutils-1.8.0.jar
	-commons-digester-2.0.jar
	-jcl-over-slf4j-1.5.8.jar
	-slf4j-api-1.5.8.jar
	-struts2-tiles-plugin-2.2.1.1.jar
	-tiles-api-2.2.2.jar
	-tiles-compat-2.2.2.jar
	-tiles-core-2.2.2.jar
	-tiles-jsp-2.2.2.jar
	-tiles-servlet-2.2.2.jar
	-tiles-template-2.2.2.jar
	
- ClosureCompiler
	-compiler.jar
	
- YUICompressor-2.4.2
	-jargs-1.0.jar
	-rhino-1.6R7.jar
	-yuicompressor-2.4.2.jar
	
###Onde econtrá-las:
http://struts.apache.org/
http://www.hibernate.org/
http://code.google.com/p/htmlcompressor/
http://code.google.com/intl/pt-BR/closure/compiler/
http://developer.yahoo.com/yui/compressor/
http://jdbc.postgresql.org/
http://code.google.com/p/struts2-jquery/
http://tiles.apache.org/
