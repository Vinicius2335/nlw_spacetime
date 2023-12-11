-- Inserindo um usuário
INSERT
INTO
  user
  (id, name, email, password, avatar_url)
VALUES
  ('cec9f64c-2983-42ac-987e-e180945e7377', 'Vinicius Vieira', 'vinicius@gmail.com', '$2a$10$/7G6Kth.H7fTkuAg2HLLb..bpcuQUxU.LQj0HbOKRqtWGajmq.ocC', 'https://github.com/spring-projects.png');
-- Senha devdojo

-- Criando memórias
INSERT
INTO
  memory
  (id, cover_url, content, user_id, is_public, created_at)
VALUES
  ('bc720f96-4f97-4d0a-bd52-53b3ac3d1ef3', 'https://github.com/spring-projects.png', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Integer enim neque volutpat ac tincidunt vitae. Mauris a diam maecenas sed enim ut sem viverra aliquet. Volutpat est velit egestas dui id. Curabitur gravida arcu ac tortor dignissim convallis aenean et. Nam aliquam sem et tortor consequat id porta nibh. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque. Non odio euismod lacinia at quis. Dolor morbi non arcu risus quis varius. Non consectetur a erat nam at lectus urna duis. Non odio euismod lacinia at quis risus sed vulputate odio. Et netus et malesuada fames ac turpis egestas maecenas pharetra. Imperdiet massa tincidunt nunc pulvinar sapien. Dictum fusce ut placerat orci nulla pellentesque. Senectus et netus et malesuada fames ac turpis egestas. Etiam non quam lacus suspendisse faucibus. Tellus in hac habitasse platea dictumst vestibulum rhoncus. Metus dictum at tempor commodo ullamcorper a. Aenean sed adipiscing diam donec adipiscing tristique risus nec feugiat. Facilisis leo vel fringilla est ullamcorper eget nulla facilisi etiam.', 'cec9f64c-2983-42ac-987e-e180945e7377', 1, NOW());