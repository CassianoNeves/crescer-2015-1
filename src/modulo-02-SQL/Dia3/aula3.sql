
--1
select NomeEmpregado
from empregado
order by DataAdmissao
--2
select NomeEmpregado, (salario * 12) as SalarioAnual
from empregado
where cargo = 'Atendente' or (salario * 12) < 18500
--3
select IDCidade
from cidade
where nome = 'Uberlândia'
--4
select idcidade, nome
from cidade
where uf = 'RS'

--Mais exercicios
--1
select SUBSTRING(Nome, 1, CHARINDEX(' ', nome))
from associado

--2
select nome, 
	DATEDIFF ( year , DataNascimento,  SYSDATETIME()) as Idade
from Associado
--3
select nomeEmpregado, convert(datetime, DataAdmissao, 103) as Data_De_Emissao, 
		DATEDIFF ( MONTH , convert(datetime, DataAdmissao, 103), convert(datetime, '31/12/2000', 103 ))
from Empregado
where DataAdmissao between convert(datetime, '01/05/1980', 103 ) and convert(datetime, '20/01/1982', 103 )
--4
select top 1 cargo
from empregado
--5
select MAX(LEN(nome))
from associado
