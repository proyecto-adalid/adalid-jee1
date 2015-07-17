update cliente set jurisdiccion=jurisdiccion+10 where jurisdiccion<1000010;
delete from jurisdiccion where id<1000010;
update jurisdiccion j1 set superior=10*(id/10) where id <> 10*(id/10) and exists (select 1 from jurisdiccion j2 where j2.id=10*(j1.id/10));
update renglon_pedido set precio=(select precio from producto where producto.id=renglon_pedido.producto);
update renglon_pedido set total=cantidad*precio;
update pedido set monto=(select coalesce(sum(total),0) from renglon_pedido where renglon_pedido.pedido=pedido.id);
