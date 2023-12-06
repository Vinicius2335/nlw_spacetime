# Bash

- `npx create-expo-app mobile`
  - renomear App.js -> App.tsx
  - npm run start
- `npm i nativewind` - NativeWind - tailwindcss para react native
  - `npm i tailwindcss -D`
  - `npx tailwindcss init`
  - tailwind.config.js -> `content: ["./App.tsx", "./app/**/*.tsx"],`
  - babel.config.js -> `plugins: ["nativewind/babel"],`
  - tsconfig.json -> `"compilerOptions": {"types": ["nativewind/types"]},`
- `npm i @rocketseat/eslint-config -D`
  - criar o arquivo .eslintrc.json
- `npm i prettier-plugin-tailwindcss -D`
  - criar o arquivo prettier.config.js