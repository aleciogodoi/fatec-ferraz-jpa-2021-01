CREATE VIEW v_Vendas AS
Select
 n.NR, 
 n.DATA,
 printf('%.2f',n.total) as 'TOTAL NF',
 (Select 
   printf("%.2f",SUM(TotalItem))
   From Item i2 
   Inner Join nota_item ni2 ON (i2.ID = ni2.itens_ID)
   Where ni2.Nota_NR = ni.Nota_NR
 ) As 'TOTAL NF CONF.',
 i.ID,
 i.PRECOUNITARIO,
 i.QUANTIDADE, 
 i.TOTALITEM,
 p.ID,
 p.NOME AS 'PRODUTO',
 c.ID,
 c.NOME AS 'CLIENTE'
From 
 nota n
Inner Join nota_item ni On (ni.Nota_NR = n.NR)
Inner Join item i ON (i.ID = ni.itens_ID)
Inner Join Produto p ON (i.PRODUTO_ID = p.ID)
Inner Join Cliente c ON (c.ID = n.CLIENTE_ID );
