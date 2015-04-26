update associado
set idcidade = 1
where idassociado = 1;

update associado
set idcidade = 32
where idassociado = 3;

--EXERCICIOS DO SLIDE 5
--1
select e.NomeEmpregado, d.NomeDepartamento
from Empregado e
	left join Departamento d on e.IDDepartamento = d.IDDepartamento
-------------------------------------------------------------------------

--2
SELECT A.NOME, C.Nome
FROM ASSOCIADO A
	LEFT JOIN CIDADE C ON A.IDCIDADE = C.IDCIDADE
-------------------------------------------------------------------------

--3
SELECT C.UF, COUNT(1) AS QTD_CIDADE
FROM CIDADE C
	 LEFT JOIN ASSOCIADO A ON A.IDCIDADE = C.IDCIDADE
WHERE A.NOME IS NULL
GROUP BY C.UF

--OUTRA FORMA
SELECT C.UF, COUNT(1) AS TOTAL_CIDADES
FROM CIDADE C
WHERE NOT EXISTS(SELECT 1
				 FROM ASSOCIADO
				 WHERE ASSOCIADO.IDCIDADE = C.IDCIDADE)
GROUP BY C.UF
-------------------------------------------------------------------------

--4
SELECT A.NOME, C.Nome, 
	CASE 
		WHEN UF = 'RS' OR UF = 'SC' OR UF = 'PR' THEN '***'
		ELSE NULL
	END REGIAO
FROM ASSOCIADO A
	LEFT JOIN CIDADE C ON A.IDCIDADE = C.IDCIDADE
-------------------------------------------------------------------------

--5
SELECT E.NOMEEMPREGADO, G.NOMEEMPREGADO, D.NOMEDEPARTAMENTO AS DEPARTAMENTO
FROM EMPREGADO E
	LEFT JOIN EMPREGADO G ON E.IDEMPREGADO = G.IDGERENTE
	LEFT JOIN DEPARTAMENTO D ON D.IDDEPARTAMENTO = E.IDDEPARTAMENTO
-------------------------------------------------------------------------

--6
SELECT * INTO EMPREGADOAUX
FROM EMPREGADO

INSERT INTO EMPREGADOAUX
SELECT E.IDEMPREGADO, E.NOMEEMPREGADO, E.CARGO, E.IDGERENTE, E.DATAADMISSAO, 
	CASE D.LOCALIZACAO
		WHEN 'SAO PAULO' THEN E.SALARIO+(E.SALARIO*0.145)
		ELSE SALARIO
	END SALARIO,
	E.COMISSAO, E.IDDEPARTAMENTO
FROM EMPREGADO E
	LEFT JOIN DEPARTAMENTO D ON E.IDDEPARTAMENTO = D.IDDEPARTAMENTO
-------------------------------------------------------------------------

--7

SELECT SUM( SALARIO + (E.SALARIO *0.145)) - SUM( E.SALARIO )
FROM EMPREGADO E
	left join DEPARTAMENTO D ON D.IDDEPARTAMENTO = E.IDDEPARTAMENTO
WHERE D.LOCALIZACAO = 'SAO PAULO'

--OUTRA FORMA DE FAZER

SELECT SUM(EX.SALARIO - E.SALARIO)
FROM EMPREGADOAUX EX
	LEFT JOIN EMPREGADO E ON EX.IDEMPREGADO = E.IDEMPREGADO
-------------------------------------------------------------------

--8
SELECT E.NOMEEMPREGADO
FROM EMPREGADO E
	WHERE


SELECT MAX(SALARIO)
FROM EMPREGADO

