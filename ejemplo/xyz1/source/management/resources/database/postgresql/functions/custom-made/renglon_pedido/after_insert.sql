create or replace function renglon_pedido$after_insert_row$100() returns trigger as $$
begin
    update pedido set monto = monto + new.total where id = new.pedido;
    return null;
end;
$$ language plpgsql;
