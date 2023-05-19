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
- npm i lucide-react

# Obs

- No next, toda subpasta dentro da pasta app, com um arquivo page.tsx, será uma rota da aplicaçao
- ignite/depoimentos, só criar uma pasta dentro da outra

- Toda vez que salvamos uma imagem com o nome icon dentro da pasta app, ele automaticamente vai usar essa imagem como um favicon

- app -> page.tsx,
  - quando queremos criar algo centralizado na tela que tem o posicionamento absolute, usamos top-1/2 e -translate-y-1/2 translate-x-1/2

- .env.local 
  - todas as variaveis de ambiente que desejamos que seja expostas no front-end precisa começar com NEXT_PUBLIC