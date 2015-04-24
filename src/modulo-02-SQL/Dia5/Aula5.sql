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
GROUP BY C.UF, A.Nome
-------------------------------------------------------------------------

--4
SELECT A.NOME, C.Nome, 
	CASE 
		WHEN UF = 'RS' OR UF = 'SC' OR UF = 'PR' THEN '***'
		ELSE ''
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
--Faça uma cópia da tabela Empregado e altere o salário de todos os empregados que o 
--departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%
--6

insert into cidadeaux (IDCidade, Nome, UF )
(select min(IDCidade), nome, UF
from cidade
group by nome, UF)

INSERT INT 

SELECT NOMEEMPREGADO, 
FROM EMPREGADO