create or replace function renglon_pedido$before_delete_row$100() returns trigger as $$
begin
    update pedido set monto = monto - old.total where id = old.pedido;
    return old;
end;
$$ language plpgsql;
