SELECT * FROM compra  
SELECT * from venta  

--dar de baja y dar de alta 

CREATE OR REPLACE FUNCTION fu_eliminar_activar(pcodigo integer, pestado boolean)
  RETURNS void AS
$BODY$
BEGIN
	update unidad_medida set estado = pestado where codigo = pcodigo;  
END;
$BODY$
  LANGUAGE 'plpgsql' 
  
---

SELECT * from unidad_medida    
--registrarUnidad de medida 
CREATE OR REPLACE FUNCTION fu_reg_unidad_medida(pnombre character varying, pdescripcion character varying)
  RETURNS void AS
$BODY$
BEGIN
	INSERT INTO unidad_medida(nombre, descripcion)
    VALUES (pnombre, pdescripcion);
END;
$BODY$
  LANGUAGE 'plpgsql' 


--- listar unidad de medida 

CREATE OR REPLACE FUNCTION fu_lista_unidad_medida(pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT codigo,nombre, descripcion  from unidad_medida  where estado = true;  
return lista; 
end 
$body$
language 'plpgsql'

-----
-- modificar unidad de medida 

CREATE OR REPLACE FUNCTION fu_modificar_unidad_medida(pnombre character varying, pdescripcion character varying, pcodigo integer)
RETURNS void AS
$BODY$
BEGIN
	update unidad_medida set nombre = pnombre, descripcion = pdescripcion
	where codigo = pcodigo; 
END;
$BODY$
LANGUAGE 'plpgsql' 

--------------

-----
-- LISTAR CATEGORIA DE PRODUCTOS 

CREATE OR REPLACE FUNCTION fu_lista_categoria_producto(pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT codigo_cat, nombre, descripcion from categoria_producto  where estado = pestado;   
return lista; 
end 
$body$
language 'plpgsql'

-------
--------
-- registrar categoria
CREATE OR REPLACE FUNCTION fu_reg_categoria_producto(pnombre character varying, pdescripcion character varying)
  RETURNS void AS
$BODY$
BEGIN
    INSERT INTO categoria_producto(nombre, descripcion)
    VALUES (pnombre, pdescripcion);
END;
$BODY$
  LANGUAGE 'plpgsql' 
  
----------
--elimiar y activar  categoria producto 

CREATE OR REPLACE FUNCTION fu__categoria_pro_eliminar_activar(pcodigo integer, pestado boolean)
  RETURNS void AS
$BODY$
BEGIN
	update categoria_producto set estado = pestado where codigo_cat = pcodigo;  
END;
$BODY$
  LANGUAGE 'plpgsql' 
  
-----

----------

---- modificar categoria producto 
CREATE OR REPLACE FUNCTION fu_modificar_categoria_producto(pnombre character varying, pdescripcion character varying, pcodigo integer)
RETURNS void AS
$BODY$
BEGIN
	UPDATE categoria_producto SET nombre=pnombre, descripcion=pdescripcion
	WHERE codigo_cat=pcodigo;
END;
$BODY$
LANGUAGE 'plpgsql'
----------


SELECT codigo,nombre, descripcion  from unidad_medida  where estado = true 
SELECT codigo_cat, nombre, descripcion from categoria_producto  where estado = true 


-----------
--- listar presentacion 
CREATE OR REPLACE FUNCTION fu_lista_presentacion(pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT p.codigo, p.nombre, u.nombre, cantidad, p.descripcion, u.codigo  
	from presentacion  p inner join unidad_medida u on (u.codigo=p.unidad_medida)
	where p.estado = pestado;  
return lista; 
end 
$body$
language 'plpgsql'

-----
-- registrar presentaciones
CREATE OR REPLACE FUNCTION fu_reg_presentacion(punidad_medida integer, pnombre character varying, pcantidad double precision, pdescripcion character varying)
  RETURNS void AS
$BODY$
BEGIN
    INSERT INTO presentacion(unidad_medida, nombre, cantidad, descripcion)
    VALUES (punidad_medida, pnombre, pcantidad, pdescripcion);
    
END;
$BODY$
  LANGUAGE 'plpgsql' 
  
----
SELECT * from presentacion  



-----
-- eliminar y activar presentacion

CREATE OR REPLACE FUNCTION fu_presentacion_eliminar_activar(pcodigo integer, pestado boolean)
  RETURNS void AS
$BODY$
BEGIN
	UPDATE presentacion SET estado=pestado
	WHERE codigo=pcodigo;
END;
$BODY$
  LANGUAGE 'plpgsql' 
  
----
SELECT * from presentacion  

SELECT p.codigo, p.nombre, u.nombre, cantidad  
from presentacion  p inner join unidad_medida u on (u.codigo=p.unidad_medida)
where p.estado = true 


SELECT * from presentacion  
SELECT * from unidad_medida  

SELECT * from usuario  


------------
--- lista de productos 

CREATE OR REPLACE FUNCTION fu_lista_productos(pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT p.codigo, p.nombre, p.categoria, c.nombre, p.color, p.descripcion, u.codigo as codigoUnidadMedida, u.nombre as unidadMedida
	from producto  p 
	inner join categoria_producto  c on (p.categoria = c.codigo_cat)
	inner join unidad_medida  u on ( u.codigo = p.unida_medida )
	WHERE p.estado = pestado; 
return lista; 
end 
$body$
language 'plpgsql'

-----------------
--- lista productos de busqueda 
CREATE OR REPLACE FUNCTION fu_lista_productos_busqueda(pestado boolean, pnombre character varying(100) )
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT p.codigo, p.nombre, p.categoria, c.nombre, p.color, p.descripcion, u.codigo as codigoUnidadMedida, u.nombre as unidadMedida
	from producto  p 
	inner join categoria_producto  c on (p.categoria = c.codigo_cat)
	inner join unidad_medida  u on ( u.codigo = p.unida_medida )
	WHERE p.estado = pestado and p.nombre like '%'||pnombre||'%'; 
return lista; 
end 
$body$
language 'plpgsql'

----------

SELECT * from unidad_medida  
SELECT * from producto  
----------


--

SELECT p.codigo, p.nombre, p.categoria, c.nombre, p.presentacion, pre.nombre, p.color, p.descripcion from producto  p 
inner join categoria_producto  c on (p.categoria = c.codigo_cat)
inner join presentacion pre on (pre.codigo = p.presentacion)
WHERE p.estado = true 

SELECT * from producto  
SELECT * from categoria_producto 
SELECT * from presentacion  

----
-- registrar producto 

CREATE OR REPLACE FUNCTION fu_reg_producto(pnombre character varying, pcategoria integer, pcolor character varying, pdescripcion character varying, punida_medida integer)
  RETURNS void AS
$BODY$
BEGIN
INSERT INTO producto(nombre, categoria, color, descripcion, unida_medida)
    VALUES (pnombre, pcategoria, pcolor, pdescripcion, punida_medida);    
END;
$BODY$
  LANGUAGE 'plpgsql'
  
SELECT * from unidad_medida 
 SELECT * from producto  
SELECT * from presentacion  
DELETE FROM presentacion 
DELETE FROM producto 
  ---------------
  ------
  ------ modificar producto 
  
CREATE OR REPLACE FUNCTION fu_modificar_producto(pnombre character varying, pcategoria integer, pcolor character varying, pdescripcion character varying, pcodigo integer, punida_medida integer)
  RETURNS void AS
$BODY$
BEGIN
 UPDATE producto SET categoria=pcategoria, color=pcolor, descripcion=pdescripcion, nombre=pnombre, unida_medida = punida_medida
 WHERE codigo=pcodigo;
END;
$BODY$
  LANGUAGE 'plpgsql'
  
 
  ------
---

DELETE FROM producto 
DELETE FROM categoria_producto 

DELETE FROM presentacion 

----- eliminar presentacion 

CREATE OR REPLACE FUNCTION fu_presentacion_eliminar_activar(pcodigo integer, pestado boolean)
  RETURNS void AS
$BODY$
BEGIN
	update presentacion set estado = pestado where codigo = pcodigo;  
END;
$BODY$
  LANGUAGE 'plpgsql' 

  SELECT * from presentacion  

----- modificar preosentacion 

CREATE OR REPLACE FUNCTION fu_presentacion_modificar(pnombre character varying, punidad_medida integer, pcantidad double precision, pdescripcion character varying, pcodigo integer)
  RETURNS void AS
$BODY$
BEGIN
	UPDATE presentacion SET nombre=pnombre, unidad_medida=punidad_medida, cantidad=pcantidad, descripcion=pdescripcion
	WHERE codigo = pcodigo;
END;
$BODY$
  LANGUAGE 'plpgsql' 


SELECT * from presentacion  

---------------
-- eliminar producto 

CREATE OR REPLACE FUNCTION fu_producto_eliminar_activar(pcodigo integer, pestado boolean)
  RETURNS void AS
$BODY$
BEGIN
	update producto set estado = pestado where codigo = pcodigo;  
END;
$BODY$
  LANGUAGE 'plpgsql' 
  
----------

SELECT * from producto  


--------------
-------proveedor 
CREATE OR REPLACE FUNCTION fu_reg_proveedor(pnombre character varying, pruc character(11), pdireccion character varying(200))
  RETURNS void AS
$BODY$
BEGIN
    INSERT INTO proveedor(nombre, ruc, direccion)
    VALUES (pnombre, pruc, pdireccion);  
END;
$BODY$
  LANGUAGE 'plpgsql'

SELECT * from proveedor  
--------

----
-- listar proveedor 
CREATE OR REPLACE FUNCTION fu_lista_proveedores(pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT codigo, nombre, ruc, direccion from proveedor  where estado = pestado; 
return lista; 
end 
$body$
language 'plpgsql'
----

SELECT codigo, nombre, ruc, direccion from proveedor  where estado = true 

DELETE FROM proveedor  

--------------
--- Eliminar y activar provedores 

CREATE OR REPLACE FUNCTION fu_proveedor_eliminar_activar(pcodigo integer, pestado boolean)
  RETURNS void AS
$BODY$
BEGIN
	update proveedor set estado = pestado where codigo = pcodigo;  
END;
$BODY$
  LANGUAGE 'plpgsql' 

SELECT * from proveedor  
---------

----
-- modificar proveedores

CREATE OR REPLACE FUNCTION fu_modificar_proveedor(pnombre character varying, pruc character(11), pdireccion character varying(200), pcodigo integer)
  RETURNS void AS
$BODY$
BEGIN
    UPDATE proveedor SET  nombre=pnombre, ruc= pruc, direccion=pdireccion
    WHERE codigo=pcodigo;
END;
$BODY$
  LANGUAGE 'plpgsql' 

SELECT fu_modificar_proveedor('modificad', '22222236547', 'modficado', 6)
---

SELECT * from proveedor  
SELECT * from producto  
SELECT * from presentacion  
----
--Detalle producto_precentacon 

CREATE OR REPLACE FUNCTION fu_reg_prod_presentacion( pcodigoproducto integer, pcodigopresentacion integer)
  RETURNS void AS
$BODY$
BEGIN
    INSERT INTO detalle_presentaciones(codigoproducto, codigopresentacion)
    VALUES(pcodigoproducto, pcodigopresentacion);
END;
$BODY$
  LANGUAGE 'plpgsql'
  ------------
  
  
SELECT fu_reg_prod_presentacion(9, 25)
SELECT * from producto  
SELECT * from presentacion  
SELECT * from detalle_presentaciones 

SELECT pre.codigo, pre.nombre, pre.cantidad  from producto p 
inner join detalle_presentaciones d on (p.codigo = d.codigoproducto)
inner join presentacion pre on (pre.codigo=d.codigopresentacion) 
where p.codigo = 8

SELECT codigo, nombre FROM presentacion  
----
SELECT * from detalle_presentaciones 
DELETE FROM detalle_presentaciones 

---------
--- listar presentaciones segun codigo de productos 
fu_lista_presentacion_producto
CREATE OR REPLACE FUNCTION fu_lista_presentacion_producto(pcodigo integer)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT pre.codigo, pre.nombre, pre.cantidad, uni.nombre  from producto p 
	inner join detalle_presentaciones d on (p.codigo = d.codigoproducto)
	inner join presentacion pre on (pre.codigo=d.codigopresentacion) 
	inner join unidad_medida  uni on (uni.codigo=pre.unidad_medida)
	where p.codigo = pcodigo; 
return lista; 
end 
$body$
language 'plpgsql'

-----------
SELECT * from producto  
DELETE FROM unidad_medida
DELETE FROM detalle_presentaciones 
DELETE FROM producto  
DELETE FROM presentacion  

---------------
------ regstro de compra

CREATE OR REPLACE FUNCTION fu_reg_compra( pserie character varying, pnumero_factura character varying, pproveedor integer, pfecha_compra date, pusuario integer, 
psub_total double precision, pigv  double precision, ptotal double precision, ptipo_compra integer)
  RETURNS integer AS
$BODY$
DECLARE
codigo integer;
BEGIN
  INSERT INTO compra(serie, numero_factura, proveedor, fecha_compra, usuario, sub_total, igv, total, tipo_compra)
  VALUES (pserie, pnumero_factura, pproveedor, pfecha_compra, pusuario, psub_total, pigv, ptotal, ptipo_compra);
  codigo = CURRVAL('compra_codigo_seq');
  return codigo;
END;
$BODY$
LANGUAGE 'plpgsql' 

    SELECT * from compra  
    DELETE FROM  compra 
    DELETE FROM detalle_compra  
-------
-- registro de detalle de la compra

CREATE OR REPLACE FUNCTION fu_reg_detalle_compra(pcodigo_compra integer, pcodigo_producto integer, pcantidad double precision, pcantidad_presentacion double precision, pcodigo_presentacion integer, pprecio_unitario double precision, pprecio_total double precision)
  RETURNS void AS
$BODY$
BEGIN
  INSERT INTO detalle_compra(codigo_compra, codigo_producto, cantidad, cantidad_presentacion, codigo_presentacion, precio_unitario, precio_total)
    VALUES (pcodigo_compra, pcodigo_producto, pcantidad, pcantidad_presentacion, pcodigo_presentacion, pprecio_unitario, pprecio_total);
    update producto  set stock = stock + pcantidad where codigo = pcodigo_producto; 
END;
$BODY$
  LANGUAGE 'plpgsql'
---

-----
--- Cambio de estado compra: anulacion de la compra

CREATE OR REPLACE FUNCTION fu_anular_compra(pestaco_compra boolean, pcodigo_compra integer )
RETURNS void AS
$BODY$
BEGIN
	update compra set estado = pestaco_compra where codigo = pcodigo_compra; 
END;
$BODY$
  LANGUAGE 'plpgsql'
  
  SELECT * from detalle_compra  
-----
---- Aumento de stock al anular la compra 

CREATE OR REPLACE FUNCTION fu_aumento_stock_producto(pcodigo_producto integer, pcantidad double precision)
RETURNS void AS
$BODY$
BEGIN
	update producto set stock = stock - pcantidad where codigo = pcodigo_producto;   
END;
$BODY$
  LANGUAGE 'plpgsql'

SELECT * from producto  
-----------
77088 
  

SELECT fu_anular_compra
SELECT  * from compra  

----
SELECT * from detalle_compra 
DELETE FROM detalle_compra  
SELECT * from detalle_compra  
SELECT * from producto 
SELECT * from presentacion   
DELETE FROM producto  
DELETE FROM presentacion 
DELETE FROM  detalle_presentaciones  
SELECT * from detalle_compra  
SELECT * from compra  

SELECT * from detalle_presentaciones  

------ listar presentacion por codigo de producto 

CREATE OR REPLACE FUNCTION fu_lista_presentacion_producto_codigo(pcodigo integer)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
		SELECT pre.codigo, pre.nombre, pre.cantidad, uni.nombre, pre.descripcion  from producto p 
	inner join detalle_presentaciones d on (p.codigo = d.codigoproducto)
	inner join presentacion pre on (pre.codigo=d.codigopresentacion) 
	inner join unidad_medida  uni on (uni.codigo=pre.unidad_medida)
	where p.codigo = pcodigo; 
return lista; 
end 
$body$
language 'plpgsql'
-----------------

----
--eliminar detalle de productos 

CREATE OR REPLACE FUNCTION fu_eliminar_presentaciones_detalle(ppresentacion integer, pcodigo_producto integer)
  RETURNS void AS
$BODY$
BEGIN
	DELETE FROM detalle_presentaciones  where codigoproducto = pcodigo_producto  and codigopresentacion = ppresentacion; 
END;
$BODY$
  LANGUAGE 'plpgsql'
  
-------
SELECT * from presentacion  
SELECT * from unidad_medida  
SELECT * from producto  

	SELECT pre.codigo, pre.nombre, pre.cantidad, uni.nombre, pre.descripcion  from producto p 
	inner join detalle_presentaciones d on (p.codigo = d.codigoproducto)
	inner join presentacion pre on (pre.codigo=d.codigopresentacion) 
	inner join unidad_medida  uni on (uni.codigo=pre.unidad_medida)
	where p.codigo = 18

SELECT * from presentacion  

SELECT * from detalle_presentaciones
  
DELETE FROM detalle_presentaciones  where codigoproducto = 18 and codigopresentacion = 37 

SELECT * from detalle_presentaciones  

SELECT * from producto  
SELECT * FROM presentacion  

SELECT * from detalle_compra  
SELECT * from producto  


SELECT nombre, pr.stock from producto 
from detalle_compra  dc inner join producto pr on (pr.codigo=dc.codigo_producto)
group by pr.nombre

SELECT * from producto  
SELECT * from detalle_presentaciones  
SELECT * from presentacion  
SELECT * from unidad_medida  
SELECT * from compra  

-----
--lista de productos segun stock 

SELECT pr.codigo, pr.nombre, pr.color, sum(dc.cantidad) AS TOTAL, u.nombre , pr.stock as stoskProducto 
from detalle_compra  dc 
inner join producto pr on (pr.codigo=dc.codigo_producto)
inner join detalle_presentaciones de_pre on (de_pre.codigoproducto=pr.codigo)
inner join presentacion pre on (pre.codigo = de_pre.codigopresentacioN)
inner join unidad_medida u on (u.codigo = pre.unidad_medida)
group by pr.codigo, pr.nombre, u.nombre, pr.stock 
-------------------


-----
--Compra Diaria de producto 
SELECT pr.codigo, pr.nombre, pr.color, sum(dc.cantidad) AS TOTAL, u.nombre as stoskProducto 
from compra co inner join detalle_compra  dc on (co.codigo=dc.codigo_compra)
inner join producto pr on (pr.codigo=dc.codigo_producto)
inner join unidad_medida u on (u.codigo=pr.unida_medida) 
where co.fecha_registro = now()::date 
--co.fecharegistro=now()::date
group by pr.codigo, pr.nombre, u.nombre
-------------------
SELECT * from compra  
DELETE FROM from unidad_medida  
DELETE FROM detalle_presentaciones  
DELETE FROM compra 
DELETE FROM detalle_compra  
DELETE FROM presentacion 


-----
--Compra mensual de producto 
SELECT pr.codigo, pr.nombre as producto, pr.color, sum(dc.cantidad) AS TOTAL, u.nombre as unidad_medida
from compra co inner join detalle_compra  dc on (co.codigo=dc.codigo_compra)
inner join producto pr on (pr.codigo=dc.codigo_producto)
inner join unidad_medida u on (u.codigo = pr.unida_medida)
where co.fecha_registro between '2015-02-1' and '2015-02-28'
group by pr.codigo, pr.nombre, u.nombre, pr.stock
ORDER BY pr.nombre
-------------------



SELECT * from compra  
select * from campanas
where fecha_inicio BETWEEN '2011-01-25'::DATE AND '2011-01-25'::DATE


SELECT * from compra  
SELECT * from detalle_compra  
//SELECT  current_date

            //SELECT  current_time
            //SELECT  now()
            //SELECT  now()::date
            //SELECT  now()::time

CREATE OR REPLACE FUNCTION fu_lista_tipo_venta(pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT codigo, nombre, descripcion from tipo_venta 
	where estado = pestado; 
	return lista; 
end 
$body$
language 'plpgsql'

-----------------

SELECT codigo, nombre, descripcion from tipo_venta where estado = true 
---------


------------
--- registro de venta 

CREATE OR REPLACE FUNCTION fu_reg_venta(pserie character varying(5), pnumero character varying(10), pcliente character varying(8), pfecha_venta date, pusuario integer, ptipo_venta integer, 
psub_total double precision, pigv double precision, ptotal double precision
)
  RETURNS integer AS
$BODY$
DECLARE
codigo integer;
BEGIN
    INSERT INTO venta(serie, numero, cliente, fecha_venta,usuario, tipo_venta, sub_total, igv, total)
    VALUES (pserie, pnumero, pcliente, pfecha_venta, pusuario, ptipo_venta, psub_total, pigv, ptotal);
    codigo = CURRVAL('venta_codigo_seq');
  return codigo;
END;
$BODY$
LANGUAGE 'plpgsql' 

SELECT sub_total, igv, total  from venta  
SELECT * from venta  
SELECT * FROM detalle_venta  
--------------------------------------
--- registro detalle venta 
CREATE OR REPLACE FUNCTION fu_reg_detalle_venta(pcodigo_venta integer, pcodigo_producto integer, pcantidad double precision, pprecio double precision, pcantidad_presentacion double precision, pprecio_total double precision, pcodigo_presentacion integer)
  RETURNS void AS
$BODY$
BEGIN
    INSERT INTO detalle_venta(codigo_venta, codigo_producto, cantidad, precio, cantidad_presentacion, precio_total, codigo_presentacion)
    VALUES (pcodigo_venta, pcodigo_producto, pcantidad, pprecio, pcantidad_presentacion, pprecio_total, pcodigo_presentacion);
    update producto  set stock = stock - pcantidad where codigo = pcodigo_producto; 
END;
$BODY$
  LANGUAGE 'plpgsql'

 
  SELECT * from detalle_venta
  SELECT * from presentacion    
  DELETE FROM detalle_venta  
----------------------------

  
  INSERT INTO detalle_venta(codigo_venta, codigo_producto, cantidad, precio)
    VALUES (pcodigo_compra, pcodigo_producto, pcantidad, pprecio);

----------


-------------------
--- CONSULTA PARA LA LISTA DE PRODUCTOS

SELECT pr.nombre, ca_pr.nombre as categoria, pr.color, pr.descripcion, pr.stock, u.nombre as unidad_medida
FROM producto pr inner join categoria_producto  ca_pr on (pr.categoria=ca_pr.codigo_cat)
inner join detalle_presentaciones de_pre on (de_pre.codigoproducto=pr.codigo)
inner join presentacion pre on (pre.codigo = de_pre.codigopresentacioN)
inner join unidad_medida u on (u.codigo = pre.unidad_medida)
where pr.estado = true 
-------------



SELECT * from unidad_medida  
SELECT * from presentacion  
SELECT * from detalle_presentaciones  
SELECT * FROM categoria_producto  

----------


----------------
-- ventas diarias de productos 
SELECT * from producto  
 
SELECT pr.codigo, pr.nombre,pr.color, sum(dv.cantidad) as cantidadTotal, u.nombre as unidad, sum(dv.precio*dv.cantidad_presentacion) as totalDinero ---, dv.cantidad_presentacion, dv.precio
from venta ve inner join detalle_venta  dv on (ve.codigo=dv.codigo_venta)
inner join producto pr on (pr.codigo=dv.codigo_producto)
inner join unidad_medida u on (u.codigo = pr.unida_medida)
where ve.fecha_registro = now()::date
--co.fecharegistro=now()::date
group by pr.codigo, pr.nombre, pr.color, u.nombre--, pre.codigo --, dv.cantidad, dv.cantidad_presentacion, dv.precio
order by pr.nombre

----
SELECT pr.codigo, pr.nombre,pr.color, sum(dv.cantidad) as cantidadTotal, sum(dv.precio*dv.cantidad_presentacion) as totalDinero from venta ve 
inner join detalle_venta dv on (ve.codigo=dv.codigo_venta)
inner join producto pr on (pr.codigo=dv.codigo_producto)
group by pr.codigo, pr.nombre, pr.color --, dv.cantidad, dv.cantidad_presentacion, dv.precio
order by pr.nombre
---



---
SELECT distinct u.nombre from  producto pr 
inner join detalle_presentaciones de_pre on (de_pre.codigoproducto=pr.codigo)
inner join presentacion pre on (pre.codigo = de_pre.codigopresentacioN)
inner join unidad_medida u on (u.codigo = pre.unidad_medida)
where pre.codigo = 37




SELECT * from detalle_compra  
SELECT * from presentacion  
SELECT (a.nombre ||  ' cantidad: ' || (Select sum(b.cantidad) 
FROM tabla_b b WHERE b.id = a.id) || '.' ) AS registro FROM 
tabla_a a WHERE a.id = 6







inner join detalle_presentaciones de_pre on (de_pre.codigoproducto=pr.codigo)

-------------------
SELECT * from detalle_presentaciones  
SELECT * from presentacion  
SELECT * from detalle_venta  

-----
DELETE FROM detalle_presentaciones  

SELECT * from producto  



-- ventas MENSUALES de productos 
SELECT * from producto  
 
SELECT pr.codigo, pr.nombre,pr.color, sum(dv.cantidad) as cantidadTotal, u.nombre as unidad, sum(dv.precio*dv.cantidad_presentacion) as totalDinero ---, dv.cantidad_presentacion, dv.precio
from venta ve inner join detalle_venta  dv on (ve.codigo=dv.codigo_venta)
inner join producto pr on (pr.codigo=dv.codigo_producto)
inner join unidad_medida u on (u.codigo = pr.unida_medida)
where ve.fecha_registro between '2015-02-1' and '2015-02-28'
--co.fecharegistro=now()::date
group by pr.codigo, pr.nombre, pr.color, u.nombre--, pre.codigo --, dv.cantidad, dv.cantidad_presentacion, dv.precio
order by pr.nombre
----




-----------
SELECT pr.nombre, ca_pr.nombre as categoria, pr.color, pr.stock, u.nombre as unidad_medida
FROM producto pr inner join categoria_producto  ca_pr on (pr.categoria=ca_pr.codigo_cat)
inner join unidad_medida u on (u.codigo = pr.unida_medida)
where pr.estado = true
-----------
SELECT * FROM producto  
-----------------
---- cambio de contraseña

CREATE OR REPLACE FUNCTION fu_cambio_password(ppassword character varying, pcodigo integer)
RETURNS void AS
$BODY$
BEGIN
	update usuario set contrasena = MD5(ppassword) where idusuario = pcodigo; 
END;
$BODY$
LANGUAGE 'plpgsql' 

SELECT fu_cambio_password('123', 1)
SELECT * from usuario  
SELECT  * from 
update usuario set contrasena = MD5('12345') where idusuario = 1

DELETE FROM detalle_compra  
DELETE FROM compra 


------------

SELECT * from compra  
SELECT 

SELECT pr.codigo, pr.nombre, pr.color, sum(dc.cantidad) AS TOTAL, u.nombre as stoskProducto 
from compra co inner join detalle_compra  dc on (co.codigo=dc.codigo_compra)
inner join producto pr on (pr.codigo=dc.codigo_producto)
inner join unidad_medida u on (u.codigo=pr.unida_medida) 
where co.fecha_registro = now()::date and co.tipo_compra = 2
group by pr.codigo, pr.nombre, u.nombre

SELECT * from compra  where tipo_compra = 1
SELECT * from tipo_venta 
SELECT * from venta  


------------------
--- lista de compras_ busqueda 
CREATE OR REPLACE FUNCTION fu_lista_compras(pcodigo integer, pserie character varying, pnumero character varying, pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 

	SELECT tc.nombre, pro.nombre, co.fecha_compra, co.sub_total, co.igv, co.total 
	FROM compra co 
	inner join tipo_venta tc on (co.tipo_compra=tc.codigo)
	inner join proveedor pro on (pro.codigo=co.proveedor)
	where co.estado = pestado and co.serie = pserie and co.numero_factura = pnumero and co.codigo = pcodigo; 
	return lista; 
end 
$body$
language 'plpgsql'

SELECT * from compra  
SELECT * from compra  where estado = true 


--- lista de compras_ busqueda_detalle
CREATE OR REPLACE FUNCTION fu_lista_compras_detalle(pcodigo integer)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT pr.nombre, dc.cantidad, dc.cantidad_presentacion, pre.nombre 
	from detalle_compra  dc 
	inner join producto pr on (dc.codigo_producto = pr.codigo)
	inner join presentacion pre on (pre.codigo = DC.codigo_presentacion)
	WHERE dc.codigo_compra=pcodigo; 
return lista; 
end 
$body$
language 'plpgsql'

--------------
----

CREATE OR REPLACE FUNCTION fu_lista_compras_serie_numero(pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor;  
begin 
	OPEN lista FOR 
	SELECT co.codigo, co.serie, co.numero_factura, tc.nombre  from compra  co
	inner join tipo_venta tc on (co.tipo_compra = tc.codigo)
	where co.estado = pestado
	order by co.serie, co.numero_factura; 
	return lista; 
end 
$body$
language 'plpgsql'

--- lista los detalles de compra

create or replace function fu_lstar_detalle_compra(pcodigo integer)
returns refcursor as 
$body$
declare 
lista refcursor; 
begin
	open lista FOR
	SELECT pr.nombre, pre.nombre, dc.cantidad_presentacion, dc.precio_unitario, dc.precio_total, pr.color, dc.cantidad, dc.codigo_producto
	from detalle_compra  dc 
	inner join producto pr on (dc.codigo_producto = pr.codigo)
	inner join presentacion pre on (pre.codigo = DC.codigo_presentacion)
	where dc.codigo_compra=pcodigo; 
	return lista; 
end 
$body$
language 'plpgsql'


SELECT * from producto  
SELECT * from detalle_compra  
SELECT fu_lstar_detalle_compra(80)
SELECT * FROM compra
SELECT * from detalle_compra  

SELECT fu_lista_compras_serie_numero()
-------------
SELECT * from tipo_venta 
SELECT *from compra  
ORDER BY serie, numero_factura 

SELECT co.codigo, co.serie, co.numero_factura, tc.nombre  from compra  co inner join tipo_venta tc on (co.tipo_compra = tc.codigo)
SELECT * from compra  

SELECT * from detalle_compra  
SELECT * FROM compra  





SELECT * from detalle_compra  
SELECT * from compra  

SELECT * from detalle_compra  

DELETE FROM detalle_compra  

SELECT * from tipo_venta 
SELECT * from detalle_compra dv
inner join producto pr on (dv.codigo_producto=pr.codigo)


------
SELECT * from producto  
Ladrillo : 67088 unidada 
Elimnare: 5000
Cemento: 184860 
eliminare: 225


----------
---lista de ventas, serie y numero
create or replace function fu_lstar_ventas_serie_numero(pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor; 
begin
open lista FOR
	SELECT v.codigo, v.serie, v.numero, tv.nombre 
	from venta v  
	inner join tipo_venta tv on (tv.codigo=v.tipo_venta)
	where v.estado = pestado
	order by v.serie, v.numero; 
return lista; 
end 
$body$
language 'plpgsql'
------


--------
--- me lista la venta 
create or replace function fu_lstar_venta(pcodigo integer, pserie character varying, pnumero character varying,  pestado boolean)
returns refcursor as 
$body$
declare 
lista refcursor; 
begin
open lista FOR
	SELECT tv.nombre, v.cliente, v.fecha_venta, v.sub_total, v.igv, v.total 
	from venta v  
	inner join tipo_venta tv on (tv.codigo=v.tipo_venta)
	where v.estado = pestado and v.codigo = pcodigo and v.serie = pserie and v.numero = pnumero
	order by v.serie, v.numero; 
return lista; 
end 
$body$
language 'plpgsql'

----

-----------
--- listar detalle venta 

create or replace function fu_lstar_venta_detalle(pcodigo_venta integer)
returns refcursor as 
$body$
declare 
lista refcursor; 
begin
open lista FOR

	SELECT p.codigo, p.nombre, pr.nombre,dv.cantidad_presentacion, dv.precio, dv.precio_total, dv.cantidad, p.color 
	from detalle_venta dv 
	inner join producto p  on  (dv.codigo_producto = p.codigo) 
	inner join presentacion pr on ( pr.codigo = dv.codigo_presentacion)
	where dv.codigo_venta = pcodigo_venta; 	
	
return lista; 
end 
$body$
language 'plpgsql'
----


SELECT * from venta  
DELETE FROM venta 
SELECT * from compra   
SELECT * from detalle_venta  
SELECT * from detalle_compra  
SELECT * from presentacion 

SELECT p.codigo, p.nombre, pr.nombre,dv.cantidad_presentacion, dv.precio, dv.precio_total, dv.cantidad from detalle_venta dv 
inner join producto p  on  (dv.codigo_producto = p.codigo) 
inner join presentacion pr on ( pr.codigo = dv.codigo_presentacion)
where dv.codigo_venta = 59



SELECT v.codigo, v.serie, v.numero, tv.nombre, v.cliente, v.fecha_venta 
from venta v  
inner join tipo_venta tv on (tv.codigo=v.tipo_venta)
where v.estado = true and v.codigo = 52 and v.serie = '00002' and v.numero = '0000000022'
order by v.serie, v.numero



SELECT * from tipo_venta  
SELECT * from venta  
SELECT * from

-------
---- anulacion de venta 
------------------

CREATE OR REPLACE FUNCTION fu_anular_venta(pcodigo integer, pestado boolean)
RETURNS void AS
$BODY$
BEGIN
	UPDATE venta SET estado = pestado where codigo = pcodigo;  
END;
$BODY$
LANGUAGE 'plpgsql' 

---- auemnto de stock 

CREATE OR REPLACE FUNCTION fu_aumento_stock_prducto_anular_venta(pcodigo integer, pstock double precision)
RETURNS void AS
$BODY$
BEGIN
	UPDATE producto SET stock = stock + pstock  where codigo = pcodigo; 
END;
$BODY$
LANGUAGE 'plpgsql' 



SELECT * from producto  

ladrillo hueco 37014.84

UPDATE producto  SET stock = 0 
DELETE FROM detalle_compra  
DELETE FROM detalle_venta  
DELETE FROM compra;  
DELETE FROM venta;  
-------------------------
SELECT * from producto  

SELECT * from venta  

49004.84

