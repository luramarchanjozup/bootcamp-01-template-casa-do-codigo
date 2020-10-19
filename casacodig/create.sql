create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (autor_id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (autor_id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKnh3wptlxvdqhtmlspvtg4f94k foreign key (autor_autor_id) references autor (autor_id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (categoria_id bigint not null auto_increment, nome varchar(255), primary key (categoria_id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FKjgjukfh2h7xrqg2j2vqb4qv0t foreign key (categoria_categoria_id) references categoria (categoria_id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
create table autor (id bigint not null auto_increment, datacriacao datetime, descricao varchar(400), email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table categoria (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table livro (livro_id bigint not null auto_increment, data_publicacao datetime not null, isbn varchar(255), numero_paginas integer not null, preco decimal(19,2) not null, resumo varchar(500), sumario varchar(255), titulo varchar(255), autor_id bigint not null, categoria_id bigint not null, primary key (livro_id)) engine=InnoDB
alter table livro add constraint FKrp0atct0grsplospsqqay36vy foreign key (autor_id) references autor (id)
alter table livro add constraint FK823wf30ms4bomdmqk9xekpv6c foreign key (categoria_id) references categoria (id)
