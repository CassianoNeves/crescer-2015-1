BEGIN
	DECLARE @Nome VarChar(30)
	SET @Nome = 'CWI Software'
	Print @Nome
END

BEGIN
	DECLARE ListaCidade CURSOR
		Local
		Fast_Forward
		FOR Select Nome, Uf
			From Cidade
			Group by Nome, Uf
			Having COUNT(1) > 1;
	
	DECLARE @vNome varchar(50),
				@vUF varchar(2)
	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	
	WHILE (@@FETCH_STATUS=0) BEGIN
		Print @vNome + '/'+@vUF;
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	END
	
	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END
--------------------------------------------------------------------------
--1
BEGIN
	DECLARE @vIDPRODUTO VARCHAR(10),
			@vNOMEPROD VARCHAR(10),
			@vDATACADASTRO VARCHAR(10),
			@vPRECOCUSTO VARCHAR(10),
			@vPRECOVENDA VARCHAR(10),
			@vSITUACAO VARCHAR(10),
			@vQUANTIDADE INT

	SELECT TOP 1 @vIDPRODUTO = P.IDPRODUTO, @vNOMEPROD = P.NOME, @vDATACADASTRO = P.DATACADASTRO,
				 @vPRECOCUSTO = P.PRECOCUSTO, @vPRECOVENDA = P.PRECOVENDA, @vSITUACAO = P.SITUACAO, 
				 @vQUANTIDADE = COUNT(1)
	FROM PEDIDOITEM PI
	LEFT JOIN PRODUTO P ON PI.IDPRODUTO = P.IDPRODUTO
	GROUP BY P.IDPRODUTO, P.NOME, P.DATACADASTRO, P.PRECOCUSTO, P.PRECOVENDA, P.SITUACAO
	ORDER BY COUNT(1) DESC

	PRINT 'ID: ' + @vIDPRODUTO
	PRINT 'NOME: ' + @vNOMEPROD
	PRINT 'DATA CADASTRO: ' + @vDATACADASTRO
	PRINT 'CUSTO: ' + @vPRECOCUSTO
	PRINT 'VENDA: ' + @vPRECOVENDA
	PRINT 'SITUACAO: ' + @vSITUACAO
	PRINT 'QTD VENDAS: ' + CAST( @vQUANTIDADE AS VARCHAR(10))

END
--------------------------------------------------------------------------
--2
BEGIN
	DECLARE ListaCidade CURSOR
		LOCAL
		FAST_FORWARD
		FOR SELECT NOME
			FROM CIDADE
			WHERE IDCIDADE IN (SELECT IDCIDADE
							   FROM CLIENTE)
			GROUP BY NOME, UF
			HAVING COUNT(1) > 1;

	DECLARE @vCIDADE VARCHAR(20)

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vCIDADE

	WHILE (@@FETCH_STATUS = 0) BEGIN
		PRINT @vCIDADE;
		FETCH NEXT FROM ListaCidade INTO @vCIDADE	
	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END
--------------------------------------------------------------------------
--3
