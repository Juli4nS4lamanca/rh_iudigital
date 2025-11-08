use rh_iudigital;

insert into estado_civil (estado_civil)
	values ('soltero(a)'), ('casado(a)'), ('viudo(a)'), ('union_libre');

insert into sexo (sexo)
	values ('masculino'), ('femenino'), ('no binario'), ('trans'), ('travesti');

insert into rol_familiar (rol_familiar)
	values ('madre'), ('padre'), ('hermano(a)'), ('abuelo(a)'), ('tio(a)'), ('hijo(a)'), ('esposo(a)');

insert into tipo_documento (tipo_documento)
	values ('cc'), ('ce'), ('pp'), ('pa');

insert into nivel_estudio (nivel_estudio)
	values ('tecnica'), ('tecnolgia'), ('profesional'), ('maestria'), ('doctorado');
