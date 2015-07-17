drop trigger if exists renglon_pedido$after_insert_row$100 on renglon_pedido cascade;
create trigger renglon_pedido$after_insert_row$100 after insert on renglon_pedido
    for each row execute procedure renglon_pedido$after_insert_row$100();

drop trigger if exists renglon_pedido$after_update_row$100 on renglon_pedido cascade;
create trigger renglon_pedido$after_update_row$100 after update on renglon_pedido
    for each row execute procedure renglon_pedido$after_update_row$100();

drop trigger if exists renglon_pedido$before_delete_row$100 on renglon_pedido cascade;
create trigger renglon_pedido$before_delete_row$100 before delete on renglon_pedido
    for each row execute procedure renglon_pedido$before_delete_row$100();

