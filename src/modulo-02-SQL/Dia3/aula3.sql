
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
	DATEDIFF ( year , DataNascimento,  GETDATE()) as Idade
from Associado
--3
select nomeEmpregado, convert(datetime, DataAdmissao, 103) as Data_De_Emissao, 
		DATEDIFF ( MONTH , DataAdmissao, convert(datetime, '31/12/2000', 103 ))
from Empregado
where DataAdmissao between convert(datetime, '01/05/1980', 103 ) and convert(datetime, '20/01/1982', 103 )
--4
select top 1 WITH TIES
		cargo,
		count(1) as Total_Empregados			
from empregado
group by Cargo
order by Total_empregados desc;

--5
select LEN(nome), Nome
from associado
where LEN(nome) = (Select MAX(LEN(nome)) from Associado)

--6
select nome, Dateadd( year, 50, DataNascimento ) as Aniversario_50_Anos, 
			datename(dw, Dateadd( year, 50, DataNascimento ) )
from associado

--7
select UF, count(1) as Quantidade_Cidades
from Cidade
Group by UF

--8
select nome, UF, count(1) as Cidade_Duplicadas
from cidade
group by nome, UF
having count(1) > 1

--9
select max(IDAssociado) + 1 as ID_do_proximo
from associado

--10

insert into cidadeaux (IDCidade, Nome, UF )
(select  nome, UF
from cidade
group by nome, UF
having count(nome) = 1)

select *
from cidade

truncate table cidadeaux