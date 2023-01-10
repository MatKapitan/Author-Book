CREATE TABLE public.author (
	id bigserial NOT NULL,
	created_at timestamp NULL DEFAULT now(),
	"name" varchar(255) NULL,
	CONSTRAINT author_pkey PRIMARY KEY (id)
);

alter table author
add column x varchar(255) not null;