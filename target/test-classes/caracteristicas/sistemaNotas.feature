#language: pt
      @SistemaDeNotas
      Funcionalidade: Testar as operacoes basicas do sistema de notas
       
        Cenario: Testar inicializacao do sistema
          Dado o sistema inicializado
          Entao o sistema possui 0 estudantes cadastrados
       
       	Cenario: Testar cadastro
       		Dado o sistema inicializado
       		Quando eu adiciono um estudante com nome "Cristhian" e nota 2.0
       		E altero a nota do aluno com id 1 para 6.5
       		Entao o aluno com id 1 deve ter nome "Cristhian" e nota 6.5 
       	
       	Cenario: Testar remoção
       		Dado o sistema inicializado
       		Quando eu adiciono um estudante com nome "Cristhian" e nota 2.0
       		E eu adiciono um estudante com nome "Alan" e nota 5.0
       		E eu adiciono um estudante com nome "Robson" e nota 4.0
       		E removo o estudante "Alan"
       		Entao deve existir estudante com nome "Cristhian"
       		E deve existir estudante com nome "Robson"
       		Mas não deve existir estudante com nome "Alan"
       	
       	Cenario: Testar calculo de média
       		Dado o sistema inicializado
       		Entao a média de notas deve ser 0.0
       	
       	@comDados	
       	Cenario: Testar cálculo de média
       		Quando removo o estudante "Alan"
       		Entao a média de notas deve ser 4.5
       		
       	@comDados
       	Cenario: Estudantes aprovados
       		Dado nota aprovação é 5.0
       		Então estudante "Alan" deve estar aprovado
       		E estudante "Robson" deve estar aprovado
       		Mas estudante "Cristhian" deve estar reprovado
       	
       	@comDados
       	Cenário: Apagar todos os estudantes
       		Quando apago todos os estudantes
       		Então o sistema possui 0 estudantes cadastrados
       		
				Esquema do Cenario: Testar adicionar estudante
					Dado o sistema inicializado
					E nota aprovação é 5.0
					Quando eu adiciono um estudante com nome "<nome>" e nota <nota>
					Então o sistema possui 1 estudantes cadastrados
					E estudante "<nome>" deve estar aprovado
       		
       	
				Exemplos: 
    		| nome |nota|
				|Cristhian| 6.0  |
				|Robson | 5.0  |
				|Alan| 7.0 |
