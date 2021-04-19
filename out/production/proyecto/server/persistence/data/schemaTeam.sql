CREATE TABLE public.team
(
    name character varying(40) COLLATE pg_catalog."default" NOT NULL,
    captain character varying(40) COLLATE pg_catalog."default" NOT NULL,
    image_team character varying(100) COLLATE pg_catalog."default" NOT NULL,
    id_faculty int NOT NULL,
    CONSTRAINT pk_team PRIMARY KEY (name),
    CONSTRAINT fk_idFaculty FOREIGN KEY (id_faculty)
    REFERENCES public.faculty (id_faculty)
)

    TABLESPACE pg_default;

ALTER TABLE public.team OWNER to "postgres";