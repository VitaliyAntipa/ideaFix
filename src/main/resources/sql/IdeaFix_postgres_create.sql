-- Delete everything

ALTER TABLE IF EXISTS "users" DROP CONSTRAINT IF EXISTS "users_fk0";

ALTER TABLE IF EXISTS "idealist" DROP CONSTRAINT IF EXISTS "idealist_fk0";

ALTER TABLE IF EXISTS "idea" DROP CONSTRAINT IF EXISTS "idea_fk0";

ALTER TABLE IF EXISTS "idealist_idea" DROP CONSTRAINT IF EXISTS "idealist_idea_fk0";

ALTER TABLE IF EXISTS "idealist_idea" DROP CONSTRAINT IF EXISTS "idealist_idea_fk1";

ALTER TABLE IF EXISTS "idea_tag" DROP CONSTRAINT IF EXISTS "idea_tag_fk0";

ALTER TABLE IF EXISTS "idea_tag" DROP CONSTRAINT IF EXISTS "idea_tag_fk1";

ALTER TABLE IF EXISTS "comment" DROP CONSTRAINT IF EXISTS "comment_fk0";

ALTER TABLE IF EXISTS "comment" DROP CONSTRAINT IF EXISTS "comment_fk1";

ALTER TABLE IF EXISTS "report" DROP CONSTRAINT IF EXISTS "report_fk0";

ALTER TABLE IF EXISTS "report" DROP CONSTRAINT IF EXISTS "report_fk1";

ALTER TABLE IF EXISTS "idea_media" DROP CONSTRAINT IF EXISTS "idea_media_fk0";

ALTER TABLE IF EXISTS "user_idea" DROP CONSTRAINT IF EXISTS "user_idea_fk0";

ALTER TABLE IF EXISTS "user_idea" DROP CONSTRAINT IF EXISTS "user_idea_fk1";

DROP TABLE IF EXISTS "user_idea";

DROP TABLE IF EXISTS "users" cascade;

DROP TABLE IF EXISTS "idealist" cascade;

DROP TABLE IF EXISTS "idea" cascade;

DROP TABLE IF EXISTS "idealist_idea" cascade;

DROP TABLE IF EXISTS "tag" cascade;

DROP TABLE IF EXISTS "idea_tag" cascade;

DROP TABLE IF EXISTS "comment" cascade;

DROP TABLE IF EXISTS "report" cascade;

DROP TABLE IF EXISTS "idea_media" cascade;

DROP TABLE IF EXISTS "role" cascade;



-- Creation

