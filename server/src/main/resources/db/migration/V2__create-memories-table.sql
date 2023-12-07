DROP TABLE user;

CREATE TABLE user (
   id VARCHAR(36) NOT NULL,
   name VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   avatar_url VARCHAR(255) NOT NULL,
   CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE memory (
   id VARCHAR(36) NOT NULL,
   cover_url TEXT NOT NULL,
   content TEXT NOT NULL,
   is_public BIT(1) DEFAULT 0 NULL,
   created_at timestamp NULL,
   user_id VARCHAR(36) NOT NULL,
   CONSTRAINT pk_memory PRIMARY KEY (id)
);

ALTER TABLE memory ADD CONSTRAINT FK_MEMORY_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);