# BASH 

- npx create-next-app@latest web --use-npm // iniciando o projeto com next
  - 'sim' para tudo
- npm i @rocketseat/eslint-config -D // config do eslint criado pela rocktseat
  - .eslintrc.json
    - "extends": ["next/core-web-vitals", "@rocketseat/eslint-config/react"]
  - package.json
    - scripts: "lint": "eslint src --ext .tsx --fix"
    - npm run lint
- npm i prettier-plugin-tailwindcss -D // plugin que ordena as classes do tailwind por uma ordem semantica, para deixar mais organizado
  - criar prettier.config.js

# Obs

- No next, toda subpasta dentro da pasta app, com um arquivo page.tsx, será uma rota da aplicaçao
- ignite/depoimentos, só criar uma pasta dentro da outra