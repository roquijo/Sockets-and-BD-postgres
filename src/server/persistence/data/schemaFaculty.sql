CREATE TABLE public.faculty
(
    id_faculty int NOT NULL,
    name character varying(40) COLLATE pg_catalog."default" NOT NULL,
    code character varying(40) COLLATE pg_catalog."default" NOT NULL,
    image_faculty character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_faculty PRIMARY KEY (id_faculty)
)
    TABLESPACE pg_default;

ALTER TABLE public.Faculty OWNER to "postgres";