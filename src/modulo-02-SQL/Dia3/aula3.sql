
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