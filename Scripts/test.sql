
select id, kind, price, image, country, height, weight, content, readcount from dog;

select id, kind, price, image, country, height, weight, content, readcount 
from dog
where id = 1 ;

insert into dog(kind,price,image,country,height,weight,content,readcount) values
	('허스키',4000,'h.jpg','북극',1,20,'멋지다',0);
	
update dog 
	set readcount = readcount +1
	where id =1;