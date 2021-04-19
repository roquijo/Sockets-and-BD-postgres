CREATE TABLE public.player
(
    id_player int NOT NULL,
    name character varying(40) COLLATE pg_catalog."default" NOT NULL,
    position  character varying(40) COLLATE pg_catalog."default" NOT NULL,
    age int NOT NULL,
    name_of_team character varying(40) COLLATE pg_catalog."default" NOT NULL,
    image_player character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_player PRIMARY KEY (id_player),
    CONSTRAINT fk_nameOfTeam FOREIGN KEY (name_of_team)
    REFERENCES public.team(name)
)

    TABLESPACE pg_default;

ALTER TABLE public.player OWNER to "postgres";