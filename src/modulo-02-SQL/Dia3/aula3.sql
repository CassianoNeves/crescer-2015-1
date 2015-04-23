
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
			datename(dw, Dateadd( year, 50, DataNascimento ) ) as Dia_da_Semana
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
select ISNULL(max(IDAssociado),0) + 1 as ID_do_proximo
from associado

--10
insert into cidadeaux (IDCidade, Nome, UF )
(select min(IDCidade), nome, UF
from cidade
group by nome, UF)

truncate table cidadeaux

--11)Altere todas cidades duplicadas (nome e uf iguais), acrescente no ínicio do nome um asterisco (*).

begin transaction
update cidade set nome = ('*'+ nome)
where nome in (
	select  nome
	from cidade
	group by nome
	having count(1) > 1)

commit

rollback

--12)Faça uma consulta que liste o nome do Associado e a descrição da coluna Sexo, informando: Masculino ou Feminino.

select nome, replace(replace(sexo, 'M', 'Masculino'), 'F', 'Feminino')
from associado

--13)Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser descontado do Imposto de Renda, 
--considerando a tabela abaixo:
--Até R$ 1.164,00 = 0% De R$ 1.164,00 a R$ 2.326,00 = 15%
--Acima de R$ 2.326,00 = 27,5%.

select NomeEmpregado, salario, 
	case
		when salario < 1164 then '0%'
		when salario > 1164 and salario < 2326 then '15%'
		when salario > 2326 then '27,5%'
	end
from empregado

--14)Elimine as cidades duplicadas (mantendo 1 registro para cada).
--15)Adicione uma regra que impeça exista mais de uma cidade com o mesmo nome em um estado.