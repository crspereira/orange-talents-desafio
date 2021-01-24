create table tb_bet (id int8 generated by default as identity, bet_numbers varchar(255), creat_at TIMESTAMP WITHOUT TIME ZONE, updat_at TIMESTAMP WITHOUT TIME ZONE, player_id int8, primary key (id));
create table tb_player (id int8 generated by default as identity, creat_at TIMESTAMP WITHOUT TIME ZONE, email varchar(255), updat_at TIMESTAMP WITHOUT TIME ZONE, primary key (id));
alter table if exists tb_player add constraint UK_fd7werrv1csar5o70a7avwmu5 unique (email);
alter table if exists tb_bet add constraint FKhytadvjuu43nxnf97244vc220 foreign key (player_id) references tb_player;
