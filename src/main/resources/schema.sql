CREATE TABLE public.author (
	id bigserial NOT NULL,
	created_at timestamp NULL DEFAULT now(),
	"name" varchar(255) NULL,
	CONSTRAINT author_pkey PRIMARY KEY (id)
);

alter table author
add column x varchar(255) not null;


-------
CREATE TABLE public.book (
	id bigserial NOT NULL,
	genre varchar(255) NOT NULL,
	isbn varchar(255) NOT NULL unique,
	publishing_date timestamp(6) NULL,
	title varchar(255) NOT NULL,
	CONSTRAINT book_pkey PRIMARY KEY (id)
);



---------


CREATE TABLE public.author_book (
	book_id int8 NOT NULL,
	author_id int8 NOT NULL,
	CONSTRAINT author_book_pkey PRIMARY KEY (book_id, author_id),
	CONSTRAINT author_book_author_id FOREIGN KEY (author_id) REFERENCES public.author(id),
	CONSTRAINT author_book_book_id FOREIGN KEY (book_id) REFERENCES public.book(id)
);