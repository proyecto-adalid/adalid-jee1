create or replace function renglon_pedido$after_update_row$100() returns trigger as $$
begin
    if (new.total <> old.total) then
        update pedido set monto = monto + new.total - old.total where id = new.pedido;
    end if;
    return null;
end;
$$ language plpgsql;
