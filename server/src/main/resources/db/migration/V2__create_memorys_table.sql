CREATE TABLE IF NOT EXISTS memory(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    cover_url TEXT NOT NULL,
    content TEXT NOT NULL,
    is_public BOOLEAN DEFAULT false,
    created_at DATETIME DEFAULT now(),
    user_id VARCHAR(36) NOT NULL
);

-- 1 Usuário poderá ter * memórias

ALTER TABLE memory
ADD CONSTRAINT fk_user_id
FOREIGN KEY (user_id)
REFERENCES user (id);