CREATE TABLE "users" (
	"id" bigserial NOT NULL,
	"name" varchar(100) NOT NULL,
	"nick_name" varchar(30) NOT NULL UNIQUE,
	"password" varchar(60) NOT NULL,
	"role_id" bigint NOT NULL,
	"age" int ,
	"email" varchar(30) NOT NULL UNIQUE,
	"about" varchar(500),
	"picture" varchar,
	"city" varchar(60),
	"country" varchar(60) NOT NULL,
	"is_banned" bool NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "idealist" (
	"id" bigserial NOT NULL,
	"name" varchar(30) NOT NULL,
	"author_id" bigint NOT NULL,
	"is_private" BOOLEAN NOT NULL,
	CONSTRAINT idealist_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "idea" (
	"id" bigserial NOT NULL,
	"title" varchar(30) NOT NULL,
	"big_description" varchar(500) NOT NULL,
	"author_id" bigint NOT NULL,
	"date" DATE NOT NULL,
	"is_banned" bool NOT NULL,
	"views" BIGINT,
	CONSTRAINT idea_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "idealist_idea" (
	"idea_id" bigint NOT NULL,
	"list_id" bigint NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "tag" (
	"id" bigserial NOT NULL,
	"name" varchar(30) NOT NULL UNIQUE,
	CONSTRAINT tag_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "idea_tag" (
	"idea_id" bigint NOT NULL,
	"tag_id" bigint NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "comment" (
	"id" bigserial NOT NULL,
	"author_id" bigint NOT NULL,
	"idea_id" bigint NOT NULL,
	"text" varchar(280) NOT NULL,
	"date" DATE NOT NULL,
	CONSTRAINT comment_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "report" (
	"id" bigserial NOT NULL,
	"idea_id" bigint NOT NULL,
	"author_id" bigint NOT NULL,
	"report_text" varchar(280) NOT NULL,
	"date" DATE NOT NULL,
	CONSTRAINT report_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "idea_media" (
	"id" bigserial NOT NULL,
	"idea_id" bigint NOT NULL,
	"media_url" varchar(100) NOT NULL,
	CONSTRAINT idea_media_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "role" (
	"id" bigserial NOT NULL,
	"name" varchar(60) NOT NULL UNIQUE,
	CONSTRAINT role_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "user_idea" (
	"id" serial NOT NULL,
	"user_id" bigint NOT NULL,
	"idea_id" bigint NOT NULL,
	CONSTRAINT user_idea_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



ALTER TABLE "users" ADD CONSTRAINT "users_fk0" FOREIGN KEY ("role_id") REFERENCES "role"("id");

ALTER TABLE "idealist" ADD CONSTRAINT "idealist_fk0" FOREIGN KEY ("author_id") REFERENCES "users"("id")ON DELETE CASCADE;

ALTER TABLE "idea" ADD CONSTRAINT "idea_fk0" FOREIGN KEY ("author_id") REFERENCES "users"("id")ON DELETE CASCADE;

ALTER TABLE "idealist_idea" ADD CONSTRAINT "idealist_idea_fk0" FOREIGN KEY ("idea_id") REFERENCES "idea"("id")ON DELETE CASCADE;
ALTER TABLE "idealist_idea" ADD CONSTRAINT "idealist_idea_fk1" FOREIGN KEY ("list_id") REFERENCES "idealist"("id")ON DELETE CASCADE;


ALTER TABLE "idea_tag" ADD CONSTRAINT "idea_tag_fk0" FOREIGN KEY ("idea_id") REFERENCES "idea"("id")ON DELETE CASCADE;
ALTER TABLE "idea_tag" ADD CONSTRAINT "idea_tag_fk1" FOREIGN KEY ("tag_id") REFERENCES "tag"("id")ON DELETE CASCADE;

ALTER TABLE "comment" ADD CONSTRAINT "comment_fk0" FOREIGN KEY ("author_id") REFERENCES "users"("id")ON DELETE CASCADE;
ALTER TABLE "comment" ADD CONSTRAINT "comment_fk1" FOREIGN KEY ("idea_id") REFERENCES "idea"("id")ON DELETE CASCADE;

ALTER TABLE "report" ADD CONSTRAINT "report_fk0" FOREIGN KEY ("idea_id") REFERENCES "idea"("id")ON DELETE CASCADE;
ALTER TABLE "report" ADD CONSTRAINT "report_fk1" FOREIGN KEY ("author_id") REFERENCES "users"("id")ON DELETE CASCADE;

ALTER TABLE "idea_media" ADD CONSTRAINT "idea_media_fk0" FOREIGN KEY ("idea_id") REFERENCES "idea"("id")ON DELETE CASCADE;

ALTER TABLE "user_idea" ADD CONSTRAINT "user_idea_fk0" FOREIGN KEY ("user_id") REFERENCES "users"("id")ON DELETE CASCADE;
ALTER TABLE "user_idea" ADD CONSTRAINT "user_idea_fk1" FOREIGN KEY ("idea_id") REFERENCES "idea"("id")ON DELETE CASCADE;


-- Base values

INSERT INTO role (id, name) VALUEs (1,'USER');
INSERT INTO role (id, name) VALUEs (2,'ADMIN');
